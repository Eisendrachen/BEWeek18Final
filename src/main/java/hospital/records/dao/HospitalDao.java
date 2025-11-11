package hospital.records.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.records.entity.Office;

public interface HospitalDao extends JpaRepository<Office, Long> {

}
