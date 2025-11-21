package hospital.records.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.records.entity.Patient;
import hospital.records.entity.PatientRecord;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientData {
	private Long patientId;
	private String patientName;
	private String patientInsurance;
	private String patientPhone;
	private String patientAddress;
	private Set<DoctorData> doctors = new HashSet<>();
	private PatientRecord record;
	
	public PatientData(Patient patient) {
		this.patientId = patient.getPatientId();
		this.patientName = patient.getPatientName();
		this.patientInsurance = patient.getPatientInsurance();
		this.patientPhone = patient.getPatientPhone();
		this.patientAddress = patient.getPatientAddress();
		
		this.record = patient.getRecord();
	}
	
	public Patient toPatient() {
		Patient patient = new Patient();
		
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);
		patient.setPatientInsurance(patientInsurance);
		patient.setPatientPhone(patientPhone);
		patient.setPatientPhone(patientPhone);
		
		patient.setRecord(record);
		
		return patient;
	}
}
