package com.smart421.VendingMachine.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.smart421.VendingMachine.change.Change;
import com.smart421.VendingMachine.change.ChangeImpl;
import com.smart421.VendingMachine.change.Coin;
import com.smart421.VendingMachine.exceptions.InsufficentChangeException;
import com.smart421.VendingMachine.exceptions.NegativeEntryException;

public class VendingMachineChange extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Change change=new ChangeImpl();
	
	JTextField poundResult;
	JTextField fiftyResult;
	JTextField twentyResult;
	JTextField tenResult;
	JTextField fiveResult;
	JTextField twoResult;
	JTextField oneResult;
	
	JLabel [] resultsTitle={new JLabel("£1 x "),new JLabel("50p x "),new JLabel("20p x "),new JLabel("10p x "),
			new JLabel("5p x "),new JLabel("2p x "),new JLabel("1p x ")};
	JTextField [] resultsOutput;
	
	
	public VendingMachineChange(){
		openUI();
	}
	
	private void openUI(){
		
		this.setLayout(new GridLayout(2, 1));
		this.setSize(800, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(400, 400,800,300);
		this.setTitle("Vending Machine Change");
		
		
		//Input Panel- Entering an amount of change.
		JPanel input=new JPanel();
		input.setLayout(new GridLayout(1,3));
		JLabel inputInstruction= new JLabel("Enter an amount of change (pence):");
		final JTextField inputChange = new JTextField();
		JButton submit=new JButton("Submit");
		submit.setSize(100, 75);
		input.setBorder(BorderFactory.createEmptyBorder(30,20,30,20));
		input.add(inputInstruction);
		input.add(inputChange);
		input.setVisible(true);
		input.add(submit);
		
		
		//Output Panel- Display change by coin.
		JPanel output=new JPanel();
		output.setLayout(new GridLayout(1, 14));
		output.setBorder(BorderFactory.createEmptyBorder(50,20,50,20));
		output.setVisible(true);
		resultsOutput=new JTextField[7];
		for(int i=0;i<7;i++){
			resultsOutput[i]= new JTextField("0");
			resultsOutput[i].setEditable(false);
			output.add(resultsTitle[i]);
			output.add(resultsOutput[i]);
		}
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Coin> result;
				try {
					result = (ArrayList<Coin>) change.getChangeFor(Integer.parseInt(inputChange.getText()));
					for(int i=0;i<7;i++)
						resultsOutput[i].setText(""+result.get(i).getNoOfCoins());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(rootPane, "Please enter only integers");
					e1.printStackTrace();
				} catch (InsufficentChangeException e1) {
					JOptionPane.showMessageDialog(rootPane, "Insufficent Change to continue");
					e1.printStackTrace();
				} catch (NegativeEntryException e1) {
					JOptionPane.showMessageDialog(rootPane, "Cannot enter negative numbers");
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		this.add(input);
		this.add(output);
		
		pack();
		
		repaint();
		
	}

}
