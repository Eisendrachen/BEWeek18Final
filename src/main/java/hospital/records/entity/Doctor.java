package hospital.records.entity;

import java.util.HashSet;
import java.util.Set;

public class Doctor {
	private Long doctorId;
	private String doctorName;
	private String doctorSpecialty;
	
	private Set<Office> offices = new HashSet<>();
}
