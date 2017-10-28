package hhs.perzeptron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatasetIris extends Dataset {

	public DatasetIris() {
		anzahlBeispiele =100;
		anzahlEigenschaften = 4;
		BufferedReader br = null;
		int beispiel =0;
		input = new double[anzahlBeispiele][anzahlEigenschaften];
		output = new int[anzahlBeispiele];

	
		try {
			br = new BufferedReader(new FileReader("iris.bin")); 
			String zeile = null;
	    
	    
	    	while ((zeile = br.readLine()) != null) { 
	    		String[] parts = zeile.split(",");
	    	
	    		for(int eigenschaft=0; eigenschaft<parts.length-1; eigenschaft++ ){
	    			input[beispiel][eigenschaft]=Double.parseDouble(parts[eigenschaft]);
	    		}
	    		if(parts[parts.length-1].equals("Iris-setosa")){
	    			output[beispiel]=0;
	    			
	    		}
	    		else if(parts[parts.length-1].equals("Iris-versicolor")){
	    			output[beispiel]=1;
	    		}
	    		beispiel++;
	    	
	    	} 
	    	br.close(); 
		} 
	
			catch (IOException e) { 
				System.out.println("Fehler beim einlesen der Datei."); 
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
		this.output[beispiel] = output;

	}

	public int getOutput(int beispiel) {

		return output[beispiel];
	}

}