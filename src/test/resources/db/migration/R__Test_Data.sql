CREATE TABLE THE.FOREST_CLIENT (
	CLIENT_NUMBER VARCHAR2(8) NOT NULL,
	CLIENT_NAME VARCHAR2(60) NOT NULL,
	LEGAL_FIRST_NAME VARCHAR2(30) NULL,
	LEGAL_MIDDLE_NAME VARCHAR2(30) NULL,
	CLIENT_STATUS_CODE VARCHAR2(3) NOT NULL,
	CLIENT_TYPE_CODE VARCHAR2(1) NOT NULL,
	CONSTRAINT FOREST_CLIENT_PK PRIMARY KEY (CLIENT_NUMBER));

INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00000007','bond','james','bond','ACT','I');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00000010','bbondd','jjamess','bbondd','ACT','A');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00000008','hunt','james','hunt','ACT','I');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00000009','james',NULL,'hunt','ACT','I');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00001347','KRAKOWSKY','ERNA',NULL,'ACT','I');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00001351','CORP. OF THE CITY OF VICTORIA',NULL,NULL,'ACT','G');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00001356','BALFOUR FOREST PRODUCTS INC.',NULL,NULL,'ACT','U');
INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE) VALUES
	 ('00001357','SLOCAN FOREST PRODUCTS LTD.',NULL,NULL,'ACT','C');

CREATE VIEW THE.V_CLIENT_PUBLIC
(CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE)
AS
SELECT client_number
       , client_name
       , legal_first_name
       , legal_middle_name
       , client_status_code
       , client_type_code
    FROM forest_client;