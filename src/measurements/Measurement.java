package measurements;


public class Measurement {
	private double value;
	private double weight;
	private String name;
	
	public Measurement(String name, double value, double weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public double getValue() {
		return value;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
