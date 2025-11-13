package hospital.records.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	@EqualsAndHashCode.Exclude
	private String patientInsurance;
	@EqualsAndHashCode.Exclude
	private String patientPhone;
	@EqualsAndHashCode.Exclude
	private String patientAddress;
	
	//Other side of the many to many relationship that uses the doctor_patient join table
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "patients")
	private Set<Doctor> doctors = new HashSet<>();
}
