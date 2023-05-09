package measurements;

import lombok.Getter;
import lombok.Setter;

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
