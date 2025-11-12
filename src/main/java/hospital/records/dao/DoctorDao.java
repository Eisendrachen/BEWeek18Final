package hospital.records.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.records.entity.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long> {

}
