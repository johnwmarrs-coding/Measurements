package measurements;

import lombok.Getter;
import lombok.Setter;

/*
	Improvement Ideas:
	1) Validate values in setters
	2) Remove name from this class, and just use hash oriented structures to organize the measurements by name
	3) Create methods for returning the calculated value * weight for the formula. Perhaps that would
	be another useful metric.
	4) This could also be used as a model for a DB. In which case you'd want to specify the data appropriately
	and define fields for how it might relate to other data.
	5) Use some sort of auto documenation generation system. Some are based on annotations, others on comments.
*/
public class Measurement {
	@Getter
	@Setter
	private double value;

	@Getter
	@Setter
	private double weight;

	@Getter
	@Setter
	private String name = "None";

	public Measurement() {
	}

	public Measurement(double value, double weight) {
		this.value = value;
		this.weight = weight;
	}

	public Measurement(String name, double value, double weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
}
