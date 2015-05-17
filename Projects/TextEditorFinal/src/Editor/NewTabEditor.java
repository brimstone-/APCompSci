package Editor;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.io.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.apache.commons.io.*;

class NewTabEditor implements Runnable { // Trying again, this time with tabs
	// Declare all variables to be used

	// Set up various containers, tabs goes in frame, the panels go in the tabs
	private JFrame frame = new JFrame("MattPad++");
	private JTabbedPane tabs = new JTabbedPane();
	private JPanel panel = new JPanel();
	private JPanel plusPanel = new JPanel();

	// TextArea and ScrollPane that contains it
	// These are from the RSyntaxTextArea library
	private RSyntaxTextArea text = new RSyntaxTextArea();
	private RTextScrollPane scroll = new RTextScrollPane(text);

	// Set up menus and their items
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenuItem openButton = new JMenuItem("Open");
	private	JMenuItem newButton = new JMenuItem("New Tab");
	private JMenuItem closeButton = new JMenuItem("Close Tab");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem toggle = new JMenuItem("Toggle Syntax Highlighting");

	// Listener for my add tab button
	private ChangeListener listener;

	// File Chooser
	private JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

	// Set up Monospaced font because those are best
	private Font monospaced = new Font(Font.MONOSPACED, Font.PLAIN, 14);

	// I need to keep track of the number of tabs, mostly because of the add tab button
	private int numTabs = 0;

	// For my toggle highlighting menu item
	private boolean highlight = true;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new NewTabEditor());  // invokeLater(new Runnable()) is nice because it lets me update the gui.
		System.setProperty("awt.useSystemAAFontSettings", "lcd"); // Anti-Alias fonts
		System.setProperty("swing.aatext", "true");
	}

	public void run() {
		listener = new ChangeListener() {  // ChangeListener for the adding tabs button
			public void stateChanged(ChangeEvent e) {
				addNewTab();
			}
		};

		// Time to make all my declarations actual objects
		panel.setLayout(new BorderLayout());
		panel.add(scroll, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder());

		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);  // This method is for the syntax
																		// highlighting that comes
																		// with RSyntaxTextAreas
		text.setFont(monospaced); // Set font

		tabs.add(panel, "Untitled", numTabs++); // Add default tab

		tabs.add(plusPanel, "+", numTabs++); // Here I add the add tab button
		tabs.addChangeListener(listener); // Add my listener
		tabs.addMouseListener(new MiddleClickListener());   // This mouse listener is for
															// closing tabs with middle mouse click

		// Set mnemonics/accelerators for keyboard shortcuts, activated with CTRL+KEY
		file.setMnemonic(KeyEvent.VK_F);
		openButton.setMnemonic(KeyEvent.VK_O);
		openButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		newButton.setMnemonic(KeyEvent.VK_N);
		newButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		closeButton.setMnemonic(KeyEvent.VK_W);
		closeButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		quit.setMnemonic(KeyEvent.VK_Q);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

		edit.setMnemonic(KeyEvent.VK_E);
		toggle.setMnemonic(KeyEvent.VK_T);
		toggle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));


		// Listeners for the menu items
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					readFile(fileChooser.getSelectedFile().getAbsolutePath());
					// Use the file reader to get the selected file,
					// and then find it's full directory path.
					// This is then given to the readFile method.
				}
			}
		});

		newButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (numTabs > 1) {
					int index = tabs.getSelectedIndex();
					
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());

					RSyntaxTextArea text = new RSyntaxTextArea();
					text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
					text.setFont(monospaced);

					RTextScrollPane scroll = new RTextScrollPane(text);

					panel.add(scroll, BorderLayout.CENTER);
					panel.setBorder(BorderFactory.createEmptyBorder());

					tabs.add(panel, "Untitled", index + 1);
					
					numTabs++;
					
					SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
						@Override
						public void run() {
							tabs.setSelectedIndex(index + 1);
						}
					});
				} else {
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());

					RSyntaxTextArea text = new RSyntaxTextArea();
					text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
					text.setFont(monospaced);

					RTextScrollPane scroll = new RTextScrollPane(text);

					panel.add(scroll, BorderLayout.CENTER);
					panel.setBorder(BorderFactory.createEmptyBorder());

					tabs.add(panel, "Untitled", 0);

					numTabs++;

					SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
						@Override
						public void run() {
							tabs.setSelectedIndex(numTabs - 2);
						}
					});
				}
			}
		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tabs.getSelectedIndex();
				tabs.remove(index);
				numTabs--;

				SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
					@Override
					public void run() {
						tabs.setSelectedIndex(index - 1);
					}
				});
			}
		});

		save.addActionListener(new ActionListener() {
			// My save button really just acts as a save as button,
			// and overwrites the old file everytime
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
					saveFile(fileChooser.getSelectedFile().getAbsolutePath());
			}
		});

		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveOld(); // Just in case the user forgot to save
				System.exit(0); // Close program
			}
		});

		toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
					@Override // I underestimated the use of @Override until now
					public void run() {
						RSyntaxTextArea text = getText(tabs.getSelectedIndex());
						if (highlight) { // If highlighting is on, turn it off
							text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
							highlight = !highlight;
						} else { // Otherwise turn it on
							text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
							highlight = !highlight;
						}
					}
				});
			}
		});

		// Add all the file menu items to the file menu
		file.add(openButton);
		file.addSeparator();
		file.add(newButton);
		file.add(closeButton);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(quit);

		// Add all the edit menu items to the edit menu
		edit.add(toggle);

		// Icons are fun
		openButton.setIcon(new ImageIcon("images/open.gif"));
		newButton.setIcon(new ImageIcon("images/new.gif"));
		closeButton.setIcon(new ImageIcon("images/close.gif"));
		save.setIcon(new ImageIcon("images/save.gif"));
		quit.setIcon(new ImageIcon("images/quit.gif"));

		toggle.setIcon(new ImageIcon("images/toggle.gif"));

		// Add my menu(s) to the menu bar
		menuBar.add(file);
		menuBar.add(edit);

		frame.setJMenuBar(menuBar);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tabs, BorderLayout.CENTER);

		frame.pack();
		frame.setSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private void addTab() {
		int index = numTabs - 2;
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		RSyntaxTextArea text = new RSyntaxTextArea();
		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		text.setFont(monospaced);

		RTextScrollPane scroll = new RTextScrollPane(text);

		panel.add(scroll, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder());

		tabs.add(panel, "Untitled", index);

		numTabs++;
	}

	private void addNewTab() {
		int index = numTabs - 1;
		if (tabs.getSelectedIndex() == index) {

			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			RSyntaxTextArea text = new RSyntaxTextArea();
			text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
			text.setFont(monospaced);

			RTextScrollPane scroll = new RTextScrollPane(text);

			panel.add(scroll, BorderLayout.CENTER);
			panel.setBorder(BorderFactory.createEmptyBorder());

			tabs.add(panel, "Untitled", index);
			tabs.setMnemonicAt(index, index);

			SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
				@Override
				public void run() {
					tabs.setSelectedIndex(numTabs - 2);
				}
			});
			numTabs++;
		}
	}

	private void readFile(String fileName) {
		try {
			int index = tabs.getSelectedIndex();

			FileReader r = new FileReader(fileName); // Create a FileReader

			RSyntaxTextArea text = new RSyntaxTextArea(); // New TextArea

			text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Set Font/Syntax
			text.setFont(monospaced);

			text.read(r, null); // Read the fileName into the reader object
			r.close(); // Close the FileReader

			RTextScrollPane scroll = new RTextScrollPane(text); // Add TextArea to ScrollPane

			JPanel panel = new JPanel(); // Set up the Panel to be added to the TabbedPane
			panel.setLayout(new BorderLayout());

			panel.add(scroll, BorderLayout.CENTER); // This allows the ScrollPanel/TextArea to size with the Panel
			panel.setBorder(BorderFactory.createEmptyBorder());

			tabs.add(panel, fileName, index); // Add the Panel to the TabbedPanel
			tabs.setMnemonicAt(index, index); // Set up keyboard shortcut for any new tab

			tabs.remove(index + 1);
			tabs.remove(index + 1);

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					tabs.setSelectedIndex(index);
				}
			});
			numTabs--;

		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist, yell at the user
			JOptionPane.showMessageDialog(tabs, "Editor can't find the file called " + fileName);
		}
	}

	private void saveFile(String fileName) {
		try {
			int index = tabs.getSelectedIndex();


			RSyntaxTextArea text = getText(tabs.getSelectedIndex());

			String save = text.getText();
			FileUtils.writeStringToFile(new File(fileName), save);    // However, commons-io is totally awesome

			tabs.setTitleAt(index, fileName);
		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist/user has no privilege, yell at the user
			JOptionPane.showMessageDialog(tabs, "Editor can't write to the file called " + fileName + " either you don't have permission, or something else went wrong, like a velociraptor chewing on your motherboard.");
			// Tempted to use, "Check your privilege."
		}
	}

	private void saveOld() {
		if (JOptionPane.showConfirmDialog(tabs, "Would you like to save your work?", "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				saveFile(fileChooser.getSelectedFile().getAbsolutePath()); // If the user quits, make sure they have saved all work
			}
		}
	}

	private RSyntaxTextArea getText(int index) {
		Container panel = (Container)tabs.getComponentAt(index);    // This container junk along with
		Container scroll = (Container)panel.getComponents()[0];     // awt creating viewports for things inside
		Container port = (Container)(scroll.getComponents()[0]);    // of scrollpanes took so long to figure out
																	// it is seriously not funny
																	// I had to keep incorrectly casting things
																	// so the error messages would tell me these things'
																	// "True Identity", awful experience
		JViewport realPort = (JViewport)port;

		RSyntaxTextArea text = (RSyntaxTextArea)realPort.getView();

		return text;
	}

	public class MiddleClickListener extends MouseAdapter { // Listener for the closing tab clicking action
		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isMiddleMouseButton(e)) {
				int index = tabs.getSelectedIndex();
				tabs.remove(tabs.indexAtLocation(e.getX(), e.getY()));
				numTabs--;

				SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
					@Override
					public void run() {
						if (index > 0)
							tabs.setSelectedIndex(index - 1);   // This mess of if statements fixes the problem where having two tabs
																//open and closing the first one would make no tab be selected
						else if (numTabs > 1)
							tabs.setSelectedIndex(index);
						else
							tabs.setSelectedIndex(index - 1);
					}
				});
			}
		}
	}
}