package project.group.cs157a;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class FrequencyCalculator implements Callable<HashMap<String, Double>>{
	
	private HashMap<String, Double> tokenFreqs = null;
	private HashMap<String, Integer> docFreqs = null;
	
	FrequencyCalculator(HashMap<String,Double> tokenFreqs, HashMap<String, Integer> docFreqs) {
		this.tokenFreqs = tokenFreqs;
		this.docFreqs = docFreqs;
	}

	@Override
	public HashMap<String, Double> call() throws Exception {
		for (Map.Entry<String, Double> entry: tokenFreqs.entrySet()) {
			System.out.println("Starting Value is " + entry.getValue());
			System.out.println("Doc value is " + docFreqs.get(entry.getKey()));
			entry.setValue(entry.getValue() * (ProjectMain.NUMBER_OF_FILES / (double) docFreqs.get(entry.getKey())));
			System.out.println("Ending Value is " + entry.getValue());
		}
		
		return tokenFreqs;
	}

}