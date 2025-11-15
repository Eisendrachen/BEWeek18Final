package hospital.records.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hospital.records.controller.model.DoctorData;
import hospital.records.controller.model.OfficeData;
import hospital.records.controller.model.PatientData;
import hospital.records.controller.model.RecordData;
import hospital.records.service.HospitalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hospital_records")
@Slf4j
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	//Post methods
	
	@PostMapping("/office")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OfficeData createOffice(@RequestBody OfficeData officeData) {
		log.info("Creating office {}", officeData);
		return hospitalService.saveOffice(officeData);
	}
	
	@PostMapping("/doctor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DoctorData createDoctor(@RequestBody DoctorData doctorData) {
		log.info("Creating doctor {}", doctorData);
		return hospitalService.saveDoctor(doctorData);
	}
	
	@PostMapping("/patient")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PatientData createPatient(@RequestBody PatientData patientData) {
		log.info("Creating patient {}", patientData);
		return hospitalService.savePatient(patientData);
	}
	
	@PostMapping("/record")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RecordData createRecord(@RequestBody RecordData recordData) {
		log.info("Creating record {}", recordData);
		return hospitalService.saveRecord(recordData);
	}
	
	//Put Methods
	@PutMapping("/office/{officeId}")
	public OfficeData updateOffice(@PathVariable Long officeId, @RequestBody OfficeData officeData) {
		officeData.setOfficeId(officeId);
		log.info("Updating office {}", officeData);
		return hospitalService.saveOffice(officeData);
	}
	
	@PutMapping("/doctor/{doctorId}")
	public DoctorData updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorData doctorData) {
		doctorData.setDoctorId(doctorId);
		log.info("Updating doctor {}", doctorData);
		return hospitalService.saveDoctor(doctorData);
	}
	@PutMapping("/patient/{patientId}")
	public PatientData updatePatient(@PathVariable Long patientId, @RequestBody PatientData patientData) {
		patientData.setPatientId(patientId);
		log.info("Updating patient {}", patientData);
		return hospitalService.savePatient(patientData);
	}
	@PutMapping("/record/{recordId}")
	public RecordData updateRecord(@PathVariable Long recordId, @RequestBody RecordData recordData) {
		recordData.setRecordId(recordId);
		log.info("Updating record {}", recordData);
		return hospitalService.saveRecord(recordData);
	}
	
	//Get Methods
	
	@GetMapping("/office/{officeId}")
	public OfficeData retrieveOffice(@PathVariable Long officeId) {
		log.info("Getting office ID:{}", officeId);
		return hospitalService.retrieveOfficeWithId(officeId);
	}
	
	@GetMapping("/office")
	public List<OfficeData> retrieveAllOffices() {
		log.info("Getting all offices in database");
		return hospitalService.retrieveAllOffices();
	}
	
	@GetMapping("/doctor/{doctorId}")
	public DoctorData retrieveDoctor(@PathVariable Long doctorId) {
		log.info("Getting doctor ID:{}", doctorId);
		return hospitalService.retrieveDoctorWithId(doctorId);
	}
	
	@GetMapping("/doctor")
	public List<DoctorData> retrieveAllDoctors() {
		log.info("Getting all doctors in database");
		return hospitalService.retrieveAllDoctors();
	}
	
	@GetMapping("/patient/{patientId}")
	public PatientData retrievePatient(@PathVariable Long patientId) {
		log.info("Getting patient ID:{}", patientId);
		return hospitalService.retrievePatientWithId(patientId);
	}
	
	@GetMapping("/patient")
	public List<PatientData> retrieveAllPatients() {
		log.info("Getting all patients in database");
		return hospitalService.retrieveAllPatients();
	}
	
	
	@GetMapping("/record/{recordId}")
	public RecordData retrieveRecord(@PathVariable Long recordId) {
		log.info("Getting record ID:{}", recordId);
		return hospitalService.retrieveRecordWithId(recordId);
	}
	
	//No need for a retrieveAllRecords
	
	
	//Delete Methods
	
	@DeleteMapping("/office/{officeId}")
	public Map<String, String> deleteOffice(@PathVariable Long officeId){
		log.info("Deleting office ID:{}", officeId);
		hospitalService.deleteOffice(officeId);
		
		return Map.of("message", "Office ID=" + officeId + " was deleted.");
	}
	
	@DeleteMapping("/doctor/{doctorId}")
	public Map<String, String> deleteDoctor(@PathVariable Long doctorId){
		log.info("Deleting doctor ID:{}", doctorId);
		hospitalService.deleteDoctor(doctorId);
		
		return Map.of("message", "Doctor ID=" + doctorId + " was deleted.");
	}
	
	@DeleteMapping("/patient/{patientId}")
	public Map<String, String> deletePatient(@PathVariable Long patientId){
		log.info("Deleting patient ID:{}", patientId);
		hospitalService.deletePatient(patientId);
		
		return Map.of("message", "Patient ID=" + patientId + " was deleted.");
	}
	
	@DeleteMapping("/record/{officeId}")
	public Map<String, String> deleteRecord(@PathVariable Long recordId){
		log.info("Deleting record ID:{}", recordId);
		hospitalService.deleteRecord(recordId);
		
		return Map.of("message", "Record ID=" + recordId + " was deleted.");
	}
}
