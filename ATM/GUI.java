import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI {
  private JFrame frame;
  private CardLayout layout = new CardLayout(0, 0);
  final String MAIN_VIEW_ID = "MAIN VIEW";
  final String LOGIN_VIEW_ID = "LOGIN VIEW";

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GUI window = new GUI();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GUI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(layout);

    JPanel loginJP = new JPanel();
    frame.getContentPane().add(loginJP, LOGIN_VIEW_ID);
    loginJP.setLayout(null);

    JButton buttonNewButton = new JButton("LOGIN");
    buttonNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        layout.show(frame.getContentPane(), MAIN_VIEW_ID);
      }
    });

    buttonNewButton.setBounds(140, 100, 148, 62);
    loginJP.add(buttonNewButton);

    JPanel mainJP = new JPanel();
    frame.getContentPane().add(mainJP, MAIN_VIEW_ID);
    mainJP.setLayout(null);

    JLabel labelNewLabel = new JLabel("WELCOME!");
    labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    labelNewLabel.setBounds(144, 112, 119, 51);
    mainJP.add(labelNewLabel);
  }
}