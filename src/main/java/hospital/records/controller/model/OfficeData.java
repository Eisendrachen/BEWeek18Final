package hospital.records.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.records.entity.Doctor;
import hospital.records.entity.Office;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OfficeData {
	private Long officeId;
	private String officeLocation;
	private String officeName;
	private String officeZip;
	private String officePhone;
	private Set<DoctorData> doctors = new HashSet<>();
	
	public OfficeData(Office office) {
		this.officeId = office.getOfficeId();
		this.officeLocation = office.getOfficeLocation();
		this.officeName = office.getOfficeName();
		this.officeZip = office.getOfficeZip();
		this.officePhone = office.getOfficePhone();
		
		for(Doctor doctor : office.getDoctors()) {
			this.doctors.add(new DoctorData(doctor));
		}
	}
	
	//For test if I decide to do that
	public OfficeData(Long officeId, String officeLocation, String officeName, String officeZip, String officePhone) {
		this.officeId = officeId;
		this.officeLocation = officeLocation;
		this.officeName = officeName;
		this.officeZip = officeZip;
		this.officePhone = officePhone;
	}
	
	public Office toOffice() {
		Office office = new Office();
		
		office.setOfficeId(officeId);
		office.setOfficeLocation(officeLocation);
		office.setOfficeName(officeName);
		office.setOfficeZip(officeZip);
		office.setOfficePhone(officePhone);
		
		for(DoctorData doctorData : doctors) {
			office.getDoctors().add(doctorData.toDoctor());
		}
		
		return office;
	}
}

