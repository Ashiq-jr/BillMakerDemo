package bill;
import java.util.*;
import productBought.*;

public class Bill {

	
	String billNo, date, total;
	List<ProductBought> cart;
    
	public List<ProductBought> getCart() {
        return cart;
    }


    public void setCart(List<ProductBought> cart) {
        this.cart = cart;
    }


     ;
	public String getTotal() {
        return total;
    }


    public void setTotal(String total) {
        this.total = total;
    }


    String cust_Name, ph_No;
	

	public String getCust_Name() {
        return cust_Name;
    }


    public void setCust_Name(String cust_Name) {
        this.cust_Name = cust_Name;
    }


    public String getPh_No() {
        return ph_No;
    }


    public void setPh_No(String ph_No) {
        this.ph_No = ph_No;
    }


    public Bill(String billNo, String date, List<ProductBought> cart, String total, String cust_Name, String ph_No) {
		super();
		this.billNo = billNo;
		this.date = date;
		this.cart = cart;
		this.total = total;
		this.cust_Name = cust_Name;
		this.ph_No = ph_No;
	}
	
	
	

}

