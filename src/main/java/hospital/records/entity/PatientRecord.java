package hospital.records.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "record")
public class PatientRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recordId;
	
	@Column(length = 1000)
	private String diagnosis;
	
}

//It was renamed from Record to PatientRecord because just Record is already an owned name by something in Java