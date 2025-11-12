package hospital.records.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.records.entity.Patient;

public interface PatientDao extends JpaRepository<Patient, Long> {

}
