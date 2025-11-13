package hospital.records.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.records.entity.Doctor;
import hospital.records.entity.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientData {
	private Long patientId;
	private String patientInsurance;
	private String patientPhone;
	private String patientAddress;
	private Set<DoctorData> doctors = new HashSet<>();
	
	public PatientData(Patient patient) {
		this.patientId = patient.getPatientId();
		this.patientInsurance = patient.getPatientInsurance();
		this.patientPhone = patient.getPatientPhone();
		this.patientAddress = patient.getPatientAddress();
		for(Doctor doctor : patient.getDoctors()) {
			this.doctors.add(new DoctorData(doctor));
		}
	}
	
	public Patient toPatient() {
		Patient patient = new Patient();
		
		patient.setPatientId(patientId);
		patient.setPatientInsurance(patientInsurance);
		patient.setPatientPhone(patientPhone);
		patient.setPatientPhone(patientPhone);
		for(DoctorData doctorData : doctors) {
			patient.getDoctors().add(doctorData.toDoctor());
		}
		
		return patient;
	}
}
