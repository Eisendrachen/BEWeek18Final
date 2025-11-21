package hospital.records.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.records.entity.Doctor;
import hospital.records.entity.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorData {
	private Long doctorId;
	private String doctorName;
	private String doctorSpecialty;
	private Set<PatientData> patients = new HashSet<>();
	
	public DoctorData(Doctor doctor) {
		this.doctorId = doctor.getDoctorId();
		this.doctorName = doctor.getDoctorName();
		this.doctorSpecialty = doctor.getDoctorSpecialty();
		for(Patient patient : doctor.getPatients()) {
			this.patients.add(new PatientData(patient));
		}
	}
	
	
	public Doctor toDoctor() {
		Doctor doctor = new Doctor();
		
		doctor.setDoctorId(doctorId);
		doctor.setDoctorName(doctorName);
		doctor.setDoctorSpecialty(doctorSpecialty);
		for(PatientData patientData : patients) {
			doctor.getPatients().add(patientData.toPatient());
		}
		
		
		return doctor;
	}
}
