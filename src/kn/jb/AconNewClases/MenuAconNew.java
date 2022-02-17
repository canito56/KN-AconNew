package kn.jb.AconNewClases;

import java.awt.*;
import javax.swing.*;
import kn.jb.ConexionesAs400.*;

public class MenuAconNew extends JFrame {
	
	private static final long serialVersionUID = 7526472295622776147L;
	MenuBar barra = new MenuBar();

   	Menu opt1 = new Menu("Control File Maintenance");
	Menu opt2 = new Menu("Accounts Receivable");
	Menu opt3 = new Menu("Accounts Payable");
	Menu opt4 = new Menu("Receipt Printing");
	Menu opt5 = new Menu("Bank Reconciliation & Banking Process");
	Menu opt6 = new Menu("Forwarding Sub-Ledger");
	Menu opt7 = new Menu("Customer Profitability");
	Menu opt8 = new Menu("General Ledger");
	Menu opt5_81 = new Menu("Bank Local Menu");
	
	MenuItem opt11 = new MenuItem("Company Master");
	MenuItem opt12 = new MenuItem("Organization Master");
	MenuItem opt13 = new MenuItem("Organization Code (Consolidation)");
	MenuItem opt14 = new MenuItem("SGI Code Maintenance");
	MenuItem opt15 = new MenuItem("Currency Code");
	MenuItem opt16 = new MenuItem("Exchange Rate");
	MenuItem opt17 = new MenuItem("Debtor/Creditor Class");
	MenuItem opt18 = new MenuItem("Traffic Code");
	MenuItem opt19 = new MenuItem("Charge Code");
	MenuItem opt110 = new MenuItem("Bank Master");
	
	MenuItem opt21 = new MenuItem("Debtor Account Maintenance");
	MenuItem opt22 = new MenuItem("Debtor´s Bank Account Maintenance");
	MenuItem opt23 = new MenuItem("Master Amendment Log Enquiry");
	MenuItem opt24 = new MenuItem("Outgoing Invoice Input");
	MenuItem opt25 = new MenuItem("Outgoing Credit Note Input");
	MenuItem opt26 = new MenuItem("Cash Allocation");
	MenuItem opt27 = new MenuItem("Refund to Customer");
	
	MenuItem opt51 = new MenuItem("Bank Statement Entry");
	MenuItem opt52 = new MenuItem("Bank Reconciliation Process");
	MenuItem opt53 = new MenuItem("Bank Statement Interface");
	MenuItem opt5_81_1 = new MenuItem("Bank Statement Interface");
	MenuItem opt5_81_2 = new MenuItem("Bank Interface Automatic Change Table Update");
	MenuItem opt5_81_3 = new MenuItem("Work with Spool File");

	public MenuAconNew() {
		
		super("ACON NEW");
		setSize(1200, 600); 
		setLocation(200, 100);
		setMenuBar(barra);

		barra.add(opt1);
		barra.add(opt2);
		barra.add(opt3);
		barra.add(opt4);
		barra.add(opt5);
		barra.add(opt6);
		barra.add(opt7);
		barra.add(opt8);		
  
		opt1.add(opt11);
		opt1.add(opt12);
		opt1.add(opt13);
		opt1.add(opt14);
		opt1.addSeparator();
		opt1.add(opt15);
		opt1.add(opt16);
		opt1.add(opt17);
		opt1.add(opt18);
		opt1.add(opt19);
		opt1.add(opt110); 
 
		opt2.add(opt21);
		opt2.add(opt22);
		opt2.add(opt23);
		opt2.addSeparator(); 
		opt2.add(opt24);
		opt2.add(opt25);
		opt2.add(opt26);
		opt2.add(opt27);
		
		opt5.add(opt51);
		opt5.add(opt52);
		opt5.add(opt53);
		opt5.addSeparator();
		opt5.add(opt5_81);
		opt5_81.add(opt5_81_1);
		opt5_81.add(opt5_81_2);
		opt5_81.add(opt5_81_3);
		
		setupSucesos();
		setVisible(true);
		
}

	public static void main(String g[]){
		ConexionAsknudev.getInstance();
		MenuAconNew prog = new MenuAconNew();
		prog.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setupSucesos() {
		opt11.addActionListener(new EscuchaMenu());
		opt15.addActionListener(new EscuchaMenu());
		opt110.addActionListener(new EscuchaMenu());
	}
	
}
