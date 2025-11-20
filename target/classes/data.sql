DROP TABLE IF EXISTS doctor_patient;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS office;
DROP TABLE IF EXISTS record;

CREATE TABLE office (
	office_id int NOT NULL AUTO_INCREMENT,
	office_location varchar(128) NOT NULL,
	office_name varchar(128) NOT NULL,
	office_zip varchar(10),
	office_phone varchar(24),
	PRIMARY KEY (office_id)
);

CREATE TABLE doctor (
	doctor_id int NOT NULL AUTO_INCREMENT,
	office_id int NOT NULL,
	doctor_name varchar(128) NOT NULL,
	doctor_specialty varchar(128),
	PRIMARY KEY (doctor_id),
	FOREIGN KEY (office_id) REFERENCES office (office_id) ON DELETE CASCADE
);

CREATE TABLE record (
	record_id int NOT NULL AUTO_INCREMENT,
	diagnosis TEXT(1000),
	PRIMARY KEY (record_id)
);

CREATE TABLE patient (
	patient_id int NOT NULL AUTO_INCREMENT,
	record_id int NOT NULL,
	patient_name varchar(128) NOT NULL,
	patient_insurance varchar(128),
	patient_phone varchar(24),
	patient_address varchar(128),
	PRIMARY KEY (patient_id),
	FOREIGN KEY (record_id) REFERENCES record (record_id) ON DELETE CASCADE
);



CREATE TABLE doctor_patient (
	doctor_id int NOT NULL,
	patient_id int NOT NULL,
	FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id) ON DELETE CASCADE,
	FOREIGN KEY (patient_id) REFERENCES patient (patient_id) ON DELETE CASCADE
);

INSERT INTO office
(office_id, office_location, office_name, office_zip, office_phone)
VALUES(1, 'Test Place 1', 'Office Test 1', '11111', '222 111 3333');

INSERT INTO office
(office_id, office_location, office_name, office_zip, office_phone)
VALUES(2, 'Test Place 2', 'Office Test 2', '99932', '421 523 1453');

INSERT INTO office
(office_id, office_location, office_name, office_zip, office_phone)
VALUES(3, 'Test Place 3', 'Office Test 3', '52553', '023 395 1050');

INSERT INTO doctor
(doctor_id, office_id, doctor_name, doctor_specialty)
VALUES(1, 1, 'John Test', 'Testiology');

INSERT INTO doctor
(doctor_id, office_id, doctor_name, doctor_specialty)
VALUES(2, 1, 'Ron Rest', 'Testiology');

INSERT INTO doctor
(doctor_id, office_id, doctor_name, doctor_specialty)
VALUES(3, 2, 'Dawn Thebest', 'Testiology');

INSERT INTO doctor
(doctor_id, office_id, doctor_name, doctor_specialty)
VALUES(4, 3, 'Gave Up', 'Testiology');

INSERT INTO record
(record_id, diagnosis)
VALUES(1, 'Nothing');

INSERT INTO record
(record_id, diagnosis)
VALUES(2, 'Death');

INSERT INTO record
(record_id, diagnosis)
VALUES(3, 'Boring');

INSERT INTO record
(record_id, diagnosis)
VALUES(4, 'Hollowing');

INSERT INTO patient
(patient_id, record_id, patient_name, patient_insurance, patient_phone, patient_address)
VALUES(1, 1, 'The Tester', 'None', '101 354 1554', 'Home 1');

INSERT INTO patient
(patient_id, record_id, patient_name, patient_insurance, patient_phone, patient_address)
VALUES(2, 2, 'John Smith', 'Insured', '533 135 1335', 'Home 2');

INSERT INTO patient
(patient_id, record_id, patient_name, patient_insurance, patient_phone, patient_address)
VALUES(3, 3, 'The Tested', 'Dental', '049 104 1503', 'Home 3');

INSERT INTO patient
(patient_id, record_id, patient_name, patient_insurance, patient_phone, patient_address)
VALUES(4, 4, 'Gael Knight', 'Immortality', '425 104 1953', 'Ringed City');

INSERT INTO doctor_patient
(doctor_id, patient_id)
VALUES(1, 1);

INSERT INTO doctor_patient
(doctor_id, patient_id)
VALUES(1, 2);

INSERT INTO doctor_patient
(doctor_id, patient_id)
VALUES(2, 3);

INSERT INTO doctor_patient
(doctor_id, patient_id)
VALUES(4, 4);

