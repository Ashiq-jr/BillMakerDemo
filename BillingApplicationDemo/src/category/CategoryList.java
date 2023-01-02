package category;

import java.util.*;
import java.io.*;

public class CategoryList {
	
	List<Category> cList = new ArrayList<Category>();

	public List<Category> getcList() {
		return cList;
	}

	public void setcList() throws FileNotFoundException {
		String path = "C:\\Users\\ashiq\\eclipse-workspace\\BillingApplicationDemo\\src\\Resources\\Category.txt";
		File file = new File(path);
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine())
		{
			Category c = new Category(null, null);
			String[] temp = sc.nextLine().split(" ");
			c.setId(temp[0]);
			c.setName(temp[1]);
			this.cList.add(c);
		}
		sc.close();
	}
	
	

}
