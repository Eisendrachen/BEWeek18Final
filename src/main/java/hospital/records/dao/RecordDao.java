package hospital.records.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.records.entity.PatientRecord;

public interface RecordDao extends JpaRepository<PatientRecord, Long> {

}
