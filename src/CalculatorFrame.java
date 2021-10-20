/**
 * CalculatorFrame.java - builds the calculator 
 * 
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 10/11/18
 */

package lab6;

import java.awt.*;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultEditorKit;

public class CalculatorFrame {

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private static final int FRAME_WIDTH = 460;
	private static final int FRAME_HEIGHT = 200;
	private static int screenWidth = screenSize.width;
	private static int screenHeight = screenSize.height;
	private static int operator = 0;
	private static float xNumber = 0;
	private static float yNumber = 0;
	private static double result = 0;
	private static double storedNumber = 0;

	private static JFrame frame = new JFrame();
	private static JPanel keypad = new JPanel();

	// Menus
	private static JMenu viewMenu = new JMenu("View");
	private static JMenuItem standardItem = new JMenuItem("Standard");
	private static JMenuItem scientificItem = new JMenuItem("Scientific");
	private static JMenuItem dgroupItem = new JMenuItem("Digit Grouping");

	private static JMenu editMenu = new JMenu("Edit");
	private static JMenuItem copyItem = new JMenuItem("Copy");
	private static Action pasteItem = new DefaultEditorKit.PasteAction();

	private static JMenu helpMenu = new JMenu("Help");
	private static JMenuItem helpItem = new JMenuItem("Help Topics");
	private static JMenuItem aboutItem = new JMenuItem("About");

	// components
	private static JTextField displayField = new JTextField(10);
	private static JButton zeroBtn = new JButton("0");
	private static JButton oneBtn = new JButton("1");
	private static JButton twoBtn = new JButton("2");
	private static JButton threeBtn = new JButton("3");
	private static JButton fourBtn = new JButton("4");
	private static JButton fiveBtn = new JButton("5");
	private static JButton sixBtn = new JButton("6");
	private static JButton sevenBtn = new JButton("7");
	private static JButton eightBtn = new JButton("8");
	private static JButton nineBtn = new JButton("9");
	private static JButton pointBtn = new JButton(".");

	private static JButton equalsBtn = new JButton("=");
	private static JButton addBtn = new JButton("+");
	private static JButton subBtn = new JButton("-");
	private static JButton mulBtn = new JButton("*");
	private static JButton divBtn = new JButton("/");
	private static JButton sqrRtBtn = new JButton("√");
	private static JButton percentBtn = new JButton("%");
	private static JButton recipBtn = new JButton("1/x");
	private static JButton pos_NegBtn = new JButton("+/-");

	private static JButton clearBtn = new JButton("C");
	private static JButton clearEntryBtn = new JButton("CE");
	private static JButton backspaceBtn = new JButton("BS");
	private static JButton memClearBtn = new JButton("MC");
	private static JButton memRecallBtn = new JButton("MR");
	private static JButton memStoreBtn = new JButton("MS");
	private static JButton memPlusBtn = new JButton("M+");

	/**
	 * insertListener - A listener for the Jbutton's that insert a character into
	 * displayField
	 */
	public static class insertListener extends Frame implements ActionListener {

		/**
		 * Automatically called method when the button is clicked
		 * 
		 * @param e Required ActionEvent parameter from the ActionListener class
		 * @Override
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == oneBtn)
				displayField.setText(displayField.getText().concat("1"));

			if (e.getSource() == twoBtn)
				displayField.setText(displayField.getText().concat("2"));

			if (e.getSource() == threeBtn)
				displayField.setText(displayField.getText().concat("3"));

			if (e.getSource() == fourBtn)
				displayField.setText(displayField.getText().concat("4"));

			if (e.getSource() == fiveBtn)
				displayField.setText(displayField.getText().concat("5"));

			if (e.getSource() == sixBtn)
				displayField.setText(displayField.getText().concat("6"));

			if (e.getSource() == sevenBtn)
				displayField.setText(displayField.getText().concat("7"));

			if (e.getSource() == eightBtn)
				displayField.setText(displayField.getText().concat("8"));

			if (e.getSource() == nineBtn)
				displayField.setText(displayField.getText().concat("9"));

			if (e.getSource() == zeroBtn)
				displayField.setText(displayField.getText().concat("0"));

			if (e.getSource() == pointBtn)
				displayField.setText(displayField.getText().concat("."));
		}
	}

	/**
	 * operatorListener - A listener for buttons that perform an arithmetic
	 * operation
	 */
	public static class operatorListener extends Frame implements ActionListener {

		/**
		 * Automatically called method when the button is clicked
		 * 
		 * @param e Required ActionEvent parameter from the ActionListener class
		 * @Override
		 */
		public void actionPerformed(ActionEvent e) {

			System.out.println("operatorListener");

			if (e.getSource() == addBtn) {
				xNumber = Float.parseFloat(displayField.getText());
				displayField.setText("");
				operator = 1;
			}

			if (e.getSource() == subBtn) {
				xNumber = Float.parseFloat(displayField.getText());

				displayField.setText("");
				operator = 2;
			}

			if (e.getSource() == mulBtn) {
				xNumber = Float.parseFloat(displayField.getText());

				displayField.setText("");
				operator = 3;
			}

			if (e.getSource() == divBtn) {
				xNumber = Float.parseFloat(displayField.getText());

				displayField.setText("");
				operator = 4;
			}

			if (e.getSource() == equalsBtn) {
				yNumber = Float.parseFloat(displayField.getText());

				switch (operator) {
				case 1:
					
					result = xNumber + yNumber;
					break;
				case 2:
					result = xNumber - yNumber;
					break;
				case 3:
					result = xNumber * yNumber;
					break;
				case 4:
					result = xNumber / yNumber;
					break;
				case 5:
					result = xNumber + (xNumber * (yNumber / 100.0));
					break;
				default:
					result = 0;
				}

				displayField.setText("" + result);
				xNumber = (float) result;

			}

			if (e.getSource() == clearBtn) {
				displayField.setText("");
			}

			if (e.getSource() == clearEntryBtn) {
				displayField.setText(displayField.getText().substring(0,
						displayField.getText().length() - displayField.getText().length()));
			}

			if (e.getSource() == sqrRtBtn) {
				try {
					displayField.setText("" + Math.sqrt(Double.parseDouble(displayField.getText())));
				} catch (NumberFormatException nm) {
					JOptionPane.showMessageDialog(new JFrame(), "Can't square root 0!", "Error",
							JOptionPane.PLAIN_MESSAGE);
				}
			}

			if (e.getSource() == percentBtn) {
				xNumber = (float) Double.parseDouble(displayField.getText());
				displayField.setText("");

				operator = 5;
			}

			if (e.getSource() == recipBtn) {
				displayField.setText("" + 1 / Double.parseDouble(displayField.getText()));
			}

			if (e.getSource() == pos_NegBtn) {
				try {
					if (0 < Double.parseDouble(displayField.getText())) {
						displayField.setText("-" + displayField.getText());
					} else if (0 > Double.parseDouble(displayField.getText())) {

						displayField.setText("" + (Double.parseDouble(displayField.getText()) * -1.0));
					}
				} catch (NumberFormatException nm) {
					JOptionPane.showMessageDialog(new JFrame(), "Please input a number.", "Error",
							JOptionPane.PLAIN_MESSAGE);
				}
			}

			if (e.getSource() == backspaceBtn) {
				try {
					displayField.setText(displayField.getText().substring(0, displayField.getText().length() - 1));
				} catch (StringIndexOutOfBoundsException bs) {
					JOptionPane.showMessageDialog(new JFrame(), "Nothing to backspace.", "Error",
							JOptionPane.PLAIN_MESSAGE);
				}
			}

		}
	}

	/**
	 * menuListener - A listener for menu items
	 */
	public static class menuListener extends Frame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == standardItem) {

			}

			if (e.getSource() == scientificItem) {

			}

			if (e.getSource() == dgroupItem) {
				// TODO Auto-generated method stub
				double amount = Double.parseDouble(displayField.getText());
				DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###");

				displayField.setText(formatter.format(amount));
			}

			if (e.getActionCommand().equals("Copy")) {
				ClipboardOwner clpbrd = (ClipboardOwner) Toolkit.getDefaultToolkit().getSystemClipboard();

				StringSelection stringSelection = new StringSelection(displayField.getText());
				((java.awt.datatransfer.Clipboard) clpbrd).setContents(stringSelection, null);
			}

			if (e.getSource() == helpItem) {
				JOptionPane.showMessageDialog(new JFrame(),
						"The red buttons are operators or functions of the calculator.\nThe blue buttons are numbers. Click on these to input numbers.",
						"Help", JOptionPane.PLAIN_MESSAGE);
			}

			if (e.getSource() == aboutItem) {
				JOptionPane.showMessageDialog(new JFrame(), "Calculator\nDesigned by Max Petts | eeub35", "About",
						JOptionPane.PLAIN_MESSAGE);
			}

		}

	}

	/**
	 * memoryListener - A listener buttons that perform memory operations
	 */
	public static class memoryListener extends Frame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == memClearBtn) {
				storedNumber = 0;
			}
			if (e.getSource() == memRecallBtn) {
				String number = "" + storedNumber;
				displayField.setText(number);
				xNumber = (float) storedNumber;
				operator = 0;
			}
			if (e.getSource() == memStoreBtn) {
				storedNumber = Double.parseDouble(displayField.getText());
			}
			if (e.getSource() == memPlusBtn) {
				double store2 = 0;
				store2 = storedNumber + Double.parseDouble(displayField.getText());

				try {
					store2 = storedNumber + Double.parseDouble(displayField.getText()); // add mem value to current
																						// textfield
					// value
					String store3 = String.valueOf(store2);
					displayField.setText(store3);

				} catch (NumberFormatException nm) {
					JOptionPane.showMessageDialog(new JFrame(), "Can't do that.", "Error", JOptionPane.PLAIN_MESSAGE);

				}
			}
		}

	}

	/**
	 * Adds a component to a specified container with a gridBag layout and supplied
	 * constraints
	 * 
	 * @param component  ie. button
	 * @param container  ie. frame
	 * @param a
	 * @param gc
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 */
	private static void addComponent(Component component, Container container, GridBagLayout a, GridBagConstraints gc,
			int gridx, int gridy, int gridwidth, int gridheight) {
		gc.gridx = gridx;
		gc.gridy = gridy;

		gc.gridwidth = gridwidth;
		gc.gridheight = gridheight;

		gc.ipadx = 1;
		gc.ipady = 5;

		a.setConstraints(component, gc);
		container.add(component, gc);
	}

	/**
	 * Creates the edit menu and adds listeners to menu items
	 * 
	 * @param menuListener The listener for all menu items
	 * @return editMenu
	 */
	private static JMenu menuEdit(ActionListener menuListener) {

		pasteItem.putValue(Action.NAME, "Paste");

		copyItem.addActionListener(menuListener);

		editMenu.add(copyItem);
		editMenu.add(pasteItem);

		return editMenu;
	}

	/**
	 * Creates the view menu and adds listeners to menu items
	 * 
	 * @param menuListener The listener for all menu items
	 * @return
	 */
	private static JMenu menuView(ActionListener menuListener) {

		dgroupItem.addActionListener(menuListener);

		viewMenu.add(standardItem);
		viewMenu.add(scientificItem);
		viewMenu.addSeparator();
		viewMenu.add(dgroupItem);

		return viewMenu;
	}

	/**
	 * Creates the help menu and adds listeners to menu items
	 * 
	 * @param menuListener The listener for all menu items
	 * @return
	 */
	private static JMenu menuHelp(ActionListener menuListener) {

		helpItem.addActionListener(menuListener);
		aboutItem.addActionListener(menuListener);

		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutItem);

		return helpMenu;
	}

	/**
	 * Constructs the calculator
	 */
	public CalculatorFrame() {

		ActionListener insertListener = new insertListener();
		ActionListener operatorListener = new operatorListener();
		ActionListener memoryListener = new memoryListener();
		ActionListener menuListener = new menuListener();
		GridBagLayout keypadLayout = new GridBagLayout();
		GridBagConstraints topRowConstraints = new GridBagConstraints();
		GridBagConstraints mainPadConstraints = new GridBagConstraints();
		JMenuBar menuBar = new JMenuBar();
		Font displayFieldFont = new Font("SansSerif", Font.PLAIN, 20);

		// Set frame attributes
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation((screenWidth - FRAME_WIDTH) / 2, (screenHeight - FRAME_HEIGHT) / 2);
		frame.setResizable(false);
		frame.setJMenuBar(menuBar);
		JFrame.setDefaultLookAndFeelDecorated(true);

		menuBar.add(menuEdit(menuListener));
		menuBar.add(menuView(menuListener));
		menuBar.add(menuHelp(menuListener));

		// Set Gridbag constraints
		topRowConstraints.fill = GridBagConstraints.HORIZONTAL;
		// topRowConstraints.insets = new Insets(0, 1, 0, 1);
		mainPadConstraints.fill = GridBagConstraints.BOTH;
		// mainPadConstraints.insets = new Insets(1, 1, 1, 1);

		keypad.setLayout(keypadLayout);

		displayField.setEditable(false);
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		displayField.setFont(displayFieldFont);

		// Add action listeners to components
		zeroBtn.addActionListener(insertListener);
		oneBtn.addActionListener(insertListener);
		twoBtn.addActionListener(insertListener);
		threeBtn.addActionListener(insertListener);
		fourBtn.addActionListener(insertListener);
		fiveBtn.addActionListener(insertListener);
		sixBtn.addActionListener(insertListener);
		sevenBtn.addActionListener(insertListener);
		eightBtn.addActionListener(insertListener);
		nineBtn.addActionListener(insertListener);
		pointBtn.addActionListener(insertListener);

		divBtn.addActionListener(operatorListener);
		mulBtn.addActionListener(operatorListener);
		addBtn.addActionListener(operatorListener);
		subBtn.addActionListener(operatorListener);
		equalsBtn.addActionListener(operatorListener);
		sqrRtBtn.addActionListener(operatorListener);
		percentBtn.addActionListener(operatorListener);
		recipBtn.addActionListener(operatorListener);
		pos_NegBtn.addActionListener(operatorListener);
		backspaceBtn.addActionListener(operatorListener);
		clearBtn.addActionListener(operatorListener);

		memClearBtn.addActionListener(memoryListener);
		memRecallBtn.addActionListener(memoryListener);
		memStoreBtn.addActionListener(memoryListener);
		memPlusBtn.addActionListener(memoryListener);

		// Set button colours
		zeroBtn.setForeground(Color.BLUE);
		oneBtn.setForeground(Color.BLUE);
		twoBtn.setForeground(Color.BLUE);
		threeBtn.setForeground(Color.BLUE);
		fourBtn.setForeground(Color.BLUE);
		fiveBtn.setForeground(Color.BLUE);
		sixBtn.setForeground(Color.BLUE);
		sevenBtn.setForeground(Color.BLUE);
		eightBtn.setForeground(Color.BLUE);
		nineBtn.setForeground(Color.BLUE);
		pointBtn.setForeground(Color.BLUE);

		divBtn.setForeground(Color.RED);
		mulBtn.setForeground(Color.RED);
		addBtn.setForeground(Color.RED);
		subBtn.setForeground(Color.RED);
		equalsBtn.setForeground(Color.RED);
		backspaceBtn.setForeground(Color.RED);
		clearEntryBtn.setForeground(Color.RED);
		clearBtn.setForeground(Color.RED);
		memClearBtn.setForeground(Color.RED);
		memRecallBtn.setForeground(Color.RED);
		memStoreBtn.setForeground(Color.RED);
		memPlusBtn.setForeground(Color.RED);
		pos_NegBtn.setForeground(Color.RED);
		sqrRtBtn.setForeground(Color.RED);
		percentBtn.setForeground(Color.RED);
		recipBtn.setForeground(Color.RED);

		// Add components
		// row 0
		addComponent(backspaceBtn, keypad, keypadLayout, topRowConstraints, 2, 0, 2, 1);
		addComponent(clearEntryBtn, keypad, keypadLayout, topRowConstraints, 4, 0, 2, 1);
		addComponent(clearBtn, keypad, keypadLayout, topRowConstraints, 6, 0, 2, 1);
		// row 1
		addComponent(memClearBtn, keypad, keypadLayout, mainPadConstraints, 1, 1, 1, 1);
		addComponent(sevenBtn, keypad, keypadLayout, mainPadConstraints, 2, 1, 1, 1);
		addComponent(eightBtn, keypad, keypadLayout, mainPadConstraints, 3, 1, 1, 1);
		addComponent(nineBtn, keypad, keypadLayout, mainPadConstraints, 4, 1, 1, 1);
		addComponent(divBtn, keypad, keypadLayout, mainPadConstraints, 5, 1, 1, 1);
		addComponent(sqrRtBtn, keypad, keypadLayout, mainPadConstraints, 6, 1, 1, 1);
		// row 2
		addComponent(memRecallBtn, keypad, keypadLayout, mainPadConstraints, 1, 2, 1, 1);
		addComponent(fourBtn, keypad, keypadLayout, mainPadConstraints, 2, 2, 1, 1);
		addComponent(fiveBtn, keypad, keypadLayout, mainPadConstraints, 3, 2, 1, 1);
		addComponent(sixBtn, keypad, keypadLayout, mainPadConstraints, 4, 2, 1, 1);
		addComponent(mulBtn, keypad, keypadLayout, mainPadConstraints, 5, 2, 1, 1);
		addComponent(percentBtn, keypad, keypadLayout, mainPadConstraints, 6, 2, 1, 1);
		// row 3
		addComponent(memStoreBtn, keypad, keypadLayout, mainPadConstraints, 1, 3, 1, 1);
		addComponent(oneBtn, keypad, keypadLayout, mainPadConstraints, 2, 3, 1, 1);
		addComponent(twoBtn, keypad, keypadLayout, mainPadConstraints, 3, 3, 1, 1);
		addComponent(threeBtn, keypad, keypadLayout, mainPadConstraints, 4, 3, 1, 1);
		addComponent(subBtn, keypad, keypadLayout, mainPadConstraints, 5, 3, 1, 1);
		addComponent(recipBtn, keypad, keypadLayout, mainPadConstraints, 6, 3, 1, 1);
		// row 4
		addComponent(memPlusBtn, keypad, keypadLayout, mainPadConstraints, 1, 4, 1, 1);
		addComponent(pos_NegBtn, keypad, keypadLayout, mainPadConstraints, 2, 4, 1, 1);
		addComponent(zeroBtn, keypad, keypadLayout, mainPadConstraints, 3, 4, 1, 1);
		addComponent(pointBtn, keypad, keypadLayout, mainPadConstraints, 4, 4, 1, 1);
		addComponent(addBtn, keypad, keypadLayout, mainPadConstraints, 5, 4, 1, 1);
		addComponent(equalsBtn, keypad, keypadLayout, mainPadConstraints, 6, 4, 1, 1);

		// Add panels or components to frame
		frame.add(displayField, BorderLayout.CENTER);
		frame.add(keypad, BorderLayout.SOUTH);

		frame.setVisible(true);
		frame.pack();
	}
}