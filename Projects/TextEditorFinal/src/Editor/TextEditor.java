package Editor;

//Import everything
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class TextEditor extends JFrame { // Extend JFrame because GUI
	
	// Added because of IED warning
	private static final long serialVersionUID = 1L;
	
	// Create JPanel to put things in, using a BorderLayout
	private JPanel cp = new JPanel(new BorderLayout());

	// Set up text area, not a field, as a field only has one line, only I'm using the RSyntaxTextArea
	// which is part of the neat library I imported above, which gives extra easy to use features
	private RSyntaxTextArea text = new RSyntaxTextArea(30, 75);

	// Set up text document name, for saving purposes
	private String title = "Untitled";

	// Set up a file chooser to open existing files
	// Apparently, the way to get the current working directory in Java is the following line:
	// System.getProperty("user.dir"));
	// So the constructor of JFileChooser can take a file path
	// as the default location to open to, so I'll use that
	private JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

	// Set up the font to use throughout the editor
	// I'm using a monospaced font becuse yes.
	private Font monospaced = new Font("Input Mono Compressed", Font.PLAIN, 12);

	// Set up a scrollbar should it become necessary
	//private JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private RTextScrollPane scroll = new RTextScrollPane(text);
	
	// Set up the menu bar, and its items
	private JMenuBar menuBar = new JMenuBar();

	private	JMenu file = new JMenu("File");

	private	JMenuItem newButton = new JMenuItem("New");
	private JMenuItem openButton = new JMenuItem("Open");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem quit = new JMenuItem("Quit");

	public TextEditor() {
		
		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Since I work with Java, I'll use Java syntax highlighting
	    //text.setCodeFoldingEnabled(true);  // Can't seem to get this to work

		text.setFont(monospaced); // Set the font of the text area
		
		// Add line numbering to the side, for the authentic notepad++ feel
		cp.add(scroll); // Add the scrollbar to the panel

		// Add my menu(s) to the menu bar
		setJMenuBar(menuBar);
		menuBar.add(file);

		// Set mnemonics/accelerators for keyboard shortcuts, activated with alt+KEY
		file.setMnemonic(KeyEvent.VK_F);
		openButton.setMnemonic(KeyEvent.VK_O);
		openButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		newButton.setMnemonic(KeyEvent.VK_N);
		newButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		quit.setMnemonic(KeyEvent.VK_Q);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));

		// Set action listeners
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					readFile(fileChooser.getSelectedFile().getAbsolutePath());  // Use the file reader to get the selected file,
					// and then find it's directory path.
					// This is then given to the readFile method.
				}
			}
		});

		newButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				saveOld(); // If the user wants to make a new document, check to make sure old work is saved if necessary
				text.setText(""); // Clear the textArea
				title = "Untitled"; // Reset the title
				setTitle(title);
			}
		});

		save.addActionListener(new ActionListener() { // My save button really just acts as a save as button,
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

		// Add items to the file menu
		file.add(newButton);
		file.add(openButton);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(quit);

		// Set up the file menu items
		newButton.setIcon(new ImageIcon("images/new.gif"));  // Using icons is fun
		openButton.setIcon(new ImageIcon("images/open.gif"));
		save.setIcon(new ImageIcon("images/save.gif"));
		quit.setIcon(new ImageIcon("images/quit.gif"));

		setTitle(title);
		
		setContentPane(cp);

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Make window close if you close it
		pack();
		setLocationRelativeTo(null);
		setVisible(true); // As opposed to invisible
	}

	private void saveFile(String fileName) {
		try {
			FileWriter w = new FileWriter(fileName); // Create a FileWriter
			text.write(w); // Read the content of the textArea into the file
			w.close(); // Close the FileWriter
			title = fileName; // the fileName given to the method should have been the file name the user wishes to use
			setTitle(title);
		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist, yell at the user
			JOptionPane.showMessageDialog(this, "Editor can't write to the file called " + fileName + " either you don't have permission, or something else went wrong, like a velociraptor chewing on your motherboard.");
		}
	}

	private void saveOld() {
		if (JOptionPane.showConfirmDialog(this, "Would you like to save " + title + " ?", "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			saveFile(title); // If the user quits, make sure they have saved all work

	}

	private void readFile(String fileName) {
		try {
			FileReader r = new FileReader(fileName); // Create a FileReader
			text.read(r, null); // Read the fileName into the reader object
			r.close(); // Close the FileReader
			title = fileName; // Set the title to the file name that was just loaded
			setTitle(title);
		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist, yell at the user
			JOptionPane.showMessageDialog(this, "Editor can't find the file called " + fileName);
		}
	}

	public static void main(String[] args) {
		new TextEditor(); // Main program to actually make and run the editor
		System.setProperty("awt.useSystemAAFontSettings", "on"); // Anti-Alias fonts
		System.setProperty("swing.aatext", "true");
	}
}
