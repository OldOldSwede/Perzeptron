package hhs.perzeptron;

public class Perzeptron {

	public static void main(String[] args) {
		Dataset trainingsdaten = new DatasetIris();		
		Dataset testdaten = new DatasetIris();
		
		
		Neuron superNeuron = new Neuron(trainingsdaten);
		
			
		//Trainiere Neuron mit Trainingsdaten
		int anzahlEpochen = 0;
		double globalError;
		
		do{
			anzahlEpochen++;
			
			globalError = superNeuron.trainieren(trainingsdaten);
			
			System.out.println("Epoche "+anzahlEpochen+" : Fehler = "+Math.sqrt(globalError/100));
			
		}while(globalError !=0 && anzahlEpochen < 400);
		
		
		//Überprüfe Neuron mit den Testdaten
		int treffer = 0;
		for(int beispiel =0; beispiel< testdaten.getAnzahlBeispiele();beispiel++){
			if(superNeuron.berechneOutput(testdaten, beispiel) == testdaten.getOutput(beispiel)){
				treffer++;
			}
		}
		//Anzahl von Treffern
		System.out.println("\nTreffer bei "+testdaten.getAnzahlBeispiele()+" Beispielen: "+ treffer);

	}

}
