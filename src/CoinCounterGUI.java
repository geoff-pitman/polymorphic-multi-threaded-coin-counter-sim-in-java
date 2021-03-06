// Author: Geoffrey Pitman
// Creation Date: March 18, 2015
// Due Date: March 24, 2015
// Course:  CSC 243
// Professor Name: Dr. Kaplan
// Assignment #2: A Coin Counter Simulation
// Filename: CoinCounterGUI.java
// Purpose: This file contains the definition for the CoinCounterGUI class.  It displays
//			a coin counter GUI and refreshes relevant values on STOP and START.
//			It also contains the entry point for the project application (main method).
//			(The application begins by outputting the TestCoin class' test method)

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CoinCounterGUI {

	JLabel totalDollars = new JLabel("0.00");
	JLabel nPennies = new JLabel("0");
	JLabel nNickels = new JLabel("0");
	JLabel nDimes = new JLabel("0");
	JLabel nQuarters = new JLabel("0");
	JLabel nHalfDollars = new JLabel("0");
	JLabel nDollars = new JLabel("0");

	CoinCounterMechanism cm;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// test for Coin sub-classes
		TestCoins tc = new TestCoins();
		tc.testCoinOutput();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinCounterGUI window = new CoinCounterGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoinCounterGUI() {
		initialize();
	}

	void WindowUpdate(double total, int[] coinPile)
	{
		this.updateTotal(total);
		this.updatePennies(coinPile[0]);
		this.updateNickels(coinPile[1]);
		this.updateDimes(coinPile[2]);
		this.updateQuarters(coinPile[3]);
		this.updateHalfdollars(coinPile[4]);
		this.updateDollars(coinPile[5]);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 232, 66, 66);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources/penny.jpg"));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(79, 232, 66, 66);
		frame.getContentPane().add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("resources/nickel.jpg"));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(153, 232, 66, 66);
		frame.getContentPane().add(panel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("resources/dime.jpg"));
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(226, 220, 66, 77);
		frame.getContentPane().add(panel_3);
		
		JLabel label_2 = new JLabel("");
		panel_3.add(label_2);
		label_2.setIcon(new ImageIcon("resources/quarter.jpg"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(299, 232, 66, 66);
		frame.getContentPane().add(panel_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("resources/halfdollar.jpg"));
		panel_4.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(377, 221, 66, 77);
		frame.getContentPane().add(panel_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("resources/dollar.jpg"));
		panel_5.add(label_4);
		
		JLabel lblCoinCountingSimulation = new JLabel("Coin Counting Simulation");
		lblCoinCountingSimulation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCoinCountingSimulation.setBounds(104, 35, 271, 37);
		frame.getContentPane().add(lblCoinCountingSimulation);
		
		JLabel lblPennies = new JLabel("Pennies");
		lblPennies.setHorizontalAlignment(SwingConstants.CENTER);
		lblPennies.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPennies.setBounds(16, 298, 41, 16);
		frame.getContentPane().add(lblPennies);
		
		JLabel lblNickels = new JLabel("Nickels");
		lblNickels.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickels.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNickels.setBounds(89, 298, 41, 16);
		frame.getContentPane().add(lblNickels);
		
		JLabel lblDimes = new JLabel("Dimes");
		lblDimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDimes.setBounds(163, 297, 41, 16);
		frame.getContentPane().add(lblDimes);
		
		JLabel lblQuarters = new JLabel("Quarters");
		lblQuarters.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuarters.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblQuarters.setBounds(236, 297, 47, 16);
		frame.getContentPane().add(lblQuarters);
		
		JLabel lblHalfDollars = new JLabel("Half Dollars");
		lblHalfDollars.setHorizontalAlignment(SwingConstants.CENTER);
		lblHalfDollars.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblHalfDollars.setBounds(309, 297, 56, 16);
		frame.getContentPane().add(lblHalfDollars);
		
		JLabel lblDollars = new JLabel("Dollars");
		lblDollars.setHorizontalAlignment(SwingConstants.CENTER);
		lblDollars.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDollars.setBounds(387, 298, 41, 16);
		frame.getContentPane().add(lblDollars);
		
		JLabel lblTotalDollars = new JLabel("Total Dollars");
		lblTotalDollars.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDollars.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTotalDollars.setBounds(153, 84, 164, 37);
		frame.getContentPane().add(lblTotalDollars);
		

		totalDollars.setFont(new Font("Tahoma", Font.PLAIN, 48));
		totalDollars.setHorizontalAlignment(SwingConstants.CENTER);
		totalDollars.setBounds(153, 120, 189, 52);
		frame.getContentPane().add(totalDollars);
		
		nPennies.setHorizontalAlignment(SwingConstants.CENTER);
		nPennies.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nPennies.setBounds(16, 310, 41, 16);
		frame.getContentPane().add(nPennies);
		
		nNickels.setHorizontalAlignment(SwingConstants.CENTER);
		nNickels.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nNickels.setBounds(89, 310, 41, 16);
		frame.getContentPane().add(nNickels);
		
		nDimes.setHorizontalAlignment(SwingConstants.CENTER);
		nDimes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nDimes.setBounds(163, 310, 41, 16);
		frame.getContentPane().add(nDimes);
		
		nQuarters.setHorizontalAlignment(SwingConstants.CENTER);
		nQuarters.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nQuarters.setBounds(236, 309, 41, 16);
		frame.getContentPane().add(nQuarters);
		
		nHalfDollars.setHorizontalAlignment(SwingConstants.CENTER);
		nHalfDollars.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nHalfDollars.setBounds(319, 310, 41, 16);
		frame.getContentPane().add(nHalfDollars);
		
		nDollars.setHorizontalAlignment(SwingConstants.CENTER);
		nDollars.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nDollars.setBounds(387, 310, 41, 16);
		frame.getContentPane().add(nDollars);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm = new CoinCounterMechanism();
				cm.setConsumerFlag();
				cm.setProducerFlag();
				WindowUpdate(cm.getTotal(), cm.getCoinPile()); // update GUI values (will be 0's)
				cm.producer.start();
				cm.consumer.start();
			}
		});
		btnStart.setBounds(121, 383, 117, 29);
		frame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cm.resetConsumerFlag();
				cm.resetProducerFlag();
				WindowUpdate(cm.getTotal(), cm.getCoinPile()); // update GUI values
				cm = null;
				System.gc();
				
			}
		});
		btnStop.setBounds(248, 383, 117, 29);
		frame.getContentPane().add(btnStop);
	}
	
	public void updateTotal(double amount)
	{
		DecimalFormat mformat = new DecimalFormat("$0.00");
		String nString = mformat.format(amount);
		this.totalDollars.setText(nString);
	}
	
	public void updatePennies(int n)
	{
		String nString = String.format("%d", n);
		this.nPennies.setText(nString);
	}
	
	public void updateNickels(int n)
	{
		String nString = String.format("%d", n);
		this.nNickels.setText(nString);		
	}
	
	public void updateDimes(int n)
	{
		String nString = String.format("%d", n);
		this.nDimes.setText(nString);
	}
	
	public void updateQuarters(int n)
	{
		String nString = String.format("%d", n);
		this.nQuarters.setText(nString);
	}
	
	public void updateHalfdollars(int n)
	{
		String nString = String.format("%d", n);
		this.nHalfDollars.setText(nString);
	}
	
	public void updateDollars(int n)
	{
		String nString = String.format("%d", n);
		this.nDollars.setText(nString);
	}
}
