package hhs.perzeptron;
//Vorlage Dataset

public abstract class Dataset {
	protected int anzahlBeispiele;
	protected int anzahlEigenschaften;
	
	protected double[][] input;
	protected int[] output;
	
	public abstract int getAnzahlBeispiele();

	public abstract int getAnzahlEigenschaften();

	public abstract double getInput(int beispiel, int eigenschaft);

	public abstract int getOutput(int beispiel);
	public abstract void setOutput(int beispiel, int output);

}
