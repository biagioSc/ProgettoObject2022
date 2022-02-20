

/*----------------------------------------------------------------------|
|																		|
|		Implementazione domini utili al dominio del problema			|
|																		|
|----------------------------------------------------------------------*/

CREATE DOMAIN dominio_operazione AS varchar check 
(value ='Inserimento' or value= 'Modifica' or value= 'Eliminazione');

CREATE DOMAIN dominio_esito AS varchar check 
(value ='Promosso' or value= 'Bocciato' or value = 'Non disponibile');


/*----------------------------------------------------------------------|
|.......................................................................|
|............Implementazione classi del dominio del problema............|
|.......................................................................|
|----------------------------------------------------------------------*/

/*----------------------------------------------------------------------|
|.......................................................................|
|......................CREAZIONE TABELLA INSEGNANTE.....................|		
|.......................................................................|
|....Creazione tabella Insegnante e implementazione vincoli di base.....*/

CREATE TABLE INSEGNANTE (
	Nome varchar(50) not null,
	Cognome varchar(70) not null,
	Identificativo serial not null,
	Username varchar(50) not null,
	Password varchar(50) not null
);

/*						Vincolo di chiave primaria						*/
ALTER TABLE INSEGNANTE
ADD CONSTRAINT Insegnante_PK PRIMARY KEY (Identificativo);

ALTER TABLE INSEGNANTE
ADD CONSTRAINT Insegnante_U Unique (Username);

/*						Implementazione altri vincoli 					|
|			Vincolo sulla lunghezza minima di username e password		*/
ALTER TABLE INSEGNANTE
ADD CONSTRAINT Username_Controllo check ( length(username)>7 );
ALTER TABLE INSEGNANTE
ADD CONSTRAINT Password_Controllo check ( length(password)>7 );
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA STUDENTE						|		
|																		|
|		Creazione tabella Studente e implementazione vincoli di base	*/

CREATE TABLE STUDENTE (
	Nome varchar(50) not null,
	Cognome varchar(70) not null,
	Matricola serial not null,
	Username varchar(50) not null,
	Password varchar(50) not null
);

/*						Vincolo di chiave primaria						*/
ALTER TABLE STUDENTE
ADD CONSTRAINT Studente_PK PRIMARY KEY (Matricola);

ALTER TABLE STUDENTE
ADD CONSTRAINT Studente_U UNIQUE (Username);

/*						Implementazione altri vincoli 					|
|			Vincolo sulla lunghezza minima di username e password		*/
ALTER TABLE STUDENTE
ADD CONSTRAINT Username_Controllo check ( length(username)>7 );
ALTER TABLE STUDENTE
ADD CONSTRAINT Password_Controllo check ( length(password)>7 );
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA TEST							|		
|																		|
|		Creazione tabella Test e implementazione vincoli di base		*/

CREATE TABLE TEST (
	IDT serial not null,
	Nometest varchar(50) not null default 'Nome test non inserito',
	DataTest timestamp not null default '2022-01-01',
	DataInizioIscr timestamp not null default '2021-12-12',
	DataFineIscr timestamp default null,
	TempoSvolgimento interval default '60',
	PunteggioMinPos int default 0,
	DataOperazione date not null,
	Identificativo serial not null
);

/*						Vincolo di chiave primaria						*/
ALTER TABLE TEST
ADD CONSTRAINT Test_PK PRIMARY KEY (IDT);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE TEST
ADD CONSTRAINT TEST_FK1 FOREIGN KEY (Identificativo) 
REFERENCES INSEGNANTE (Identificativo)
ON DELETE SET NULL ON UPDATE CASCADE;

/*						Implementazione altri vincoli 					|
| 			Check sulla datafineiscr che deve essere successiva a 		|
|				datainizioiscr e precedente a DataTest					*/
Alter table TEST
Add constraint controllo_data check
( datafineiscr between datainizioiscr and DataTest);
/*----------------------------------------------------------------------*/

/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA quizMultipla					|		
|																		|
|	Creazione tabella quizMultipla e implementazione vincoli di base	*/

CREATE TABLE quizMultipla (
	IdQM serial not null,
	Domanda varchar(500) not null,
	PunteggioBonus int not null,
	PunteggioMalus int default 0,
	Materia varchar (50) default 'Generale',
	RispostaGiusta varchar(500) not null,
	RispostaSbagliata1 varchar(500) not null,
	RispostaSbagliata2 varchar(500) not null,
	RispostaSbagliata3 varchar(500) not null

);

/*						Vincolo di chiave primaria						*/
ALTER TABLE quizMultipla
ADD CONSTRAINT quizMultipla_PK PRIMARY KEY (IdQM);

/*						 Vincolo di unicita								*/
ALTER TABLE quizMultipla
ADD CONSTRAINT quizMultipla_unic UNIQUE 
(IDQM, RispostaGiusta, RispostaSbagliata1,RispostaSbagliata2,RispostaSbagliata3);
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA quizAperta					|		
|																		|
|	Creazione tabella quizAperta e implementazione vincoli di base		*/

CREATE TABLE quizAperta (
	IdQA serial not null,
	TestoDomanda varchar(500) not null,
	PunteggioMax int not null,
	PunteggioMin int not null,
	MaxCaratteri int default 5000,
	Materia varchar (50) default 'Generale'
);

/*						Vincolo di chiave primaria						*/
ALTER TABLE quizAperta
ADD CONSTRAINT quizAperta_PK PRIMARY KEY (IdQA);

/*						Implementazione altri vincoli 					|
|			Check sul MaxCaratteri che deve essre tra 1 e 5000			*/
ALTER TABLE quizAperta
ADD CONSTRAINT quizAperta_Char Check 
(MaxCaratteri>=1 and MaxCaratteri<=5000);

/*	Check sul PunteggioMin che deve essre piu piccolo di PunteggioMax	*/
ALTER TABLE quizAperta
ADD CONSTRAINT quizAperta_Values Check (PunteggioMin<PunteggioMax);
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|				Implementazione classi di associazione					|
|																		|
|----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA TEST SCELTI					|		
|																		|
|	Creazione tabella TEST SCELTI e implementazione vincoli di base		*/

CREATE TABLE testScelti (
	PunteggioTot int default 0,
	Esito dominio_esito default 'Non disponibile',
	Matricola serial not null,
	dataiscrizione date,
	IDT serial not null
);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE testScelti
ADD CONSTRAINT testScelti_FK1 FOREIGN KEY (Matricola)
REFERENCES STUDENTE (Matricola)
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE testScelti
ADD CONSTRAINT testScelti_FK2 FOREIGN KEY (IDT) REFERENCES TEST (IDT)
ON DELETE SET NULL ON UPDATE CASCADE;

/*					Definizione dei vincoli di unicita		 			*/
ALTER TABLE testScelti
ADD CONSTRAINT unique_testScelti unique(matricola,idt);
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA rispostaChiusa				|		
|																		|
|	Creazione tabella rispostaChiusa e implementazione vincoli di base	*/

CREATE TABLE rispostaChiusa (
	TestoRisposta varchar(5000),
	Matricola serial not null,
	IdQM serial not null,
	Dataconsegna timestamp 

);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE rispostaChiusa
ADD CONSTRAINT rispostaChiusa_FK1 FOREIGN KEY (Matricola)
REFERENCES STUDENTE (Matricola)
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE rispostaChiusa	 
ADD CONSTRAINT rispostaChiusa_FK2 FOREIGN KEY (IdQM) 
REFERENCES quizMultipla(IdQM)
ON DELETE SET NULL ON UPDATE CASCADE;

/*						Definizione vincolo di unicita					*/
ALTER TABLE rispostaChiusa
ADD CONSTRAINT rispostaChiusa_Unicita 
unique(IdQM, Matricola,Dataconsegna);
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA rispostaAperta				|		
|																		|
|	Creazione tabella rispostaAperta e implementazione vincoli di base	*/

CREATE TABLE rispostaAperta (
	TestoRisposta varchar(5000),
	Matricola serial not null,
	IdQA serial not null,
	Dataconsegna timestamp,
	PunteggioAssegnato int default Null,
	Correzioni varchar(1000) default 'Non ci sono correzioni',
	Identificativo serial not null
);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE rispostaAperta
ADD CONSTRAINT rispostaAperta_FK3 FOREIGN KEY (Identificativo) 
REFERENCES INSEGNANTE (Identificativo)
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE rispostaAperta
ADD CONSTRAINT rispostaAperta_FK1 FOREIGN KEY (Matricola) 
REFERENCES STUDENTE (Matricola)
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE rispostaAperta 
ADD CONSTRAINT rispostaAperta_FK2 FOREIGN KEY (IdQA) 
REFERENCES  quizAperta (IdQA)
ON DELETE SET NULL ON UPDATE CASCADE;

/*							Vincolo di unicita							*/
ALTER TABLE rispostaAperta 
ADD CONSTRAINT rispostaAperta_Unique 
unique(Matricola, IdQA,Dataconsegna,IDENTIFICATIVO);
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA AmmetteQuizA					|		
|																		|
|	Creazione tabella AmmetteQuizA e implementazione vincoli di base	*/

CREATE TABLE AmmetteQuizA (
dataoperazione date not null,
IdQA serial not null,
IDT serial not null

);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE AmmetteQuizA
ADD CONSTRAINT AmmetteQuizA_FK1 FOREIGN KEY (IDT) REFERENCES TEST (IDT)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE AmmetteQuizA
ADD CONSTRAINT AmmetteQuizA_FK2 FOREIGN KEY(IdQA) 
REFERENCES quizAperta (IdQA)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE AmmetteQuizA
ADD CONSTRAINT AmmetteQuizA_U UNIQUE(IdQA,IDT) ;
/*----------------------------------------------------------------------*/


/*----------------------------------------------------------------------|
|																		|
|						CREAZIONE TABELLA AmmetteQuizM					|		
|																		|
|	Creazione tabella AmmetteQuizM e implementazione vincoli di base	*/

CREATE TABLE AmmetteQuizM (
dataoperazione date not null,
IdQM serial not null,
IDT serial not null

);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE AmmetteQuizM
ADD CONSTRAINT AmmetteQuizM_FK1 FOREIGN KEY (IDT) REFERENCES TEST (IDT)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE AmmetteQuizM
ADD CONSTRAINT AmmetteQuizM_FK2 FOREIGN KEY (IdQM)
REFERENCES quizMultipla (IdQM)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE AmmetteQuizM
ADD CONSTRAINT AmmetteQuizM_U UNIQUE(IdQM,IDT) ;
/*----------------------------------------------------------------------*/
CREATE TABLE Correzione (
CorrezioneCompletata int default 0,
Identificativo serial not null,
IDT serial not null,
Matricola serial not null

);

/*					Definizione dei vincoli di chiave esterna 			*/
ALTER TABLE Correzione
ADD CONSTRAINT Correzione_FK1 FOREIGN KEY (IDT) REFERENCES TEST (IDT)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Correzione
ADD CONSTRAINT Correzione_FK2 FOREIGN KEY (Identificativo)
REFERENCES insegnante (Identificativo)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Correzione
ADD CONSTRAINT Correzione_FK3 FOREIGN KEY (Matricola)
REFERENCES studente (Matricola)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Correzione
ADD CONSTRAINT Correzione_C1
CHECK (CorrezioneCompletata=1 or CorrezioneCompletata=0);

ALTER TABLE Correzione
ADD CONSTRAINT Correzione_U UNIQUE(Identificativo,Matricola,IDT) ;