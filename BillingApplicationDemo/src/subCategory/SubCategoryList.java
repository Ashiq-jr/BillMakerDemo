package subCategory;
import java.io.*;
import java.util.*;


public class SubCategoryList {
	
	List<SubCategory> subList = new ArrayList<SubCategory>();
	
	public List<SubCategory> getSubList() {
		return subList;
	}

	public void setSubList(String input) throws FileNotFoundException {
		String path = "C:\\Users\\ashiq\\eclipse-workspace\\BillingApplicationDemo\\src\\Resources\\";
		path += input +".txt";
		File file = new File(path);
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine())
		{
			SubCategory subCat = new SubCategory(null, null);
			String[] temp = sc.nextLine().split(" ");
			subCat.setId(temp[0]);
			subCat.setName(temp[1]);
			subList.add(subCat);
		}
		sc.close();
	}

	
	
	
	
	

}
