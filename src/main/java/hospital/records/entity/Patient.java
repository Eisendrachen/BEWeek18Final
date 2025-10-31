package hospital.records.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	
	private String patientInsurance;
	private String patientPhone;
	private String patientAddress;
	
	@OneToOne
	private Record record;
	
	@ManyToMany(mappedBy = "patients")
	private Set<Doctor> doctors = new HashSet<>();
}
