package Editor;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

class NewTab implements Runnable {
	private JTabbedPane tabs = new JTabbedPane();
	private ChangeListener listener;
	private int numTabs = 0;
	private JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
	private Font monospaced = new Font("Input Mono", Font.PLAIN, 14);
	private JPanel panel = new JPanel();

	private RSyntaxTextArea text = new RSyntaxTextArea();
	private RTextScrollPane scroll = new RTextScrollPane(text);

	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private	JMenuItem newButton = new JMenuItem("New");
	private JMenuItem openButton = new JMenuItem("Open");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem quit = new JMenuItem("Quit");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new NewTab());
	}

	public void run() {
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				addNewTab();
			}
		};

		panel.setLayout(new BorderLayout());
		panel.add(scroll, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder());
		
		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		text.setFont(monospaced);
		
		tabs.add(panel, "Untitled " + String.valueOf(numTabs), numTabs++);
		tabs.add(new JPanel(), "+", numTabs++);
		tabs.addChangeListener(listener);

		JFrame frame = new JFrame(this.getClass().getName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tabs, BorderLayout.CENTER);

		frame.setJMenuBar(menuBar);

		menuBar.add(file);

		file.setMnemonic(KeyEvent.VK_F);
		openButton.setMnemonic(KeyEvent.VK_O);
		openButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		newButton.setMnemonic(KeyEvent.VK_N);
		newButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		quit.setMnemonic(KeyEvent.VK_Q);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					readFile(fileChooser.getSelectedFile().getAbsolutePath());  // Use the file reader to get the selected file,
																				// and then find it's directory path.
																				// This is then given to the readFile method.
				}
			}
		});

		file.add(newButton);
		file.add(openButton);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(quit);

		newButton.setIcon(new ImageIcon("images/new.gif"));  // Using icons is fun
		openButton.setIcon(new ImageIcon("images/open.gif"));
		save.setIcon(new ImageIcon("images/save.gif"));
		quit.setIcon(new ImageIcon("images/quit.gif"));

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
			
			RTextScrollPane scroll = new RTextScrollPane(text);

			panel.add(scroll, BorderLayout.CENTER);
			panel.setBorder(BorderFactory.createEmptyBorder());

			tabs.add(panel, "Untitled " + String.valueOf(index), index);
			
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
	
	private void readFile(String fileName) {
		try {
			
			FileReader r = new FileReader(fileName); // Create a FileReader
			RSyntaxTextArea text = new RSyntaxTextArea();
			
			text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
			text.setFont(monospaced);
			
			text.read(r, null); // Read the fileName into the reader object
			r.close(); // Close the FileReader
			
			RTextScrollPane scroll = new RTextScrollPane(text);

			int index = tabs.getSelectedIndex();
			tabs.remove(index);

			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			panel.add(scroll, BorderLayout.CENTER);
			panel.setBorder(BorderFactory.createEmptyBorder());

			tabs.add(panel, fileName, index);
			tabs.setMnemonicAt(index, index);
			

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					tabs.setSelectedIndex(index);
				}
			});
		} catch (IOException e) {
			Toolkit.getDefaultToolkit().beep(); // If the file didn't exist, yell at the user
			JOptionPane.showMessageDialog(tabs, "Editor can't find the file called " + fileName);
		}
	}
}
