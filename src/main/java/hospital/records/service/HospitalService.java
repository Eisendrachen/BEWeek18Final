package hospital.records.service;

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

}
