package ui;
import javax.swing.*;
import java.awt.*;
import dao.SupplierDAO;
import models.Supplier;

public class SupplierPanel extends JPanel {
    private JTextField txtName, txtEmail, txtContact, txtLocation;
    private JButton btnAdd;
    private SupplierDAO dao = new SupplierDAO();

    public SupplierPanel() {
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
        form.add(new JLabel("Location:"));
        txtLocation = new JTextField();
        form.add(txtLocation);
        btnAdd = new JButton("Add Supplier");
        form.add(btnAdd);

        add(form, BorderLayout.NORTH);

        btnAdd.addActionListener(e -> {
            Supplier s = new Supplier();
            s.setName(txtName.getText());
            s.setEmail(txtEmail.getText());
            s.setContactNumber(txtContact.getText());
            s.setLocation(txtLocation.getText());
            if (dao.addSupplier(s))
                JOptionPane.showMessageDialog(this, "Supplier added successfully!");
            else
                JOptionPane.showMessageDialog(this, "Failed to add supplier!");
        });
    }
}
