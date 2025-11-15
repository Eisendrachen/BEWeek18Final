package hospital.records.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.records.controller.model.DoctorData;
import hospital.records.controller.model.OfficeData;
import hospital.records.controller.model.PatientData;
import hospital.records.controller.model.RecordData;
import hospital.records.dao.DoctorDao;
import hospital.records.dao.OfficeDao;
import hospital.records.dao.PatientDao;
import hospital.records.dao.RecordDao;
import hospital.records.entity.Doctor;
import hospital.records.entity.Office;
import hospital.records.entity.Patient;
import hospital.records.entity.PatientRecord;

@Service
public class HospitalService {

	//Dao references
	@Autowired
	private OfficeDao officeDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private RecordDao recordDao;
	
	//Post service methods
	
	@Transactional(readOnly = false)
	public OfficeData saveOffice(OfficeData officeData) {
		Office office = officeData.toOffice();
		Office dbOffice = officeDao.save(office);
		
		return new OfficeData(dbOffice);
	}
	
	@Transactional(readOnly = false)
	public DoctorData saveDoctor(DoctorData doctorData) {
		Doctor doctor = doctorData.toDoctor();
		Doctor dbDoctor = doctorDao.save(doctor);
		
		return new DoctorData(dbDoctor);
	}
	
	@Transactional(readOnly = false)
	public PatientData savePatient(PatientData patientData) {
		Patient patient = patientData.toPatient();
		Patient dbPatient = patientDao.save(patient);
		
		return new PatientData(dbPatient);
	}
	
	@Transactional(readOnly = false)
	public RecordData saveRecord(RecordData recordData) {
		PatientRecord record = recordData.toRecord();
		PatientRecord dbRecord = recordDao.save(record);
		
		return new RecordData(dbRecord);
	}
	
	//Get service methods

	@Transactional(readOnly = true)
	public OfficeData retrieveOfficeWithId(Long officeId) {
		Office office = findOfficeWithId(officeId);
		return new OfficeData(office);
	}
	
	//Finds the office with the ID given or throws an exception due to the fact findById returns an optional
	private Office findOfficeWithId(Long officeId) {
		return officeDao.findById(officeId).orElseThrow(() -> new NoSuchElementException("Office with ID: " + officeId + " does not exist."));
	}

	@Transactional(readOnly = true)
	public List<OfficeData> retrieveAllOffices() {
		List<Office> officeEntities = officeDao.findAll();
		List<OfficeData> officeDtos = new LinkedList<>();
		
		for(Office office : officeEntities) {
			OfficeData officeData = new OfficeData(office);
			officeDtos.add(officeData);
		}
		
		return officeDtos;
	}
	@Transactional(readOnly = true)
	public DoctorData retrieveDoctorWithId(Long doctorId) {
		Doctor doctor = findDoctorWithId(doctorId);
		return new DoctorData(doctor);
	}
	
	private Doctor findDoctorWithId(Long doctorId) {
		return doctorDao.findById(doctorId).orElseThrow(() -> new NoSuchElementException("Doctor with ID: " + doctorId + " does not exist."));
	}

	@Transactional(readOnly = true)
	public List<DoctorData> retrieveAllDoctors() {
		List<Doctor> doctorEntities = doctorDao.findAll();
		List<DoctorData> doctorDtos = new LinkedList<>();
		
		for(Doctor doctor : doctorEntities) {
			DoctorData doctorData = new DoctorData(doctor);
			doctorDtos.add(doctorData);
		}
		
		return doctorDtos;
	}

	@Transactional(readOnly = true)
	public PatientData retrievePatientWithId(Long patientId) {
		Patient patient = findPatientWithId(patientId);
		return new PatientData(patient);
	}
	
	private Patient findPatientWithId(Long patientId) {
		return patientDao.findById(patientId).orElseThrow(() -> new NoSuchElementException("Patient with ID: " + patientId + " does not exist."));
	}

	@Transactional(readOnly = true)
	public List<PatientData> retrieveAllPatients() {
		List<Patient> patientEntities = patientDao.findAll();
		List<PatientData> patientDtos = new LinkedList<>();
		
		for(Patient patient : patientEntities) {
			PatientData patientData = new PatientData(patient);
			patientDtos.add(patientData);
		}
		
		return patientDtos;
	}

	@Transactional(readOnly = true)
	public RecordData retrieveRecordWithId(Long recordId) {
		PatientRecord record = findRecordWithId(recordId);
		return new RecordData(record);
	}
	
	private PatientRecord findRecordWithId(Long recordId) {
		return recordDao.findById(recordId).orElseThrow(() -> new NoSuchElementException("Record with ID: " + recordId + " does not exist."));
	}
	
	//Delete service methods
	@Transactional(readOnly = false)
	public void deleteOffice(Long officeId) {
		Office office = findOfficeWithId(officeId);
		officeDao.delete(office);
	}

	public void deleteDoctor(Long doctorId) {
		Doctor doctor = findDoctorWithId(doctorId);
		doctorDao.delete(doctor);
	}

	public void deletePatient(Long patientId) {
		Patient patient = findPatientWithId(patientId);
		patientDao.delete(patient);
	}

	public void deleteRecord(Long recordId) {
		PatientRecord record = findRecordWithId(recordId);
		recordDao.delete(record);
	}

	



	
	
}
