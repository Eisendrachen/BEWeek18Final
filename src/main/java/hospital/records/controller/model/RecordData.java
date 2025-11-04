package hospital.records.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordData {
	private Long recordId;
	private String diagnosis;
	
	public RecordData(Record record) {
		this.recordId
	}
}
