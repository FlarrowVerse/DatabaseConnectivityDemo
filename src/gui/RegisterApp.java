package gui;

import database.ModifyDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import database.ModifyDatabase;

public class RegisterApp extends JFrame {

    private static final long serialVersionUID = 2L;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField rePassword;
    private ModifyDatabase db;

    public RegisterApp(StudentApp app) {
        // close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // size
        setSize(300, 300);
        // set frame to center of screen
        setLocationRelativeTo(null);

        JLabel lblPanel = new JLabel("REGISTER");
        lblPanel.setBounds(100, 15, 100, 10);
        this.add(lblPanel);

        JPanel panelForm = new JPanel();
        panelForm.setBounds(30, 30, 250, 180);
        panelForm.setLayout(new GridLayout(6, 2, 5, 5));
        this.add(panelForm);

        panelForm.add(new JLabel("First Name:"));
        firstName = new JTextField();
        panelForm.add(firstName);

        panelForm.add(new JLabel("Last Name:"));
        lastName = new JTextField();
        panelForm.add(lastName);

        panelForm.add(new JLabel("Username:"));
        username = new JTextField();
        panelForm.add(username);

        panelForm.add(new JLabel("Password:"));
        password = new JPasswordField();
        panelForm.add(password);

        panelForm.add(new JLabel("Confirm Password:"));
        rePassword = new JPasswordField();
        panelForm.add(rePassword);

        panelForm.add(new JLabel()); // to skip a cell

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readForm();
                db.closeConnection();
                app.setVisible(true);
                dispose();
            }
        });
        panelForm.add(btnRegister);

        this.setLayout(null);
        this.setVisible(true);

        db = new ModifyDatabase();
    }

    public void readForm() {
        String fName = firstName.getText();
        String lName = lastName.getText();
        String uName = username.getText();
        String pass = new String(password.getPassword());
        String repass = new String(rePassword.getPassword());

        if (!pass.equals(repass)) {
            JOptionPane.showMessageDialog(new JFrame(), "Passwords Do Not Match!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!db.add(fName, lName, uName, pass)) {
            JOptionPane.showMessageDialog(new JFrame(), "Could not register!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Successfully registered new Student!", "REGISTERED", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
