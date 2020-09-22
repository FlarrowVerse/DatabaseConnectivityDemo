package gui;

import database.ModifyDatabase;
import ds.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp extends JFrame {

    private static final long serialVersionUID = 2L;
    private JTextField username;
    private JPasswordField password;
    private ModifyDatabase db;

    public LoginApp(StudentApp app) {
        // close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // size
        setSize(250, 200);
        // set frame to center of screen
        setLocationRelativeTo(null);

        this.setLayout(null);

        JLabel lblPanel = new JLabel("LOGIN");
        lblPanel.setBounds(100, 10, 50, 10);
        this.add(lblPanel);

        JPanel panelLogin = new JPanel();
        panelLogin.setBounds(30, 30, 150, 90);
        panelLogin.setLayout(new GridLayout(3, 1, 5, 5));
        this.add(panelLogin);

        JLabel lblUsername = new JLabel("Username:");
        panelLogin.add(lblUsername);

        username = new JTextField();
        panelLogin.add(username);

        JLabel lblPassword = new JLabel("Password:");
        panelLogin.add(lblPassword);

        password = new JPasswordField();
        panelLogin.add(password);

        panelLogin.add(new Label()); // just to skip a cell

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readForm();
                db.closeConnection();
                app.setVisible(true);
                dispose();
            }
        });
        panelLogin.add(btnLogin);

        this.setVisible(true);
        db = new ModifyDatabase();
    }

    public void readForm() {
        int id = Integer.parseInt(this.username.getText());
        String password = new String(this.password.getPassword());

        Student searched = db.find(id);
        if (searched == null) {
            JOptionPane.showMessageDialog(new JFrame(), "User not found!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!searched.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(new JFrame(), "Wrong Password!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), searched.toString(), "Student Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
