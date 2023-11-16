import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Oopcat extends JFrame implements ActionListener {
    JLabel titleLabel, userIDLabel, fullNameLabel, genderLabel, addressLabel, contactNumberLabel;
    JTextField userIDTextField, fullNameTextField, addressTextField, contactNumberTextField;
    JButton registerButton, exitButton;
    JRadioButton maleRadioButton, femaleRadioButton;
    ButtonGroup genderButtonGroup;
    JPanel panel;
    DefaultTableModel model;
    JTable table;

    private static final String FILE_PATH = "user_data.txt";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Oopcat().setVisible(true);
        });
    }

    Oopcat() {
        setSize(700, 360);
        setLayout(null);

        titleLabel = new JLabel("User Registration Form");
        titleLabel.setBounds(60, 7, 200, 30);

        userIDLabel = new JLabel("User ID");
        userIDLabel.setBounds(30, 50, 60, 30);

        fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setBounds(30, 85, 60, 30);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(30, 120, 60, 30);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(30, 155, 60, 30);

        contactNumberLabel = new JLabel("Contact Number");
        contactNumberLabel.setBounds(30, 190, 100, 30);

        userIDTextField = new JTextField();
        userIDTextField.setBounds(95, 50, 100, 30);
        userIDTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        fullNameTextField = new JTextField();
        fullNameTextField.setBounds(95, 85, 100, 30);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(95, 120, 60, 30);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(155, 120, 80, 30);

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        addressTextField = new JTextField();
        addressTextField.setBounds(95, 155, 100, 30);

        contactNumberTextField = new JTextField();
        contactNumberTextField.setBounds(135, 190, 100, 30);

        registerButton = new JButton("Register");
        registerButton.setBounds(30, 230, 100, 30);
        registerButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(135, 230, 100, 30);
        exitButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBounds(250, 50, 400, 200);
        panel.setBackground(Color.white);

        String[] columns = {"ID", "Name", "Gender", "Address", "Contact Number"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(scrollPane);

        add(titleLabel);
        add(userIDLabel);
        add(fullNameLabel);
        add(genderLabel);
        add(addressLabel);
        add(contactNumberLabel);
        add(userIDTextField);
        add(fullNameTextField);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(addressTextField);
        add(contactNumberTextField);
        add(registerButton);
        add(exitButton);
        add(panel);

        setTitle("User Registration Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String id = userIDTextField.getText();
            String name = fullNameTextField.getText();
            String gender = "";
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            }
            String address = addressTextField.getText();
            String contact = contactNumberTextField.getText();

            model.addRow(new Object[]{id, name, gender, address, contact});

            // You can save the data to a file or perform any other necessary actions here
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
