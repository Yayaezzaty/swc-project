import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {
    JButton startButton;

    public WelcomePage() {
        // Create a title for the restaurant
        setTitle("WELCOME TO PURNAMA PALACE DINE");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create image icon logo
        ImageIcon logo = new ImageIcon("C:/Users/aijzk/OneDrive/UPTM/Semester 2/Object-Oriented Programming/JAVA LEARNING/sup bruh/Purnama Logo.png");
        JLabel logoLabel = new JLabel(logo);

        // Create a Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Add logo to the panel
        panel.add(logoLabel, BorderLayout.CENTER);

        // Create Start Button
        startButton = new JButton("START");

        // Register to a listener
        startButton.addActionListener(this);

        panel.add(startButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    // Method overriding
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            dispose();
            new BookingPage();
        }
    }

    public static void main(String[] args) {
        WelcomePage wp = new WelcomePage();
    }
}
