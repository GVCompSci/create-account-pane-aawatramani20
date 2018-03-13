import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AccountFrame extends JPanel 
{
	final double OVER_DRAFT_FEE = 15;
	final double rate = 0.0025;
	final double TRANSACTION_FEE = 1.5;
	final double MIN_BAL = 300;
	final double MIN_BAL_FEE = 10;
	final int FREE_TRANSACTIONS = 10;
	
	
	
	
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public AccountFrame()
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		setSize(400,400);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName,gbc);
		gbc.gridx++;
		JTextField lblTextName = new JTextField();
		lblTextName.setPreferredSize(new Dimension(85,35));
		add(lblTextName, gbc);	
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblDeposit = new JLabel("Initial Deposit: ");
		add(lblDeposit, gbc);
		gbc.gridx++;
		JTextField lblTextDeposit = new JTextField();
		lblTextDeposit.setPreferredSize(new Dimension(85,35));
		add(lblTextDeposit, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblAccType = new JLabel("Account Type: ");
		add(lblAccType, gbc);
		gbc.gridx++;
		String[] accts = {"Checking", "Savings"};
		JList<String> acctList = new JList<String>(accts);		
		JScrollPane scrolling = new JScrollPane(acctList);
		scrolling.setPreferredSize(new Dimension(85,35));
		add(scrolling, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		JButton submit = new JButton("Submit");
		add(submit, gbc);
		submit.setPreferredSize(new Dimension(85,35));
		
		
		
		submit.addActionListener(new ActionListener()
		{
            
            
            
            public void actionPerformed(ActionEvent e) {
                
            	 if (acctList.getSelectedValue().equals("Checking"))
            	 {
                     accounts.add(new CheckingAccount(lblTextName.getText(),Double.parseDouble(lblTextDeposit.getText()), OVER_DRAFT_FEE,TRANSACTION_FEE, FREE_TRANSACTIONS));
                 }
                 else if (acctList.getSelectedValue().equals("Savings")) 
                 {
                     accounts.add(new SavingsAccount(lblTextName.getText(),Double.parseDouble(lblTextDeposit.getText()),rate , MIN_BAL, MIN_BAL_FEE));
                 
                     
                }
            }
        });
		
		
		
	}

	
}
