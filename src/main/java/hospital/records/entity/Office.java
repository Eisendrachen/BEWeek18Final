package hospital.records.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Office {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long officeId;
	
	private String officeName;
	private String officeZip;
	private String officePhone;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Doctor> doctors = new HashSet<>();
}
