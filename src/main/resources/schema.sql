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