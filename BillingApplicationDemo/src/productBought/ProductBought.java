package productBought;

import product.Product;

public class ProductBought {
	
	String s_No, quantity, netPrice;
	Product pr;
	
	
	public Product getPr() {
		return pr;
	}
	public void setPr(Product pr) {
		this.pr = pr;
	}
	
	public String getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getS_No() {
		return s_No;
	}
	public void setS_No(String s_No) {
		this.s_No = s_No;
	}
	
	
	public ProductBought(String s_No, Product pr, String quantity, String netPrice)
	{
		this.s_No = s_No;
		this.pr = pr;
		this.quantity = quantity;
		this.netPrice = netPrice;
	}



}
