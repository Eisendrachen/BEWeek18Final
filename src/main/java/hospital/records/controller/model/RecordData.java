package hospital.records.controller.model;

import hospital.records.entity.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordData {
	private Long recordId;
	private String diagnosis;
	private Patient patient;
	
	public RecordData(Record record) {
		this.recordId = record.getRecordId();
		this.diagnosis = record.getDiagnosis();
		this.patient = record.getPatient();
		
	}
}
