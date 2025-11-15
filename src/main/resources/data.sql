INSERT INTO doctor
(doctor_id, office_id, doctor_name, doctor_specialty)
VALUES(0, 0, '', '');

INSERT INTO doctor_patient
(doctor_id, patient_id)
VALUES(0, 0);

INSERT INTO office
(office_id, office_location, office_name, office_zip, office_phone)
VALUES(0, '', '', '', '');

INSERT INTO patient
(patient_id, patient_name, patient_insurance, patient_phone, patient_address)
VALUES(0, '', '', '', '');

INSERT INTO record
(record_id, patient_id, diagnosis)
VALUES(0, 0, '');