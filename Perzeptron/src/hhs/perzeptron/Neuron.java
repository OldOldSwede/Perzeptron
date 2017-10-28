package hhs.perzeptron;

public class Neuron {
	
	private double[] gewichte;; // gewicht[n] = bias => n-1 Inputs für das Neuron

	private double schwellenwert = 0;
	private double lernrate = 0.01;

	// Konstruktor - setze Gewichte mit Zufallszahlen

	public Neuron(Dataset trainingsdaten) {
		gewichte = new double[trainingsdaten.getAnzahlEigenschaften() + 1];
		for (int i = 0; i < gewichte.length; i++) {
			gewichte[i] =Math.random();
		}
	}


	// Lernalgorithmus
	public double trainieren(Dataset trainingsdaten) {
		double error, globalError = 0;

		for (int beispiel = 0; beispiel < trainingsdaten.getAnzahlBeispiele(); beispiel++) {

			// Unterschied zwischen gewünschtem und angenommenen Output
			error = trainingsdaten.getOutput(beispiel) - berechneOutput(trainingsdaten, beispiel);

			// Gewichte verändern
			for (int eigenschaft = 0; eigenschaft < trainingsdaten.getAnzahlEigenschaften(); eigenschaft++) {
				gewichte[eigenschaft] += lernrate * error* trainingsdaten.getInput(beispiel, eigenschaft);
			}
			// Bias also gewicht[n] ändern
			gewichte[trainingsdaten.getAnzahlEigenschaften()] += lernrate * error;

			// Globaler Error berechnen
			globalError += error * error;

		}
		return globalError;
	}

	//Berechnung des Output eines Beispiels
	public double berechneOutput(Dataset dataset, int beispiel) {
		double summe = gewichte[dataset.getAnzahlEigenschaften()];
		for (int eigenschaft = 0; eigenschaft < dataset.getAnzahlEigenschaften(); eigenschaft++){
	
				summe += gewichte[eigenschaft]*dataset.getInput(beispiel, eigenschaft);
		}
		if (summe >= schwellenwert) {
			return 1;
		} else {
			return 0;
		}
	
	}
}
