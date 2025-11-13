package hospital.records.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class PatientRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recordId;
	
	@Column(length = 1000)
	private String diagnosis;
	
	//One to one relationship with patient
	@EqualsAndHashCode.Exclude
	@OneToOne
	private Patient patient;
}
