package hospital.records.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.records.controller.model.OfficeData;
import hospital.records.dao.OfficeDao;
import hospital.records.entity.Office;

@Service
public class HospitalService {

	@Autowired
	private OfficeDao officeDao;
	
	@Transactional(readOnly = false)
	public OfficeData saveOffice(OfficeData officeData) {
		Office office = officeData.toOffice();
		Office dbOffice = officeDao.save(office);
		
		return new OfficeData(dbOffice);
	}

	@Transactional(readOnly = true)
	public OfficeData retrieveOfficeWithId(Long officeId) {
		Office office = findOfficeWithId(officeId);
		return new OfficeData(office);
	}
	
	//Finds the office with the ID given or throws an exception due to the fact findById returns an optional
	private Office findOfficeWithId(Long officeId) {
		return officeDao.findById(officeId).orElseThrow(() -> new NoSuchElementException("Office with ID: " + officeId + " does not exist."));
	}
	
}
