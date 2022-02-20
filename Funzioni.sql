/*----------------------------------------------------------------------*/
/*1ok		Funzione che aggiunge il prefisso ins_	a username 	 		*/
create or replace function trigger_function_usernameins()
returns trigger
language plpgsql
as 
$$
declare 
	username varchar;
	begin
		select new.username
		into username
		from insegnante;
 		
		new.username='ins_'||new.username;
	return new;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_insegnante
before insert or update on insegnante
for each row
execute procedure trigger_function_usernameins();

ALTER TABLE insegnante
ENABLE TRIGGER trigger_insegnante;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*2ok		Funzione che aggiunge il prefisso stud_ a username			*/
create or replace function trigger_function_usernamestud()
returns trigger
language plpgsql
as 
$$
declare 
	username varchar;
	begin
		select new.username
		into username
		from studente;
		
		new.username='stud_'||new.username;
	return new;
end$$;

/*			Trigger che gestisce la funzione e abilitazione			*/
create trigger trigger_studente
before insert or update on studente
for each row
execute procedure trigger_function_usernamestud();

ALTER TABLE studente
ENABLE TRIGGER trigger_studente ;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*3OK		Funzione che  controlla che dataoperazione<datatest			*/
create or replace function trigger_function_gestione()
returns trigger
language plpgsql
as 
$$
declare 
		datat timestamp;
		dataoperazione1 date;

begin
	
	

		if (date(new.datatest)>date(new.dataoperazione)) then
			return new;
			else return dataoperazione1,'Errore: Operazione non possibile';
			
		end if;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_gestione
before insert on test
for each row
execute procedure trigger_function_gestione();

ALTER TABLE test
ENABLE TRIGGER trigger_modify_gestione ;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*4OK		Funzione che controlla che l'esito sia aggiornato			|
|						in base al punteggiominpos						*/
create or replace function trigger_function_testScelti()
returns trigger
language plpgsql
as $$
DECLARE
pmp int;
pt int;
begin
	select punteggiominpos, punteggiotot
	into pmp, pt
	from testscelti natural join test
	where testscelti.idt=new.idt and test.idt=new.idt and testscelti.matricola=new.matricola;
	update testScelti
	set esito = 'Non disponibile'
	where pt = NULL and matricola=new.matricola and testscelti.idt=new.idt;

	update testScelti
	set esito = 'Promosso'
	from test
	where pt >= pmp and matricola=new.matricola and testscelti.idt=new.idt;

	update testScelti
	set esito = 'Bocciato'
	from test
	where pt < pmp and matricola=new.matricola and testscelti.idt=new.idt;
	
	return new;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_testScelti
after update of punteggiotot on testScelti
for each row
execute procedure trigger_function_testScelti();

ALTER TABLE testScelti
ENABLE TRIGGER trigger_modify_testScelti ;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*ok5	Funzione che calcola che testo domanda sia <maxcaratteri		*/
create or replace function trigger_function_rispostA()
returns trigger
language plpgsql
as 
$$

declare 
   testo varchar;
	maxchar int;
begin
   select new.testorisposta
   into testo
   from rispostaAperta;
   select quizAperta.maxcaratteri
   into maxchar
   from quizAperta natural join rispostaAperta;
	
   assert length(testo) <= maxchar, 'Troppi caratteri';
   return new;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_rispostA
before update of testorisposta on rispostaAperta
for each row
execute procedure trigger_function_rispostA();

ALTER TABLE rispostaAperta
ENABLE TRIGGER trigger_modify_rispostA;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*OK6 Funzione che controlla che punteggiomin<punteggioassegnato<punteggiomax*/
create or replace function trigger_function_controlloValutazione()
returns trigger
language plpgsql
as 
$$

declare 
	punteggAss integer;
	punteggMin integer;
	punteggMax integer;

begin
   select new.punteggioAssegnato
   into punteggAss
   from rispostaAperta;
   
   select quizAperta.punteggiomax
   into punteggMax 
   from quizAperta join rispostaAperta on new.IdQA=quizAperta.IdQA;

   select quizAperta.punteggiomin
   into punteggMin
   from quizAperta join rispostaAperta on new.IdQA=quizAperta.IdQA;
	  
	   	if (punteggAss<punteggMin) then
   		return punteggAss,'Errore: punteggio_assegnato fuori intervallo';
  		else if  (punteggMax<punteggAss)then
      	return punteggAss,'Errore: punteggio_assegnato fuori intervallo';
	  	else return NEW;
   end if;
   end if;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_controlloValutazione
before update of punteggioassegnato on rispostaAperta 
for each row
execute procedure trigger_function_controlloValutazione();

ALTER TABLE rispostaAperta
ENABLE TRIGGER trigger_modify_controlloValutazione;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*ok7	Funzione che inserisce dopo insert su testScelti mat e 		|
|		idqm/idqa e dataconsegna in rispostaAperta e chiusa.		*/
create or replace function trigger_function_insertRA()
returns trigger
language plpgsql
as 
$$
declare
quizaperta cursor for
SELECT distinct IDENTIFICATIVO, NEW.IDT, NEW.MATRICOLA, IDQA, DataTest
FROM ( TEST JOIN TESTSCELTI on TESTSCELTI.idt=new.idt) JOIN AMMETTEQUIZA ON AMMETTEQUIZA.IDT=NEW.IDT
where ammettequiza.idt=new.idt and matricola=new.matricola and test.idt=new.idt
ORDER BY NEW.MATRICOLA, new.idt
;


quizachiusa cursor for
/*select distinct idqm, new.matricola, new.idt, DataTest
from (test natural join testscelti)natural join ammettequizm*/

select datatest,idqm,test.idt
from test join ammettequizm on test.idt=ammettequizm.idt
where test.idt=new.idt;
--and matricola=new.matricola;

begin

for scorrimentoCursoreA in quizaperta
loop
insert into rispostaaperta (matricola, idqa, dataconsegna, IDENTIFICATIVO)values(
scorrimentocursorea.matricola,
scorrimentocursorea.idqa,
scorrimentocursorea.DataTest,
	scorrimentocursorea.IDENTIFICATIVO

);
end loop;

for scorrimentoCursoreC in quizachiusa
loop
insert into rispostachiusa (matricola, idqm,dataconsegna)values(
new.matricola,
scorrimentocursorec.idqm,
scorrimentocursorec.DataTest	

);
end loop;


return new;
end$$;


/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_rispostaAperta
after insert on testScelti
for each row
execute procedure trigger_function_insertRA();

ALTER TABLE testScelti
ENABLE TRIGGER trigger_modify_rispostaAperta ;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*ok8				Funzione che controlla che dataoperazione 			|
|					sia minore di datatest su AmmettequizA				*/
create or replace function trigger_function_ammA()
returns trigger
language plpgsql
as 
$$

declare
	dataIN date;
	datat timestamp;
begin
	
	select new.dataoperazione, datainizioiscr
	into dataIN, datat
	from ammettequiza natural join test
	where test.idt=ammettequiza.idt;
	
	assert dataIN<datat, 'Errore: test già completo';


return new;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_ammA
after insert or update of dataoperazione on ammettequiza
for each row
execute procedure trigger_function_ammA();

ALTER TABLE ammettequiza
ENABLE TRIGGER trigger_modify_ammA ;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------*/
/*ok9				Funzione che controlla che dataoperazione 			|
|					sia minore di datatest su AmmettequizM				*/
create or replace function trigger_function_ammM()
returns trigger
language plpgsql
as 
$$

declare
	dataIN date;
	datat timestamp;
begin
	
	select new.dataoperazione, datainizioiscr
	into dataIN, datat
	from ammettequizm natural join test
	where test.idt=ammettequizm.idt;
	
	assert dataIN<datat, 'Errore: test già completo';


return new;
end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_ammM
after insert or update of dataoperazione on ammettequizm
for each row
execute procedure trigger_function_ammM();

ALTER TABLE ammettequizm
ENABLE TRIGGER trigger_modify_ammM ;
/*----------------------------------------------------------------------*/



/*11OK			Funzione che calcola tempo su dataconsegna RA			*/
create or replace function trigger_function_CTRLDCAPERTA()
returns trigger
language plpgsql
as $$

declare
	datat timestamp;
	tempo interval;

begin
	select temposvolgimento
	into tempo
	from test
	where DataTest=old.dataconsegna;
	if new.dataconsegna>=old.dataconsegna and new.dataconsegna<=(old.dataconsegna+tempo)then
	update rispostaAperta
	set dataconsegna=new.dataconsegna
	where dataconsegna=old.dataconsegna;
	return new;

end if;
return null, 'Non puoi più consegnare, tempo scaduto';


end
$$;

/*			Trigger che gestisce la funzione e abilitazione				*/

Create trigger trigger_dataConsegnaA
after update of testorisposta on rispostaAperta
for each row
execute procedure trigger_function_CTRLDCAPERTA();

Alter table rispostaAperta
enable trigger trigger_dataConsegnaA;



/*12OK			Funzione che calcola tempo su dataconsegna RC*/

create or replace function trigger_function_CTRLDCCHIUSA()
returns trigger
language plpgsql
as $$

declare
	datat timestamp;
	tempo interval;

begin
	select temposvolgimento
	into tempo
	from test
	where DataTest=old.dataconsegna;
	if new.dataconsegna>=old.dataconsegna and new.dataconsegna<=(old.dataconsegna+tempo)then
	update rispostachiusa
	set dataconsegna=new.dataconsegna
	where dataconsegna=old.dataconsegna;
	return new;

end if;
return null, 'Non puoi più consegnare, tempo scaduto';


end
$$;

/*			Trigger che gestisce la funzione e abilitazione				*/

Create trigger trigger_dataConsegnaC
after update of testorisposta on rispostachiusa
for each row
execute procedure trigger_function_CTRLDCCHIUSA();

Alter table rispostachiusa
enable trigger trigger_dataConsegnaC;


/*15OK			Funzione che calcola che dataiscrizione sia nei limiti		*//****/
create or replace function trigger_function_CTRLDScelta()
returns trigger
language plpgsql
as $$

declare
	di date;
	df date;

begin
	select date(datainizioiscr), date(datafineiscr)
	into di,df
	from test
	where idt=new.idt;
	if new.dataiscrizione>=di and new.dataiscrizione<=df then
	return new;

end if;
return null, 'Attenzione: tempi di iscrizione scaduti.';


end
$$;

/*			Trigger che gestisce la funzione e abilitazione				*/

Create trigger trigger_dataTestScelti
before insert on testscelti
for each row
execute procedure trigger_function_CTRLDScelta();

Alter table testscelti
enable trigger trigger_dataTestScelti;



/*16OK			Funzione che calcola punteggiotot		*/
create or replace function trigger_function_setpt()
returns trigger
language plpgsql
as $$

declare
	es varchar;
	pt int;
	punt int;
	cursore cursor for
	select sum(punteggioassegnato) as c
	from rispostaaperta natural join correzione natural join test
	where date(DataTest)=date(dataconsegna) and matricola=new.matricola and identificativo=new.identificativo and idt=new.idt;
	
	cursore2 cursor for
	select distinct punteggiobonus,punteggiomalus, rispostagiusta, testorisposta, a.matricola, ba.idt, a.idqm, dataconsegna
	from  (rispostachiusa as a join correzione as t on t.matricola=a.matricola ) join 
	(quizmultipla as q join ammettequizm as ba on ba.idqm=q.idqm) on q.idqm=a.idqm 
	where a.matricola=new.matricola and date(dataconsegna)=date(dataconsegna) 
	and ba.idt=new.idt;
	
begin
select esito
into es
from testscelti natural join test
where matricola=new.matricola and idt=new.idt;


	if new.correzionecompletata='0' then
		return new;
	else if es= 'Non disponibile' then
			update testscelti
			set punteggiotot='0'
			where punteggiotot is null and matricola=new.matricola and idt=(select idt
				from test natural join testscelti
				where matricola=new.matricola and idt=new.idt);
		for scorr in cursore
		loop
			update testscelti
			set punteggiotot=punteggiotot+scorr.c
			where /*scorr.*/testscelti.matricola=new.matricola and idt=new.idt;
		end loop;
		for scorr2 in cursore2
		loop 
			if scorr2.testorisposta=scorr2.rispostagiusta then
				update testscelti
				set punteggiotot=punteggiotot+scorr2.punteggiobonus
				where /*scorr2.*/testscelti.matricola=new.matricola and testscelti.idt=new.idt;
			else
				update testscelti
				set punteggiotot=punteggiotot-scorr2.punteggiomalus
				where /*scorr2.*/testscelti.matricola=new.matricola and testscelti.idt=new.idt;
			end if;	 
		end loop;
		else
		return null, 'Correzione completata';
	end if;
end if;

return new;

end
$$;

/*			Trigger che gestisce la funzione e abilitazione				*/

Create trigger trigger_setpt
after update of CorrezioneCompletata on Correzione
for each row
execute procedure trigger_function_setpt();

Alter table Correzione
enable trigger trigger_setpt;


/*17OK	Funzione che non mi fa svolgere due test nello stesso giorno		*/
create or replace function trigger_function_CTRLDAT()
returns trigger
language plpgsql
as $$

declare
	dt timestamp;
	punt int;
	
	cursore cursor for
	select datatest,idt
	from test natural join testscelti
	where matricola=new.matricola;
	
	
		
begin
select datatest
	into dt
	from test natural join testscelti
	where idt=new.idt;
	for scorr in cursore
	loop
	
	if date(dt)=date(scorr.datatest) and new.idt<>scorr.idt then
	return null, 'Non puoi fare due test nello stesso giorno.';
	end if;
	end loop;

return new;

end$$;

/*			Trigger che gestisce la funzione e abilitazione				*/

Create trigger trigger_CTRLDAT
before insert on testscelti
for each row
execute procedure trigger_function_CTRLDAT();

Alter table testscelti
enable trigger trigger_CTRLDAT;





/*18OK	Funzione che inserisce in correzione dopo scelta in testscelti	*/

create or replace function trigger_function_insertRAc()
returns trigger
language plpgsql
as 
$$
declare
quizaperta cursor for
SELECT distinct IDENTIFICATIVO, NEW.IDT, NEW.MATRICOLA
FROM ( TEST JOIN TESTSCELTI on TESTSCELTI.idt=new.idt)
where matricola=new.matricola and test.idt=new.idt
ORDER BY NEW.MATRICOLA, new.idt
;

begin

for scorrimentoCursoreA in quizaperta
loop
insert into correzione (matricola, idt, identificativo)values(
scorrimentocursorea.matricola,
scorrimentocursorea.idt,
scorrimentocursorea.IDENTIFICATIVO

);
end loop;

return new;
end
$$;


/*			Trigger che gestisce la funzione e abilitazione				*/
create trigger trigger_modify_rispostaApertac
after insert on testScelti
for each row
execute procedure trigger_function_insertRAc();

ALTER TABLE testScelti
ENABLE TRIGGER trigger_modify_rispostaApertac ;



/*VISTE SQL*/

/*1) Vista per vedere gli studenti esaminati ai test}*/

	create or replace view studentiesaminati
	as
	select idt, nometest, matricola, esito, punteggiotot, punteggiominpos, datatest
	from testscelti natural join test
	order by matricola, idt, datatest;


/*2) Vista per vedere i quiz multipli che formano i test}*/
	
	create or replace view quizMultipliTest
	as
	select c.idt, nometest, idqm, domanda
	from test join (ammettequizm natural join quizmultipla) as c on c.idt=test.idt
	order by c.idt;
	

/*3) Vista per vedere i quiz a risposta aperta che formano i test*/
	
	create or replace view quizApertiTest
	as
	select a.idt, nometest, idqa,a.testodomanda
	from (quizaperta natural join ammettequiza) as a
		 join test on a.idt=test.idt 
	order by a.idt;