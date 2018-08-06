package com.pucci;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PucciStore {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PucciStore window = new PucciStore();
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
	public PucciStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.PINK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 920, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnWelcomeToPucci = new JTextPane();
		txtpnWelcomeToPucci.setFont(new Font("Freebooter Script", Font.PLAIN, 59));
		txtpnWelcomeToPucci.setBackground(UIManager.getColor("Button.background"));
		txtpnWelcomeToPucci.setText("  Welcome to  Pucci");
		txtpnWelcomeToPucci.setBounds(219, 30, 402, 89);
		frame.getContentPane().add(txtpnWelcomeToPucci);
		
		JButton btnTops = new JButton("Tops");
		btnTops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensTopsStore show = new MensTopsStore();
				show.showMensTops();
			}
		});
		btnTops.setFont(new Font("Ink Free", Font.BOLD, 22));
		btnTops.setBounds(163, 234, 149, 43);
		frame.getContentPane().add(btnTops);
		
		JButton btnBottoms = new JButton("Bottoms");
		btnBottoms.setFont(new Font("Ink Free", Font.BOLD, 22));
		btnBottoms.setBounds(163, 293, 149, 43);
		frame.getContentPane().add(btnBottoms);
		
		JButton btnShoes = new JButton("Shoes");
		btnShoes.setFont(new Font("Ink Free", Font.BOLD, 22));
		btnShoes.setBounds(163, 357, 149, 43);
		frame.getContentPane().add(btnShoes);
		
		JTextPane txtpnMens = new JTextPane();
		txtpnMens.setBackground(UIManager.getColor("Button.background"));
		txtpnMens.setFont(new Font("Freebooter Script", Font.BOLD, 33));
		txtpnMens.setText("Mens");
		txtpnMens.setBounds(192, 175, 90, 43);
		frame.getContentPane().add(txtpnMens);
		
		JTextPane txtpnWomens = new JTextPane();
		txtpnWomens.setText(" Womens");
		txtpnWomens.setFont(new Font("Freebooter Script", Font.BOLD, 33));
		txtpnWomens.setBackground(SystemColor.menu);
		txtpnWomens.setBounds(546, 175, 119, 43);
		frame.getContentPane().add(txtpnWomens);
		
		JButton button = new JButton("Tops");
		button.setFont(new Font("Ink Free", Font.BOLD, 22));
		button.setBounds(530, 234, 149, 43);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Bottoms");
		button_1.setFont(new Font("Ink Free", Font.BOLD, 22));
		button_1.setBounds(530, 293, 149, 43);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Shoes");
		button_2.setFont(new Font("Ink Free", Font.BOLD, 22));
		button_2.setBounds(530, 357, 149, 43);
		frame.getContentPane().add(button_2);
	}
}
