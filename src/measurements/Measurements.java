package measurements;
import java.util.ArrayList;
import java.util.HashMap;

public class Measurements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Measurement> measurements = new ArrayList<Measurement>();

		measurements.add(new Measurement("speed", 1, 2));
		measurements.add(new Measurement("speed", 3, 4));
		measurements.add(new Measurement("fuel", 5, 6));
		measurements.add(new Measurement("fuel", 7, 8));
		System.out.println(calculateGroupWeightedAverage(measurements).toString());

	}
	
	public static double calculateWeightedAverage(ArrayList<Measurement> measurements) {
		double sumValue = 0.0;
		double sumWeight = 0.0;
		
		for (int i = 0; i < measurements.size(); i++) {
			Measurement current = measurements.get(i);
			if (current.getWeight() > 0) {
				sumValue += current.getValue() * current.getWeight();
				sumWeight += current.getWeight();
			}
		}
		
		if (sumWeight > 0) {
			return (sumValue / sumWeight);
		} else {
			return 0;
		}
	}
	
	public static HashMap<String, Double> calculateGroupWeightedAverage(ArrayList<Measurement> measurements) {
		HashMap<String, Double> sumValues = new HashMap<String, Double>();
		HashMap<String, Double> sumWeights = new HashMap<String, Double>();
		HashMap<String, Double> results = new HashMap<String, Double>();
		
		for (int i = 0; i < measurements.size(); i++) {
			Measurement current = measurements.get(i);
			if (current.getWeight() > 0) {
				if (!sumValues.containsKey(current.getName())) {
					sumValues.put(current.getName(), new Double(0));
				}
				if (!sumWeights.containsKey(current.getName())) {
					sumWeights.put(current.getName(), new Double(0));
				}
				
				sumValues.put(current.getName(), sumValues.get(current.getName()) + current.getValue() * current.getWeight());
				
				sumWeights.put(current.getName(), sumWeights.get(current.getName()) + current.getWeight());
			}
		}
		

		
		for (String key : sumValues.keySet()) {
			results.put(key, sumValues.get(key) / sumWeights.get(key));
		}
		
		return results;
	}

}
