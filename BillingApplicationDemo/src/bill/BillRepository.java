package bill;

import java.io.*;
import java.util.*;

import product.Product;
import productBought.ProductBought;

import java.time.LocalDate;

public class BillRepository extends Bill{
	
	
	public BillRepository(String billNo, String date, List<ProductBought> cart, String total, String cust_Name,
			String ph_No) {
		super(billNo, date, cart, total, cust_Name, ph_No);
	}

	public void generateBill() throws IOException
	{

        //Create A Directory Using Today's Date 
        
        String directoryPath = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\";
        LocalDate date = LocalDate.now();
        directoryPath += date.toString();
        File f = new File(directoryPath);
        if(!f.exists())
        {
            f.mkdir();
        }

        //Creating Bill Number File

        String enumerateBillFile_Path = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\"+date.toString()+"\\enumerateBill.txt";
        File enumBill_File = new File(enumerateBillFile_Path);
        if(!enumBill_File.exists())
        {
            String billNo = "0";
            FileWriter writer1 = new FileWriter(enumerateBillFile_Path);
            enumBill_File.createNewFile();
            writer1.write(billNo); 
            writer1.close();           
        }
        
       //Creating New Files Using Enum File

        File file = new File(enumerateBillFile_Path); 
        Scanner sc = new Scanner(file);
        String temp = sc.next();
        sc.close();
        this.billNo = Integer.toString(Integer.parseInt(temp) + 1);
        String billfilePath = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\"+ date +"\\" + this.billNo + ".txt";
        File bill = new File(billfilePath);
        bill.createNewFile();

        //Changing enum Value in Enum File

        FileWriter writer2 = new FileWriter(enumerateBillFile_Path);       
        writer2.write(this.billNo);
        writer2.close();

        //Writing on New Bill File

        FileWriter billWriter = new FileWriter(billfilePath);
        this.date = date.toString();
        billWriter.write("Bill Number : " + this.billNo+"\n");
        billWriter.write("Date : " + this.date+"\n");
        billWriter.write("Customer Name : " + this.cust_Name+"\n");
        billWriter.write("Phone Number : " + this.ph_No+"\n");
        billWriter.write("\nItems Bought  " + "\n");
        for(ProductBought x : this.cart)
        {
        	Product pr = new Product(null, null, null);
        	pr = x.getPr();
            billWriter.write("S.no : " + x.getS_No() + "\t");
            billWriter.write("Product Name : " + pr.getName() + "\t");
            billWriter.write("\tprice : " + pr.getPrice() + "\t");
            billWriter.write("Quantity : " + x.getQuantity()  + "\t");
            billWriter.write("Net Price : " + x.getNetPrice() + "\n");
            
        }
        billWriter.write("\nTotal : " + this.total);
        billWriter.close();


    }
	

}
