create table EXTJSQUESTION(QUESNO number(10) primary key, QUES varchar2(500), OPTION1 varchar2(200), OPTION2 varchar2(200), OPTION3 varchar2(200), OPTION4 varchar2(200), CORRECTOPTION varchar2(5));
insert into EXTJSQUESTION values(1, 'What is the capital of India ?', 'New Delhi', 'Mumbai', 'Chennai', 'Kolkata', 'A');
insert into EXTJSQUESTION values(2, 'What is the capital of West Bengal ?', 'New Delhi', 'Mumbai', 'Chennai', 'Kolkata', 'D');
insert into EXTJSQUESTION values(3, 'What is the capital of Maharashtra ?', 'New Delhi', 'Mumbai', 'Chennai', 'Kolkata', 'B');
insert into EXTJSQUESTION values(4, 'What is the capital of Tamil Nadu ?', 'New Delhi', 'Mumbai', 'Chennai', 'Kolkata', 'C');
commit;
