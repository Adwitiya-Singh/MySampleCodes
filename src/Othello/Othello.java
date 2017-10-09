package Othello;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Othello extends JFrame implements ActionListener {
	public static final int BOARD_SIZE = 8;
	private String playerOne;
	private String playerTwo;
	private boolean whiteTurn = true;
	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

	private static enum GameStatus {
		Incomplete, XWins, ZWins, Tie;
	}

	public Othello() {
		super.setTitle("OTHELLO");
		super.setSize(600, 600);
		GridLayout grid = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(grid);
		Font font = new Font("Times New Roman", 1, 100);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton("");
				buttons[row][col] = button;
				button.setFont(font);
				super.add(button);

				button.addActionListener(this);
			}
		}
		buttons[3][3].setBackground(Color.WHITE);
		buttons[3][3].setOpaque(true);
		buttons[3][3].setBorderPainted(false);

		buttons[4][3].setBackground(Color.BLACK);
		buttons[4][3].setOpaque(true);
		buttons[4][3].setBorderPainted(false);

		buttons[3][4].setBackground(Color.WHITE);
		buttons[3][4].setOpaque(true);
		buttons[3][4].setBorderPainted(false);

		buttons[4][4].setBackground(Color.BLACK);
		buttons[4][4].setOpaque(true);
		buttons[4][4].setBorderPainted(false);

		super.setResizable(false);
		super.setVisible(true);
		playerOne = JOptionPane.showInputDialog(this, "Input first player's name");
		if (playerOne == null) {
			playerOne = "Player One";
		}
		playerTwo = JOptionPane.showInputDialog(this, "Input second player's name");
		if (playerTwo == null) {
			playerTwo = "Player One";

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
	}

}
