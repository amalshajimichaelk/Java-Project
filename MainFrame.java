package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Book Stall Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel(new GridLayout(1, 4));
        JButton bookBtn = new JButton("Books");
        JButton custBtn = new JButton("Customers");
        JButton suppBtn = new JButton("Suppliers");
        JButton tranBtn = new JButton("Transactions");

        menuPanel.add(bookBtn);
        menuPanel.add(custBtn);
        menuPanel.add(suppBtn);
        menuPanel.add(tranBtn);
        add(menuPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        add(contentPanel, BorderLayout.CENTER);

        bookBtn.addActionListener(e -> {
            contentPanel.removeAll();
            contentPanel.add(new BookPanel());
            contentPanel.revalidate();
            contentPanel.repaint();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
