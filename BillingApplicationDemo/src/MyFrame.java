import product.Product;
import product.ProductList;
import productBought.ProductBought;
import subCategory.*;
import suggestion.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bill.BillRepository;
import category.*;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;


public class MyFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_ProductId;
	List<Category> cList;
	CategoryList cat;
	List<SubCategory> sList;
	SubCategoryList subCat;
	ProductList prod;
	List<Product> pList;
	private JTable table;
	private JLabel lblShowPrice;
	private JComboBox<String> comboBox_Category;
	private JComboBox<String> comboBox_SubCategory;
	private JComboBox<String> comboBox_Product;
	private JComboBox<Integer> comboBox_Qnty;
	SuggestionList suggL;
	List<Suggestion> suggList;
	DefaultTableModel model;
	private JTextField textFieldC_PhNo;
	private JTextField textFieldCName;
	String tempPrice = "";
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyFrame frame = new MyFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public MyFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 718);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_AddItem = new JPanel();
		panel_AddItem.setBounds(11, 68, 621, 350);
		panel_AddItem.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_AddItem);
		panel_AddItem.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(324, 42, 287, 173);
		panel_AddItem.add(panel);
		panel.setLayout(null);
		
		
		comboBox_SubCategory = new JComboBox<String>();
		comboBox_SubCategory.setBounds(117, 68, 153, 28);
		panel.add(comboBox_SubCategory);
		
		
		comboBox_Category = new JComboBox<String>();
		comboBox_Category.setBounds(117, 10, 153, 28);
		panel.add(comboBox_Category);
		
		comboBox_Product = new JComboBox<String>();
		comboBox_Product.setBounds(117, 131, 153, 28);
		panel.add(comboBox_Product);
		
		comboBox_Qnty = new JComboBox<Integer>();
		comboBox_Qnty.setBounds(302, 264, 77, 28);
		panel_AddItem.add(comboBox_Qnty);
		
		JLabel lblSubCategory = new JLabel("Sub Category :");
		lblSubCategory.setBounds(10, 70, 117, 23);
		panel.add(lblSubCategory);
		lblSubCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(10, 5, 90, 36);
		panel.add(lblCategory);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblProduct = new JLabel("Product :");
		lblProduct.setBounds(9, 133, 117, 23);
		panel.add(lblProduct);
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
				
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 42, 287, 173);
		panel_AddItem.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProductId = new JLabel("Product Id :");
		lblProductId.setBounds(11, 15, 90, 23);
		panel_1.add(lblProductId);
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(98, 42, 171, 129);
		panel_1.add(scrollPane_1);
		scrollPane_1.setVisible(false);
		
		JList<String> listSuggestions = new JList<String>();
		listSuggestions.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				textField_ProductId.setText(listSuggestions.getSelectedValue());
				listSuggestions.setVisible(false);
				scrollPane_1.setVisible(false);
			}
		});
		scrollPane_1.setViewportView(listSuggestions);
		listSuggestions.setVisible(false);
		
		textField_ProductId = new JTextField();
		textField_ProductId.setBounds(98, 14, 171, 28);
		panel_1.add(textField_ProductId);
		textField_ProductId.setColumns(10);
		
		JPanel panel_ShowTotal = new JPanel();
		panel_ShowTotal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_ShowTotal.setBounds(858, 552, 271, 45);
		contentPane.add(panel_ShowTotal);
		panel_ShowTotal.setLayout(null);
		
		JButton btnBill = new JButton("BILL");
		btnBill.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBill.setBounds(878, 626, 95, 30);
		contentPane.add(btnBill);
		
		JButton btnRemove = new JButton("REMOVE");		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemove.setBounds(722, 627, 95, 30);
		contentPane.add(btnRemove);
		
		JLabel lblShowTotal = new JLabel("");
		lblShowTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblShowTotal.setVisible(false);
		lblShowTotal.setBounds(110, 10, 146, 23);
		panel_ShowTotal.add(lblShowTotal);
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(1029, 626, 95, 30);
		contentPane.add(btnClear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(12, 439, 621, 158);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 26, 113, 33);
		panel_2.add(lblNewLabel);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNumber.setBounds(10, 69, 113, 33);
		panel_2.add(lblPhoneNumber);
		
		JButton btnClearCustDetails = new JButton("CLEAR");
		btnClearCustDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClearCustDetails.setBounds(346, 115, 108, 33);
		panel_2.add(btnClearCustDetails);
		
		textFieldC_PhNo = new JTextField();
		textFieldC_PhNo.setColumns(10);
		textFieldC_PhNo.setBounds(133, 73, 171, 28);
		panel_2.add(textFieldC_PhNo);
		
		textFieldCName = new JTextField();
		textFieldCName.setColumns(10);
		textFieldCName.setBounds(133, 26, 171, 28);
		panel_2.add(textFieldCName);
		
		JButton btnSubmit_CDetails = new JButton("SUBMIT");
		btnSubmit_CDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit_CDetails.setBounds(185, 115, 108, 33);
		panel_2.add(btnSubmit_CDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(678, 66, 452, 484);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setBackground(SystemColor.menu);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		Object[] column = {"S.No", "PRODUCT", "PRICE", "QUANTITY", "NETPRICE"};
		final Object[] row = new Object[5];
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(120);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(10, 10, 90, 23);
		panel_ShowTotal.add(lblTotal);
		
		
		JButton btnAddProduct = new JButton("ADD");
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddProduct.setBounds(190, 304, 85, 30);
		panel_AddItem.add(btnAddProduct);
		
		JButton btnResetSelection = new JButton("RESET");
		btnResetSelection.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnResetSelection.setBounds(317, 304, 85, 30);
		panel_AddItem.add(btnResetSelection);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(218, 230, 90, 23);
		panel_AddItem.add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblShowPrice = new JLabel("price");
		lblShowPrice.setBounds(305, 237, 45, 13);
		lblShowPrice.setVisible(false);
		panel_AddItem.add(lblShowPrice);
		
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(215, 266, 90, 23);
		panel_AddItem.add(lblQuantity);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("BILL MAKER DEMO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(2, 7, 1141, 41);
		contentPane.add(lblNewLabel_1);
		
		//Filling Quantity ComboBox
		
		comboBox_Qnty.addItem(1);
		comboBox_Qnty.addItem(2);
		comboBox_Qnty.addItem(3);
		comboBox_Qnty.addItem(4);
		comboBox_Qnty.addItem(5);
		comboBox_Qnty.addItem(6);
		comboBox_Qnty.addItem(7);
		comboBox_Qnty.addItem(8);
		comboBox_Qnty.addItem(9);
		comboBox_Qnty.addItem(10);
		comboBox_Qnty.setSelectedItem(null);
		
		//Filling Category ComboBox

		cList = getCategoryList();
		comboBox_SubCategory.removeAllItems();
		for(Category x : cList)
		{
			comboBox_Category.addItem(x.getName());
		}
		comboBox_Category.setSelectedItem(null);
		
		
		
		//Filling SubCategory ComboBox According to Category Selection
		
		comboBox_Category.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if(comboBox_Category.getSelectedIndex() != -1)
			{
				textField_ProductId.enable(false);
				String input = comboBox_Category.getSelectedItem().toString();				
				sList = getSubCategoryList(input);		
				comboBox_SubCategory.removeAllItems();
				for(SubCategory x : sList)
				{
					comboBox_SubCategory.addItem(x.getName());					
				}
				comboBox_SubCategory.setSelectedItem(null);
			}
			else
			{
				textField_ProductId.enable(true);
			}
						
		}
		});	
		
		//Filling Product ComboBox According to SubCategory Selection
		
		comboBox_SubCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(comboBox_SubCategory.getSelectedIndex() != -1)
				{
					String input = comboBox_SubCategory.getSelectedItem().toString();
					List<Product> pList = getProductList(input);
					comboBox_Product.removeAllItems();
					for(Product x : pList)
					{
						comboBox_Product.addItem(x.getName());
					}
					comboBox_Product.setSelectedItem(null);
				}
			}
		});
		
		
		//Showing the Price of the Product According to Product Selection
		
		comboBox_Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_SubCategory.getSelectedIndex() != -1)
				{
					String input = comboBox_SubCategory.getSelectedItem().toString();
					List<Product> pList = getProductList(input);
					String pr = "";
					if(comboBox_Product.getSelectedIndex() != -1)
					{
						pr = comboBox_Product.getSelectedItem().toString();
					}
					else if(comboBox_Product.getSelectedIndex() == -1)
					{
						lblShowPrice.setVisible(false);
					}
					for(Product x : pList)
					{
						if(pr.equals(x.getName()))
						{
							lblShowPrice.setVisible(true);
							lblShowPrice.setText(x.getPrice());
						}
					}
					
				}
			}
		});
		
		// Working With Product ID
		
		textField_ProductId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField_ProductId.getText().equals("") || textField_ProductId.getText().length() != 8)
				{
					comboBox_Product.setSelectedIndex(-1);
					comboBox_Category.setSelectedIndex(-1);
					comboBox_SubCategory.setSelectedIndex(-1);
					lblShowPrice.setVisible(false);
					lblShowPrice.setText("");
				}
				
				if(!textField_ProductId.getText().equals("")) 
				{
					comboBox_Product.enable(false);
					comboBox_Category.enable(false);
					comboBox_SubCategory.enable(false);
					DefaultListModel<String> dlm = new DefaultListModel<String>();
					String enteredText = textField_ProductId.getText();
					suggL = new SuggestionList();
					suggList = new ArrayList<Suggestion>();
					
					try {
						suggL.setSuggestionList();
					} catch (FileNotFoundException e2) {

						e2.printStackTrace();
					}
					suggList = suggL.getSuggestionList();
					for(Suggestion x : suggList)
					{
						if(x.getId().substring(0, enteredText.length()).equals(enteredText))
						{
							listSuggestions.setVisible(true);
							scrollPane_1.setVisible(true);
							dlm.addElement(x.getId());
							
						}
					}
					
					listSuggestions.setModel(dlm);
				}
				else
				{
					comboBox_Product.enable(true);
					comboBox_Category.enable(true);
					comboBox_SubCategory.enable(true);
					listSuggestions.setVisible(false);
					scrollPane_1.setVisible(false);
				}
			}
		});
		textField_ProductId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				suggList = getSuggestionList();

				String temp = textField_ProductId.getText().toString();
				boolean containsProdId = false;
				for(Suggestion x : suggList)
				{
					if(x.getId().equals(temp)) containsProdId = true;
				}
				if(textField_ProductId.getText().length() == 8 && containsProdId)
				{
					String category = "";
					String subCategory = "";
					String product = "";
					String price = "";
					

					String input1 = textField_ProductId.getText().substring(0, 2);
					String input2 = textField_ProductId.getText().substring(2, 4);
					String input3 = textField_ProductId.getText();
					
					cList = getCategoryList();
					comboBox_Category.removeAllItems();
					for(Category x : cList)
					{
						comboBox_Category.addItem(x.getName());
						String id = x.getId();
						if(id.equals(input1))
						{
							category = x.getName();
						}
					}
					comboBox_Category.setSelectedItem(category);
					

					sList = getSubCategoryList(category);
					for(SubCategory x : sList)
					{
						comboBox_SubCategory.addItem(x.getName());
						String id = x.getId();
						if(id.equals(input2))
						{
							subCategory = x.getName();
						}
					}
					comboBox_SubCategory.setSelectedItem(subCategory);
					
					
					pList = getProductList(subCategory);
					for(Product x : pList)
					{
						comboBox_Product.addItem(x.getName());
						String id = x.getProductId();
						if(id.equals(input3))
						{
							product = x.getName();
							price = x.getPrice();
						}
						
					}
					comboBox_Product.setSelectedItem(product);
					lblShowPrice.setVisible(true);
					lblShowPrice.setText(price);
					
				}
				
				else
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,
						    "Invalid Product ID.");
				}
			}
		});	
		

		//Button to Add Product to Cart
		
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_Category.getSelectedItem() == null || comboBox_SubCategory.getSelectedItem() == null || comboBox_Product.getSelectedItem() == null || comboBox_Qnty.getSelectedIndex() == -1 )
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Some of the Fields Are Empty.");
				}
				else
				{
					int i = table.getRowCount();
					int quantity = Integer.parseInt(comboBox_Qnty.getSelectedItem().toString());
					double price = Double.parseDouble(lblShowPrice.getText());
					double amount = quantity * price;
					
					row[0] = i+1;
					row[1] = comboBox_Product.getSelectedItem().toString();
					row[2] = lblShowPrice.getText().toString();
					row[3] = comboBox_Qnty.getSelectedItem().toString();
					row[4] = amount;
					model.addRow(row);
					
					comboBox_Category.setSelectedIndex(-1);
//					comboBox_Category.removeAllItems();
					comboBox_SubCategory.setSelectedIndex(-1);
					comboBox_SubCategory.removeAllItems();
					comboBox_Product.setSelectedIndex(-1);
					comboBox_Product.removeAllItems();
					comboBox_Qnty.setSelectedIndex(-1); 
					lblShowPrice.setVisible(false);
					textField_ProductId.setText("");
					comboBox_Category.enable(true);
					comboBox_SubCategory.enable(true);
					comboBox_Product.enable(true);

					getTotal(table,lblShowTotal );
				}
					
			}
		});
		
		//Button To Reset Selected Product
		
		btnResetSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_Category.setSelectedIndex(-1);
				comboBox_SubCategory.setSelectedIndex(-1);
				comboBox_SubCategory.removeAllItems();
				comboBox_Product.setSelectedIndex(-1);
				comboBox_Product.removeAllItems();
				comboBox_Qnty.setSelectedIndex(-1);
				lblShowPrice.setVisible(false);
				textField_ProductId.setText("");
				comboBox_Category.enable(true);
				comboBox_SubCategory.enable(true);
				comboBox_Product.enable(true);
				textField_ProductId.enable(true);
			}
		});

		
		//Working on Customer Name TextField
		
		textFieldCName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char[] cName = textFieldCName.getText().toCharArray();
				for(Character x : cName)
				{
					if( ( (int) x >= 65 && (int) x <= 90 ) || ( (int) x >= 97  && (int) x <= 122 ) )
					{ 
			
					}
					else
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"Name Should be in Alphabets Only.");
					}
				}
			}
		});
		
		//Working on Customer Phone Number TextField
		
		textFieldC_PhNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char[] c_PhNo = textFieldC_PhNo.getText().toCharArray();
				for(Character x : c_PhNo)
				{
					if( (int) x >= 48 && (int) x <= 57 )
					{ 
			
					}
					else
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"Phone Number Should be in Numerics Only.");
					}
				}
			}
		});
		
		//Button To Hold Customer Details
		
		btnSubmit_CDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( (textFieldCName.getText().length() >= 3 && textFieldCName.getText().length() <= 15) && (textFieldC_PhNo.getText().length() == 10) )
				{
					textFieldCName.enable(false);
					textFieldC_PhNo.enable(false);
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Cutomer Details Submitted. ");
				}
				else
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Enter Valid Name/Phone Number. ");
				}
			}
		});
		
		//Button To Clear Customer Details
		
		btnClearCustDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldCName.setText(null);
				textFieldC_PhNo.setText(null);
				textFieldCName.enable(true);
				textFieldC_PhNo.enable(true);
			}
		});
		
	
		//Button To Clear the Table as A Whole
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				lblShowTotal.setText("");
			}
		});
		
		
		// Button to Remove a Particular Product From List
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1)
				{
					int temp = table.getSelectedRow();
					model.removeRow(temp);
					getTotal(table,lblShowTotal );
					updateSerialNum(table);
				}
				
				else
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Please Select A Row To Remove.");
				}
				
			}
		});
		
		//Button to Store the Bill Details
		
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (table.getRowCount() != 0 && textFieldCName.getText().length() >=1 && textFieldC_PhNo.getText().length() >= 1)
				{
					BillRepository bp = new BillRepository(null, null, null, null, null, null);
					
					List<ProductBought> lpb = new ArrayList <ProductBought>();
					
					for(int i = 0; i < table.getRowCount(); i++)
					{
						ProductBought pb = new ProductBought(null, null, null, null);
						Product pr = new Product(null, null, null);

						pr.setName(table.getModel().getValueAt(i, 1).toString());
						pr.setPrice(table.getModel().getValueAt(i, 2).toString());						
				        pb.setS_No(table.getModel().getValueAt(i, 0).toString());
				        pb.setPr(pr);
				        pb.setQuantity(table.getModel().getValueAt(i, 3).toString());
				        pb.setNetPrice(table.getModel().getValueAt(i, 4).toString());
				        lpb.add(pb);
					}
					
					bp.setCust_Name(textFieldCName.getText());
					bp.setPh_No(textFieldC_PhNo.getText());
					bp.setCart(lpb);
					bp.setTotal(lblShowTotal.getText());
					try {
						bp.generateBill();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
					
					textFieldCName.setText("");
					textFieldCName.enable(true);
					textFieldC_PhNo.setText("");
					textFieldC_PhNo.enable(true);
					lblShowTotal.setText("");
					model.setRowCount(0);
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Bill Submitted Successfully. ");
				}
				else
				{					
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"Enter Customer Details / Cart Is Empty. ");
				}
				
				
			}
		});
	
		
		
		
		
	}
	
	//Functions
	
	public static void getTotal(JTable table, JLabel lblShowTotal)
	{
		double total = 0;
		for(int j= 0; j <table.getRowCount(); j++ )
		{
			double temp =  (double) table.getModel().getValueAt(j, 4);
			total += temp;
		}
		lblShowTotal.setVisible(true);
		lblShowTotal.setText(Double.toString(total));
	}
	
	public static void updateSerialNum(JTable table)
	{
		for(int j= 0; j <table.getRowCount(); j++ )
		{
			int temp =  (int) table.getModel().getValueAt(j, 0);
			temp = j+1;
			table.getModel().setValueAt(temp, j, 0);
		}

	}
	
	public static ArrayList<Category> getCategoryList()
	{
		CategoryList cat = new CategoryList();
		List<Category>cList = new ArrayList<Category>();
		try {
			cat.setcList();
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		}
		cList = cat.getcList();
		return (ArrayList<Category>) cList;
		
	}
	
	public static ArrayList<SubCategory> getSubCategoryList(String input)
	{
		SubCategoryList subCat = new SubCategoryList();
		List<SubCategory> sList = new ArrayList<SubCategory>();					
		try {
			subCat.setSubList(input);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		sList = subCat.getSubList();
		return (ArrayList<SubCategory>) sList;
	}
	
	public static ArrayList<Product> getProductList(String input)
	{
		ProductList prod = new ProductList();
		List<Product> pList = new ArrayList<Product>();
		try {
			prod.setProdList(input);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		pList = prod.getProdList();
		return (ArrayList<Product>) pList;
	}
	
	public static ArrayList<Suggestion> getSuggestionList()
	{
		SuggestionList suggL = new SuggestionList();
		List<Suggestion> suggList = new ArrayList<Suggestion>();
		
		try {
			suggL.setSuggestionList();
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		}
		suggList = suggL.getSuggestionList();
		return (ArrayList<Suggestion>) suggList;
	}
	
}
	
