package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dao.CustomerDAO;
import models.Customer;

public class CustomerPanel extends JPanel {
    private JTextField txtName, txtEmail, txtContact, txtAddress;
    private JButton btnAdd;
    private CustomerDAO dao = new CustomerDAO();

    public CustomerPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.add(new JLabel("Name:"));
        txtName = new JTextField();
        form.add(txtName);
        form.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        form.add(txtEmail);
        form.add(new JLabel("Contact Number:"));
        txtContact = new JTextField();
        form.add(txtContact);
        form.add(new JLabel("Address:"));
        txtAddress = new JTextField();
        form.add(txtAddress);
        btnAdd = new JButton("Add Customer");
        form.add(btnAdd);

        add(form, BorderLayout.NORTH);

        btnAdd.addActionListener(e -> {
            Customer c = new Customer();
            c.setName(txtName.getText());
            c.setEmail(txtEmail.getText());
            c.setContactNumber(txtContact.getText());
            c.setAddress(txtAddress.getText());
            if (dao.addCustomer(c))
                JOptionPane.showMessageDialog(this, "Customer added successfully!");
            else
                JOptionPane.showMessageDialog(this, "Failed to add customer!");
        });
    }
}
