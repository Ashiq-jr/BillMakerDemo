package product;

public class Product {
	

	String id;
	
	public String getProductId() {
		return id;
	}
	public void setProductId(String productId) {
		this.id = productId;
	}

	
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	String price;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

	
	public Product(String productId, String name, String price)
	{
		this.id = productId;
		this.name = name;
		this.price = price;
	}

}
