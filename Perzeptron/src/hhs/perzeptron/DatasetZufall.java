package hhs.perzeptron;

public class DatasetZufall extends Dataset {

	public DatasetZufall(int anzahlBeispiele ,int anzahlEigenschaften) {
		
		this.anzahlEigenschaften = anzahlEigenschaften;
		this.anzahlBeispiele = anzahlBeispiele;
		
		

		// Arraylänge angeben
		this.input = new double[anzahlBeispiele][anzahlEigenschaften];

		this.output = new int[anzahlBeispiele];

		//Zufallszahlen generieren - Output muss linear separierbar sein
		for (int  e = 0; e < anzahlEigenschaften; e++) {

			for (int i = 0; i < anzahlBeispiele; i +=2) {
				input[i][e] = zufallsZahl(0,(e+0.999999) );
				output[i] = 0;

			}		
			for (int i = 1; i < anzahlBeispiele; i +=2) {
				input[i][e] = zufallsZahl((e+1),(e+2) );
				output[i] = 1;

			}

		}


	}



	public int getAnzahlBeispiele() {

		return this.anzahlBeispiele;
	}

	public int getAnzahlEigenschaften() {

		return this.anzahlEigenschaften;
	}

	public double getInput(int beispiel, int eigenschaft) {

		return input[beispiel][eigenschaft];
	}
	
	public void setOutput(int beispiel, int output) {
		this.output[beispiel]=output;
		
	}	

	public int getOutput(int beispiel) {

		return output[beispiel];
	}	
	
	
	private static double zufallsZahl(double min, double max) {
		return min + Math.random() * (max - min);
	}

}
