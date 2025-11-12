package hospital.records.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import hospital.records.controller.model.OfficeData;
import hospital.records.service.HospitalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hospital_records")
@Slf4j
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping("/office")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OfficeData createOffice(@RequestBody OfficeData officeData) {
		log.info("Creating office {}", officeData);
		return hospitalService.saveOffice(officeData);
	}
	
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
	
	@DeleteMapping("/office/{officeId}")
	public Map<String, String> deleteOffice(@PathVariable Long officeId){
		log.info("Deleting office ID:{}", officeId);
		hospitalService.deleteOffice(officeId);
		
		return Map.of("message", "Office ID=" + officeId + " was deleted.");
	}
}
