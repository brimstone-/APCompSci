// Import everything
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextEditor extends JFrame { // Extend JFrame because GUI

	// Set up text area, not a field, as a field only has one line
	private JTextArea text = new JTextArea(30, 150);

	// Set up text document name, for saving purposes
	private String title = "Untitled";

	// Set up a file chooser to open existing files
	// Apparently, the way to get the current working directory in Java is the following line:
	//     System.getProperty("user.dir"));
	// So the constructor of JFileChooser can take a file path
	// as the default location to open to, so I'll use that
	private JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

	// Set up the font to use throughout the editor
	// I'm using a monospaced font becuse yes.
	private Font monospaced = new Font("Monospaced", Font.PLAIN, 12);

	// Set up a scrollbar should it become necessary
	private JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	// Set up the menu bar, and its items
	private JMenuBar menuBar = new JMenuBar();

	private	JMenu file = new JMenu("File");
	private	JMenu edit = new JMenu("Edit");

	private	JMenuItem newButton = new JMenuItem("New");
	private JMenuItem openButton = new JMenuItem("Open");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem saveAs = new JMenuItem("Save As");
	private JMenuItem quit = new JMenuItem("Quit");

	private JMenuItem cut = new JMenuItem("Cut");
	private JMenuItem copy = new JMenuItem("Copy");
	private JMenuItem paste = new JMenuItem("Paste");
    
	public TextEditor() {

		text.setFont(monospaced); // Set the font of the text area
		add(scroll); // Add the scrollbar to the text area

		// Add my two menus to the menu bar
		setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(edit);

		// Set mnemonics/accelerators for keyboard shortcuts, activated with a KEY or alt+KEY
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);

		openButton.setMnemonic(KeyEvent.VK_O);
		openButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		newButton.setMnemonic(KeyEvent.VK_N);
		newButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		quit.setMnemonic(KeyEvent.VK_Q);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));

		cut.setMnemonic(KeyEvent.VK_X);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		copy.setMnemonic(KeyEvent.VK_C);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		paste.setMnemonic(KeyEvent.VK_V);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.ALT_MASK));

		// Set action listeners
		

		// Add items to the file menu
		file.add(newButton);  // 0
		file.add(openButton); // 1
		file.addSeparator();
		file.add(save); // 2
		file.add(saveAs); // 3
		file.addSeparator();
		file.add(quit); // 4

		// Set up the file menu items
		newButton.setIcon(new ImageIcon("images/new.gif"));
		openButton.setIcon(new ImageIcon("images/open.gif"));
		save.setIcon(new ImageIcon("images/save.gif"));
		saveAs.setIcon(new ImageIcon("images/save.gif"));
		quit.setIcon(new ImageIcon("images/quit.gif"));

		// Add items to the edit menu
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);

		// Set up the edit menu items
		edit.getItem(0).setIcon(new ImageIcon("images/cut.gif"));
		edit.getItem(1).setIcon(new ImageIcon("images/copy.gif"));
		edit.getItem(2).setIcon(new ImageIcon("images/paste.gif"));

		//text.addKeyListener(key);
		setTitle(title);

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Make window close if you close it
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextEditor();
	}
}