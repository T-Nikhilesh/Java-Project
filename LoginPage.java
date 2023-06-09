import javax.swing.*;
import java.awt.*;

public class LoginPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        
            LoginPage LoginPage = new LoginPage();
            LoginPage.createAndShowGUI();
    }   

    private void createAndShowGUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Center the window on the screen

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            // Perform authentication
            if (authenticate(username, password)) {
                frame.dispose(); // Close the login window
                showReservationPage(username); // Redirect to the reservation page
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

            // Clear input fields
            usernameField.setText("");
            passwordField.setText("");
        });

        contentPane.add(usernameLabel);
        contentPane.add(usernameField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);
        contentPane.add(new JLabel()); // Empty label for layout alignment
        contentPane.add(loginButton);

        frame.add(contentPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        return username.equals("q") && password.equals("q");
    }

    private void showReservationPage(String username) {
        
            BusReservationSystem busReservationSystem = new BusReservationSystem();
            busReservationSystem.createAndShowGUI();
            busReservationSystem.loadData(); // Load data after displaying the GUI
    }
}
