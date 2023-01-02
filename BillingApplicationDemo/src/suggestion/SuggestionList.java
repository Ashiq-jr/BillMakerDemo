package suggestion;

import java.io.*;
import java.util.*;


public class SuggestionList {
	
	List<Suggestion> sugList = new ArrayList <Suggestion>();
	
	public List<Suggestion> getSuggestionList() {
		return sugList;
	}

	public void setSuggestionList() throws FileNotFoundException {
		
		String path = "C:\\Users\\ashiq\\git\\repository\\BillingApplicationDemo\\src\\Resources\\Suggestions.txt";
		File file = new File(path);
		
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine())
		{
			Suggestion sugg = new Suggestion();
			sugg.setId(sc.nextLine());
			sugList.add(sugg);
		}
		sc.close();
	}

	
	

}
