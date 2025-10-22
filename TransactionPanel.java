package ui;
import javax.swing.*;
import java.awt.*;
import dao.TransactionDAO;
import models.Transaction;

public class TransactionPanel extends JPanel {
    private JTextField txtCustomerId, txtBookId, txtQty, txtAmount, txtPayment, txtStatus;
    private JButton btnAdd;
    private TransactionDAO dao = new TransactionDAO();

    public TransactionPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(7, 2, 5, 5));
        form.add(new JLabel("Customer ID:"));
        txtCustomerId = new JTextField();
        form.add(txtCustomerId);
        form.add(new JLabel("Book ID:"));
        txtBookId = new JTextField();
        form.add(txtBookId);
        form.add(new JLabel("Quantity:"));
        txtQty = new JTextField();
        form.add(txtQty);
        form.add(new JLabel("Total Amount:"));
        txtAmount = new JTextField();
        form.add(txtAmount);
        form.add(new JLabel("Payment Mode:"));
        txtPayment = new JTextField();
        form.add(txtPayment);
        form.add(new JLabel("Status:"));
        txtStatus = new JTextField("Completed");
        form.add(txtStatus);

        btnAdd = new JButton("Record Transaction");
        form.add(btnAdd);

        add(form, BorderLayout.NORTH);

        btnAdd.addActionListener(e -> {
            Transaction t = new Transaction();
            t.setCustomerId(Integer.parseInt(txtCustomerId.getText()));
            t.setBookId(Integer.parseInt(txtBookId.getText()));
            t.setQuantity(Integer.parseInt(txtQty.getText()));
            t.setTotalAmount(Double.parseDouble(txtAmount.getText()));
            t.setPaymentMode(txtPayment.getText());
            t.setStatus(txtStatus.getText());
            if (dao.addTransaction(t))
                JOptionPane.showMessageDialog(this, "Transaction recorded successfully!");
            else
                JOptionPane.showMessageDialog(this, "Failed to record transaction!");
        });
    }
}
