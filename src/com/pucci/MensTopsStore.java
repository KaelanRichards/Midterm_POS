package com.pucci;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MensTopsStore {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void showMensTops () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MensTopsStore window = new MensTopsStore();
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
	public MensTopsStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
