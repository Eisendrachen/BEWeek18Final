package hospital.records.entity;

import java.util.HashSet;
import java.util.Set;

public class Office {
	private Long officeId;
	private String officeName;
	private String officeZip;
	private String officePhone;
	
	private Set<Doctor> doctors = new HashSet<>();
}
