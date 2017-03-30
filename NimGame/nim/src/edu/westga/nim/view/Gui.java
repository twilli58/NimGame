package edu.westga.nim.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import edu.westga.nim.model.Game;
import edu.westga.nim.model.Player;
import edu.westga.nim.model.strategies.CautiousStrategy;
import edu.westga.nim.model.strategies.GreedyStrategy;
import edu.westga.nim.model.strategies.RandomStrategy;

/**
 * Defines the GUI for the 1-pile Nim game.
 *  
 * @author CS 6910
 * @version Summer 2013
 */
public class Gui {
	
	private static final Integer[] INITIAL_PILE_SIZES = {21, 16, 9};

	private JFrame theFrame;
	private Container contentPane;	
	
	private HumanPlayerPanel theHumanPlayerPanel;
	private ComputerPlayerPanel theComputerPlayerPanel;
	private JPanel theGameInfoPanel;
	private JPanel theNewGamePanel;
	private Game theGame;
	private JMenuBar menuBar;
	private JMenu menu;

	private boolean shouldShowHelpDialog;	
	
	
	
	/**
	 * Creates a Gui object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model of the Nim game
	 * 
	 * @requires theGame != null
	 * @ensures	 the GUI is displayed
	 */
	public Gui(Game theGame) {
		this.theGame = theGame;
		this.shouldShowHelpDialog = true;
		this.createAndShowGUI();
	}
	
	
	
	//****************************** private helper methods *******************

	private void createAndShowGUI() {
		this.theFrame = new JFrame("Simple Nim");
		
		this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.theFrame.setLayout(new BorderLayout());
		
		this.buildMenuBar();
				
		this.contentPane = this.theFrame.getContentPane();
		this.buildContentPane();

		this.theFrame.pack();
		this.theFrame.setVisible(true);
		
		this.shouldShowHelpDialog = this.showHelpDialog();
	}

	private boolean showHelpDialog() {
		if (!this.shouldShowHelpDialog) {
			return false;
		}
		
		JCheckBox shouldShowCheckBox = 
				new JCheckBox("Show this message when starting a new game.", false);
		
		Object[] msgContent = {this.buildHelpPane(), shouldShowCheckBox };

		JOptionPane.showMessageDialog(this.theFrame, msgContent,
				"Title", JOptionPane.INFORMATION_MESSAGE);

		return shouldShowCheckBox.isSelected(); 
		
	}


	private JScrollPane buildHelpPane() {
		String helpMessage = 
				"Nim rules: Play against the computer. " +
				"Alternate taking turns, removing 1 to 3 sticks per turn. " +
				"The player who takes the last stick loses. " +
				"You may set the number of sticks on the pile at the start " +
				"of each game, and switch what strategy the computer uses " +
				"at any time.";
		
		JTextArea helpTextArea = new JTextArea(helpMessage);
		helpTextArea.setRows(4);
		helpTextArea.setColumns(40);
		helpTextArea.setLineWrap(true);
		helpTextArea.setWrapStyleWord(true);
		helpTextArea.setEditable(false);
		helpTextArea.setOpaque(false);
		
		JScrollPane helpPane = new JScrollPane(helpTextArea);
		return helpPane;
	}



	private void buildMenuBar() {
		this.menuBar = new JMenuBar();
		
		this.buildFileMenu();
		this.buildSettingsMenu();
				
		this.theFrame.setJMenuBar(this.menuBar);
	}



	private void buildSettingsMenu() {
		this.menu = new JMenu("Settings");
		this.menu.setMnemonic(KeyEvent.VK_S);
		this.menu.getAccessibleContext().setAccessibleDescription("Settings menu");
		
		this.buildComputerPlayerMenu();
		
		this.menuBar.add(this.menu);
	}



	private void buildComputerPlayerMenu() {
		JMenu computerPlayerMenu = new JMenu("Computer Player");
		computerPlayerMenu.setMnemonic(KeyEvent.VK_P);
		
		JMenuItem menuItem = new JMenuItem("Cautious", KeyEvent.VK_C); 
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theGame.computerPlayer().setStrategy(new CautiousStrategy());
			}
		});		
		computerPlayerMenu.add(menuItem);
		
		menuItem = new JMenuItem("Greedy", KeyEvent.VK_G); 
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theGame.computerPlayer().setStrategy(new GreedyStrategy());
			}
		});		
		computerPlayerMenu.add(menuItem);
		
		menuItem = new JMenuItem("Random", KeyEvent.VK_R); 
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theGame.computerPlayer().setStrategy(new RandomStrategy());
			}
		});		
		computerPlayerMenu.add(menuItem);
		
		this.menu.add(computerPlayerMenu);
	}



	private void buildFileMenu() {
		this.menu = new JMenu("File");
		this.menu.setMnemonic(KeyEvent.VK_F);
		this.menu.getAccessibleContext().setAccessibleDescription("File menu");
		
		JMenuItem menuItem = new JMenuItem("New game", KeyEvent.VK_N); 
		menuItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theNewGamePanel.setEnabled(true);
				theHumanPlayerPanel.setEnabled(false);
				theComputerPlayerPanel.resetNumberTaken();
				theHumanPlayerPanel.resetNumberToTakeComboBox(Game.MAX_STICKS_PER_TURN);
				if (shouldShowHelpDialog) {
					shouldShowHelpDialog = showHelpDialog();
				}
			}
		});		
		this.menu.add(menuItem);
		
		this.menu.addSeparator();
		
		menuItem = new JMenuItem("Exit", KeyEvent.VK_X); 
		menuItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});		
		this.menu.add(menuItem);
		
		this.menuBar.add(this.menu);
	}



	private void buildContentPane() {
		
		this.theNewGamePanel = 
				new NewGamePanel(this.theGame);
		this.contentPane.add(this.theNewGamePanel, 
							 BorderLayout.NORTH);
		
		this.theHumanPlayerPanel = 
				new HumanPlayerPanel(this.theGame);		
		this.contentPane.add(this.theHumanPlayerPanel, BorderLayout.WEST);
		this.theHumanPlayerPanel.setEnabled(false);
		
		this.theGameInfoPanel = new GameStatusPanel(this.theGame);
		this.contentPane.add(this.theGameInfoPanel, BorderLayout.SOUTH);
		
		this.theComputerPlayerPanel = 
				new ComputerPlayerPanel(this.theGame);
		this.contentPane.add(this.theComputerPlayerPanel, BorderLayout.CENTER);
		this.theComputerPlayerPanel.setEnabled(false);
	}
	
	
	
	//************************* private inner classes *************************
	
	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private class NewGamePanel extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		private JRadioButton humanPlayerButton;
		private JRadioButton computerPlayerButton;
		private JRadioButton randomPlayerButton;
		
		private JComboBox<Integer> pileSizeComboBox;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private ButtonGroup buttons;

		private NewGamePanel(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.humanPlayer();
			this.theComputer = this.theGame.computerPlayer();
			
			
			this.buildPanel();
		}
		
		private void buildPanel() {
			this.setBorder(BorderFactory.createTitledBorder("Start new game"));	
			
			this.addPileSizeComboBox();
			this.add(Box.createHorizontalStrut(25));
			this.addPlayerButtons();
		}

		private void addPileSizeComboBox() {
						
			JLabel pileSizeLabel = new JLabel("Initial pile size:");
			this.add(pileSizeLabel);
			
			this.pileSizeComboBox = new JComboBox<Integer>(INITIAL_PILE_SIZES);
			this.pileSizeComboBox.setEditable(false);
			this.pileSizeComboBox.addActionListener(new PileSizeListener());
			this.add(this.pileSizeComboBox);
		}

		private void addPlayerButtons() {
			JLabel firstPlayerLabel = new JLabel("Who plays first?");
			this.add(firstPlayerLabel);
			
			this.humanPlayerButton = new JRadioButton("Human");	
			this.humanPlayerButton.addActionListener(new HumanFirstListener());
			
			this.computerPlayerButton = new JRadioButton("Computer");
			this.computerPlayerButton.addActionListener(new ComputerFirstListener());
			
			this.randomPlayerButton = new JRadioButton("Random player");
			this.randomPlayerButton.addActionListener(new RandomFirstListener());
			
			this.buttons = new ButtonGroup();
			buttons.add(this.humanPlayerButton);
			buttons.add(this.computerPlayerButton);
			buttons.add(this.randomPlayerButton);			
			
			this.add(this.humanPlayerButton);
			this.add(this.computerPlayerButton);
			this.add(this.randomPlayerButton);
		}
		
		/** 
		 * Sets whether or not this panel and its components are enabled.
		 * 
		 * @param  enabled true if this component should be enabled, false otherwise	
		 * @see javax.swing.JComponent#setEnabled(boolean)
		 * 
		 * @ensures enabled() == enabled &&		<br />
		 * 			for each Component c in getComponents(), c.enabled() == enabled
		 */
		@Override
		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			
			for (Component aComponent: this.getComponents()) {
				aComponent.setEnabled(!aComponent.isEnabled());
			}
			
			this.buttons.clearSelection();
		}
		
		/* 
		 * Defines the listener for computerPlayerButton.
		 */		
		private class ComputerFirstListener implements ActionListener {
			
			/* 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
					
				theComputerPlayerPanel.setEnabled(true);
				theHumanPlayerPanel.setEnabled(true);
				setEnabled(false);
				theGame.startNewGame(theComputer, theHuman, 
						(int)pileSizeComboBox.getSelectedItem());
				theComputer.setPileForThisTurn(theGame.pile());
				theComputer.setNumberSticksToTake();
				theGame.play();
			}
		}

		
		/* 
		 * Defines the listener for humanPlayerButton.
		 */	
		private class HumanFirstListener implements ActionListener {

			/* 
			 * Enables the HumanPlayerPanel and starts a new game. 
			 * Event handler for a click in the humanPlayerButton.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				theHumanPlayerPanel.setEnabled(true);
				theComputerPlayerPanel.setEnabled(true);
				setEnabled(false);
				theGame.startNewGame(theHuman, theComputer, 
						(int)pileSizeComboBox.getSelectedItem());
			}
		}
		
		
		/* 
		 * Defines the listener for randomPlayerButton.
		 */	
		private class RandomFirstListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random generator = new Random();
				boolean computerFirst = (generator.nextInt(2) == 0);
				
				theHumanPlayerPanel.setEnabled(true);
				theComputerPlayerPanel.setEnabled(true);
				setEnabled(false);
				
				if (computerFirst) {
					theGame.startNewGame(
									theComputer, theHuman, 
									(int)pileSizeComboBox.getSelectedItem());
					theComputer.setPileForThisTurn(theGame.pile());
					theComputer.setNumberSticksToTake();
					theGame.play();
				}
				else {
					theGame.startNewGame(
									theHuman, theComputer, 
									(int)pileSizeComboBox.getSelectedItem());
				}
			}

		}
		
		private class PileSizeListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				theGame.setPileSize((int)pileSizeComboBox.getSelectedItem());

			}

		}
		
	}

}
