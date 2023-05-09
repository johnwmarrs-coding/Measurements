/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package measurements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		// Scanner to read measurements from stdin
		Scanner scanner = new Scanner(System.in);
		System.out.println("Will this data contain names? 0 = no, else = yes:");
		boolean containsNames = scanner.nextInt() == 0;
		System.out.println("Enter the number of measurements to input");
		int numMeasurements = scanner.nextInt();

		ArrayList<Measurement> measurements = new ArrayList<Measurement>();

		for (int i = 0; i < numMeasurements; i++) {
			String name = null;
			if (containsNames)
				name = scanner.next();

			double value = scanner.nextDouble();
			double weight = scanner.nextDouble();

			if (containsNames) {
				measurements.add(new Measurement(name, value, weight));
			} else {
				measurements.add(new Measurement(value, weight));
			}
		}

		/*
		 * Pretend input will be in the following form
		 * 0 <- Flag indicating whether data is named
		 * N <- Number of measurements to read from
		 * "Name1" {value1} {weight1}
		 * "Name2" {value2} {weight2}
		 * etc...
		 */

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

		for (Measurement current : measurements) {
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

		for (Measurement current : measurements) {
			if (current.getWeight() > 0) {
				if (!sumValues.containsKey(current.getName())) {
					sumValues.put(current.getName(), 0.0);
				}
				if (!sumWeights.containsKey(current.getName())) {
					sumWeights.put(current.getName(), 0.0);
				}

				sumValues.put(current.getName(),
						sumValues.get(current.getName()) + current.getValue() * current.getWeight());

				sumWeights.put(current.getName(), sumWeights.get(current.getName()) + current.getWeight());
			}
		}

		for (String key : sumValues.keySet()) {
			if (sumWeights.get(key) > 0) {
				results.put(key, sumValues.get(key) / sumWeights.get(key));
			} else {
				results.put(key, 0.0);
			}
		}

		return results;
	}
}
