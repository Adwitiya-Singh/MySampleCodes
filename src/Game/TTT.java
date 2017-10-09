package Game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener {
	public static final int BOARD_SIZE = 3;
	private String playerOne;
	private String playerTwo;
	private boolean crossTurn = true;
	private JButton[][] buttons = new JButton[3][3];

	private enum GameStatus {
		Incomplete, XWins, ZWins, Tie
	}


	public TTT() {
		super.setDefaultCloseOperation(3);
		super.setTitle("Tic Tac Toe");
		super.setSize(400, 400);
		GridLayout grid = new GridLayout(3, 3);
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

		super.setResizable(false);
		super.setVisible(true);


		this.playerOne = JOptionPane.showInputDialog(this, "Input first player's name");
		if (this.playerOne .equals("")||this.playerOne==null) {
			this.playerOne = "Player One";
		}

		this.playerTwo = JOptionPane.showInputDialog(this, "Input second player's name");
		if (this.playerTwo.equals("")||this.playerTwo==null) {
			this.playerTwo = "Player One";
		}
	}






	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		this.makemove(clickedButton);
		GameStatus GameStatusNow = this.getGameStatus();
		if (GameStatusNow != GameStatus.Incomplete) {
			this.declareWinner(GameStatusNow);
			int replay = JOptionPane.showConfirmDialog(this, "Replay?");
			if (replay == JOptionPane.YES_OPTION) {
				for (int row = 0; row < BOARD_SIZE; row++) {
					for (int col = 0; col < BOARD_SIZE; col++) {
						buttons[row][col].setText("");
					}
				}
				crossTurn = true;
			} else {
				super.dispose();
			}
		}

	}

	private void makemove(JButton clickedButton) {
		String buttonText = clickedButton.getText();
		if (buttonText.length() > 0) {
			JOptionPane.showMessageDialog(this, "Invalid Move");
		} else {
			if (this.crossTurn) {
				clickedButton.setText("X");

			} else {
				clickedButton.setText("O");
			}
			this.crossTurn = !this.crossTurn;
		}
	}

	private GameStatus getGameStatus() {
		boolean Xwins = true;
		boolean Zwins = true;

		int row;
		int col;
		for(row = 0; row < 3; ++row) {
			for(col = 0; col < 3; ++col) {
				if (!Objects.equals(this.buttons[row][col].getText(), "X")) {
					Xwins = false;
				}

				if (!Objects.equals(this.buttons[row][col].getText(), "O")) {
					Zwins = false;
				}
			}

			if (Xwins) {
				return GameStatus.XWins;
			}

			if (Zwins) {
				return GameStatus.ZWins;
			}

			Xwins = true;
			Zwins = true;
		}

		for(row = 0; row < 3; ++row) {
			for(col = 0; col < 3; ++col) {
				if (!Objects.equals(this.buttons[col][row].getText(), "X")) {
					Xwins = false;
				}

				if (!Objects.equals(this.buttons[col][row].getText(), "O")) {
					Zwins = false;
				}
			}

			if (Xwins) {
				return GameStatus.XWins;
			}

			if (Zwins) {
				return GameStatus.ZWins;
			}

			Xwins = true;
			Zwins = true;
		}

		for(row = 0; row < 3; ++row) {
			for(col = 0; col < 3; ++col) {
				if (row == col) {
					if (!Objects.equals(this.buttons[col][row].getText(), "X")) {
						Xwins = false;
					}

					if (!Objects.equals(this.buttons[col][row].getText(), "O")) {
						Zwins = false;
					}
				}
			}
		}

		if (Xwins) {
			return GameStatus.XWins;
		} else if (Zwins) {
			return GameStatus.ZWins;
		} else {
			Xwins = true;
			Zwins = true;

			for(row = 0; row < 3; ++row) {
				for(col = 0; col < 3; ++col) {
					if (row + col == 2) {
						if (!Objects.equals(this.buttons[col][row].getText(), "X")) {
							Xwins = false;
						}

						if (!Objects.equals(this.buttons[col][row].getText(), "O")) {
							Zwins = false;
						}
					}
				}
			}

			if (Xwins) {
				return GameStatus.XWins;
			} else if (Zwins) {
				return GameStatus.ZWins;
			} else {
				for(row = 0; row < 3; ++row) {
					for(col = 0; col < 3; ++col) {
						if (this.buttons[row][col].getText().length() == 0) {
							return GameStatus.Incomplete;
						}
					}
				}

				return GameStatus.Tie;
			}
		}
	}

	private void declareWinner(GameStatus gs) {
		if (gs == GameStatus.XWins) {
			JOptionPane.showMessageDialog(this, this.playerOne + " Wins!");
		}

		if (gs == GameStatus.ZWins) {
			JOptionPane.showMessageDialog(this, this.playerTwo + " Wins!");
		}

		if (gs == GameStatus.Tie) {
			JOptionPane.showMessageDialog(this, "It's a Tie! ");
		}

	}
}
