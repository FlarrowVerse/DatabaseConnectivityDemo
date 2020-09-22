package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btnLogin;
    private JButton btnRegister;
    private StudentApp ptr = this;

    /**
     * Creating the frame
     */
    public StudentApp() {
        // close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // size
        setSize(250, 200);

        // set frame to center of screen
        setLocationRelativeTo(null);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(60, 20, 100, 50);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginApp(ptr);
                setVisible(false);
            }
        });
        this.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(60, 90, 100, 50);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterApp(ptr);
                setVisible(false);
            }
        });
        this.add(btnRegister);

        this.setLayout(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    StudentApp app = new StudentApp();
                    app.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }

}
