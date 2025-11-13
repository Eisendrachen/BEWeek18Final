package hospital.records.controller.model;

import hospital.records.entity.Patient;
import hospital.records.entity.PatientRecord;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordData {
	private Long recordId;
	private String diagnosis;
	private Patient patient;
	
	public RecordData(PatientRecord record) {
		this.recordId = record.getRecordId();
		this.diagnosis = record.getDiagnosis();
		this.patient = record.getPatient();
	}
	
	public PatientRecord toRecord() {
		PatientRecord record = new PatientRecord();
		
		record.setRecordId(recordId);
		record.setDiagnosis(diagnosis);
		record.setPatient(patient);
		
		return record;
	}
}
