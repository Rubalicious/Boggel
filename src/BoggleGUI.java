// GUI components and interfaces you will need
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * An event driven graphical user interface for the Boggle game using the design
 * of BoggleTray and Boggle classes during Rick Mercer's CSc classes at the UofA
 */
@SuppressWarnings("serial")
public class BoggleGUI extends JFrame {

  public static void main(String[] args) {
    // This main method allows us to can run this class as a Java Application
    BoggleGUI theView = new BoggleGUI();
    theView.setVisible(true);
  }

  // Need the well test model in several methods of this GUI
  private Boggle game;

  // GUI components you will need
  private JTextArea diceTrayArea;
  private JButton newGameButton = new JButton("New Game"); // will be a warning
  private JButton endButton = new JButton("End game"); // will be a warning
  private JTextArea userInputArea = new JTextArea(10, 25); // will be a warning
  private JLabel label;

  public BoggleGUI() {
    setUpModel(); // given below
    layoutWindow(); // started below
    //setupListeners(); // will be a compile time error until you add the helper method
    //startNewGame(); // will be a compile time error until you add the helper method
  }

  private void setUpModel() {
    game = new Boggle();
  }

  // Add five GUI components to this JFrame
  private void layoutWindow() {
    // Set up the JFrame
    this.setSize(500, 270);
    this.setResizable(false);
    setLocation(400, 250);
    setTitle("Boggle");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // With null layout, you must set the size and location of every component.
    setLayout(null);

    // Layout the dice tray area as a JTextArea
    diceTrayArea = new JTextArea();
    diceTrayArea.setEditable(false);
    diceTrayArea.setBackground(Color.cyan);
    diceTrayArea.setFont(new Font("Courier", Font.BOLD, 24));

    // Every GUI component must receive a setSize and setLocation 
    // message and then be added to the this JFrame 
    diceTrayArea.setSize(210, 220);
    diceTrayArea.setLocation(10, 10);
    add(diceTrayArea);

    // Declare and setSize and setLocation of a JLabel for "Enter your words below"
    label = new JLabel("Enter your words below");
    label.setSize(150, 20);
    label.setLocation(240, 20);
    this.add(label);
    
    // setSize and setLocation of the user input area. Also set line wrap true
    userInputArea.setSize(240, 150);
    userInputArea.setLocation(240, 50);
    userInputArea.setEditable(true);
    userInputArea.setWrapStyleWord(true);
    userInputArea.setLineWrap(true);
    add(userInputArea);
    
    // setSize and setLocation of the newGameButton
    newGameButton.setSize(110, 20);
    newGameButton.setLocation(240, 210);
    add(newGameButton);
    
    // setSize and setLocation of the endButton
    endButton.setSize(110, 20);
    endButton.setLocation(370, 210);
    add(endButton);
    
    // If you haven't already done so, add all graphical components to this JFrame
  }
}
