package Editor;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;

// These libraries are for the better and stronger versions of JTextArea and JScrollPane
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

// In case I happen to use Commons-IO
//import org.apache.commons.io.*;

// This library is for the theme I use
import com.jtattoo.plaf.hifi.*;

class NewTabEditor implements Runnable { // Trying again, this time with tabs
	// Declare all variables to be used

	// Set up various containers, tabs goes in frame, the panels go in the tabs
	private JFrame frame = new JFrame("MattPad++");
	private JTabbedPane tabs = new JTabbedPane();
	private JPanel panel = new JPanel();
	private JPanel plusPanel = new JPanel();

	// I would declare my RSyntaxTextArea and RTextScrollPane here, but since I have to set the textArea's
	// background before adding it to the scroll pane, I make them in my run() method

	// Set up menus and their items
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenuItem openButton = new JMenuItem("Open");
	private JMenuItem newButton = new JMenuItem("New Tab");
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
	
	// Color as the background
	Color gray = new Color(200,200,200);

	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			props.put("logoString", "");
			HiFiLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); // Found some nice themes online
			SwingUtilities.invokeLater(new NewTabEditor());  // invokeLater(new Runnable()) is nice because it lets me update the gui.
			System.setProperty("awt.useSystemAAFontSettings", "lcd"); // Anti-Alias fonts
			System.setProperty("swing.aatext", "true");
		}
		catch (Exception e) {
			e.printStackTrace(); // If something goes wrong, tell me what and where, it's nice
		}
	}

	public void run() {
		listener = new ChangeListener() {
			// ChangeListener for the adding tabs button
			// This listener has been both really helpful to me and really annoying
			public void stateChanged(ChangeEvent e) {
				addNewTab();
			}
		};

		// Time to make all my declarations actual objects
		
		// TextArea and ScrollPane that contains it
		// These are from the RSyntaxTextArea library
		RSyntaxTextArea text = new RSyntaxTextArea();
		text.setFont(monospaced); // Set font
		text.setBackground(gray); // If I put these object declarations with the rest of them, I can't set the background
							 // before adding the text area to the scroll pane, making my line numbers not have a gray background
		RTextScrollPane scroll = new RTextScrollPane(text); // Add text area to the scroll pane and make the scroll pane in one go
		
		// These three lines are so that changing the window size dynamically resizes everything inside too
		panel.setLayout(new BorderLayout()); // Using layouts => thumbsUp.jpg
		panel.add(scroll, BorderLayout.CENTER); // Add the scrollpane to the panel
		panel.setBorder(BorderFactory.createEmptyBorder()); // Factories are about as annoying as Michael said they would be

		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);	// This method is for the syntax
															// highlighting that comes
															// with RSyntaxTextAreas
		tabs.add(panel, "Untitled", numTabs++); // Add default tab

		tabs.add(plusPanel, "+", numTabs++); // Here I add the add tab button
		tabs.addChangeListener(listener); // Add my listener
		tabs.addMouseListener(new MiddleClickListener());   // This mouse listener is for
															// closing tabs with middle mouse click
		// Set mnemonics/accelerators for keyboard shortcuts, activated with CTRL+KEY
		// These are a lot of fun
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
					readFile(fileChooser.getSelectedFile().getAbsolutePath(), fileChooser.getSelectedFile().getName());
					// Use the file reader to get the selected file,
					// and then find it's full directory path.
					// This is then given to the readFile method.
				}
			}
		});

		newButton.addActionListener(new ActionListener () { // This method is a bit ugly, but long story short, it adds a new tab from scratch
															// I wanted to make a method that adds tabs, but as it turns out, it only got used once
															// since the utility of a super generic tab only goes so far
															// In most cases, every tab I make has something different about it
															// the if (numTabs > 1) else structure is to fix the bug that occurs
															// when the user makes a tab and the "+" is selected, or no tab at all
															// or worse, ruining the functionality of the "+" button entirely
															// I also had trouble with double tab creation
			public void actionPerformed(ActionEvent e) {
				if (numTabs > 1) {
					int index = tabs.getSelectedIndex();
					
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());

					RSyntaxTextArea text = new RSyntaxTextArea();
					text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
					text.setFont(monospaced);
					text.setBackground(gray);

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
					text.setBackground(gray);

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
					saveFile(fileChooser.getSelectedFile().getAbsolutePath(), fileChooser.getSelectedFile().getName());
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
				SwingUtilities.invokeLater(new Runnable() {// Here I update the GUI, thanks invokeLater!
					@Override // I underestimated the use of @Override until now
					public void run() {
						RSyntaxTextArea text = getTextArea(tabs.getSelectedIndex());
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
		openButton.setIcon(new ImageIcon(getClass().getResource("images/open.gif")));
		newButton.setIcon(new ImageIcon(getClass().getResource("images/new.gif")));
		closeButton.setIcon(new ImageIcon(getClass().getResource("images/close.gif")));
		save.setIcon(new ImageIcon(getClass().getResource("images/save.gif")));
		quit.setIcon(new ImageIcon(getClass().getResource("images/quit.gif")));

		toggle.setIcon(new ImageIcon(getClass().getResource("images/toggle.gif")));

		// Add my menu(s) to the menu bar
		menuBar.add(file);
		menuBar.add(edit);

		frame.setJMenuBar(menuBar);

		// Good ol' GUI staples, setting behaviors, etc.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tabs, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void addNewTab() {
		int index = numTabs - 1;
		if (tabs.getSelectedIndex() == index) {

			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			RSyntaxTextArea text = new RSyntaxTextArea();
			text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
			text.setFont(monospaced);
			text.setBackground(gray);

			RTextScrollPane scroll = new RTextScrollPane(text);

			panel.add(scroll, BorderLayout.CENTER);
			panel.setBorder(BorderFactory.createEmptyBorder());

			tabs.add(panel, "Untitled", index);
			tabs.setMnemonicAt(index, index);

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					tabs.setSelectedIndex(numTabs - 2);
				}
			});
			numTabs++;
		}
	}

	private void readFile(String filePath, String fileName) {
		try {
			int index = tabs.getSelectedIndex();

			FileReader r = new FileReader(filePath); // Create a FileReader
			
			// I was considering using commons-IO here too in order to read in files,
			// but strings have maximum sizes and I don't want to deal with that

			RSyntaxTextArea text = new RSyntaxTextArea(); // New TextArea

			text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Set Font/Syntax
			text.setFont(monospaced);
			text.setBackground(gray);

			text.read(r, null); // Read the fileName into the reader object
			r.close(); // Close the FileReader

			RTextScrollPane scroll = new RTextScrollPane(text); // Add TextArea to ScrollPane

			JPanel panel = new JPanel(); // Set up the Panel to be added to the TabbedPane
			panel.setLayout(new BorderLayout());

			panel.add(scroll, BorderLayout.CENTER); // This allows the ScrollPanel/TextArea to size with the Panel
			panel.setBorder(BorderFactory.createEmptyBorder());
			
			if (numTabs < 2) {  // Weird bug where if user tries to open file when only the "+" exists, things break.
								// This avoids those shenanigans, and gives me an excuse to use beep() again.
				Toolkit.getDefaultToolkit().beep(); // If no text tabs exist, yell at the user
				JOptionPane.showMessageDialog(tabs, "You need at least one tab open to open a file");
			}
			else {
				tabs.add(panel, fileName, index+1); // Add the Panel to the TabbedPanel
				numTabs++;
			
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						tabs.setSelectedIndex(index+1);
					}
				});
			}
		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist, yell at the user... beep!
			JOptionPane.showMessageDialog(tabs, "Editor can't find the file called " + fileName);
		}
	}

	private void saveFile(String filePath, String fileName) { // Save is really just a save as, overwriting each time
		FileWriter w = null;
		try {
			w = new FileWriter(filePath);
			RSyntaxTextArea text = getTextArea(tabs.getSelectedIndex());
			text.write(w);
			
			int index = tabs.getSelectedIndex();

			//String save = text.getText();
			//FileUtils.writeStringToFile(new File(fileName), save);
			// Commons-IO is pretty convenient, but relies on the file being saved
			// to be smaller than the maximum size of a String, so I've
			// gone back to FileWriters

			tabs.setTitleAt(index, fileName);
		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist/user has no privilege, yell at the user
			JOptionPane.showMessageDialog(tabs, "Editor can't write to the file called " + fileName + " either you don't have permission, or something else went wrong, like a velociraptor chewing on your motherboard.");
			// Tempted to use, "Check your privilege."
		} finally { // Better form to put the close() statement in a finally statement
			try {
				w.close();
			} catch (Exception ex) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(tabs, "FileWriter failed to close");
			}
		}
	}

	private void saveOld() { // Prompt user to save on quit
		if (JOptionPane.showConfirmDialog(tabs, "Would you like to save your work?", "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				saveFile(fileChooser.getSelectedFile().getAbsolutePath(), fileChooser.getSelectedFile().getName()); // If the user quits, make sure they have saved all work
			}
		}
	}

	private RSyntaxTextArea getTextArea(int index) { // Get the text area at whatever tab
		Container panel = (Container)tabs.getComponentAt(index);    // This container junk along with
		Container scroll = (Container)panel.getComponents()[0];     // AWT creating Viewport s for things inside
		Container port = (Container)(scroll.getComponents()[0]);    // of RTextScrollPane s took so long to figure out
																	// it is seriously not funny
		// Hooray for casting though								// I had to keep incorrectly casting things
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
				tabs.remove(tabs.indexAtLocation(e.getX(), e.getY())); // Get the tab index at the location of the click
				numTabs--;

				SwingUtilities.invokeLater(new Runnable() { // Here I update the GUI
					@Override
					public void run() {
						if (index > 0)
							tabs.setSelectedIndex(index - 1);	// This mess of if statements fixes the problem where having two tabs
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
