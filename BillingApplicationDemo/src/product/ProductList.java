package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
	
	
    List<Product> pList = new ArrayList<Product>();;
	
	public List<Product> getProdList() {
		return pList;
	}
	public void setProdList(String input) throws FileNotFoundException {
		
		String path = "C:\\Users\\ashiq\\git\\repository\\BillingApplicationDemo\\src\\Resources\\";
		path += input + ".txt";
		File file  = new File(path);
		Scanner sc  = new Scanner(file);
		while(sc.hasNextLine())
		{	
			Product product = new Product(null, null, null);
			String[] temp = sc.nextLine().split(" ");
			product.setProductId(temp[0]);
			product.setName(temp[1]);
			product.setPrice(temp[2]);
			this.pList.add(product);
		}
		sc.close();
	}
	
	

}
