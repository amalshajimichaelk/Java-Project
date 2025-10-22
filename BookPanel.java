package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dao.BookDAO;
import models.Book;

public class BookPanel extends JPanel {
    private JTextField txtTitle, txtAuthor, txtGenre, txtPrice;
    private JButton btnAdd;
    private JTable table;
    private BookDAO bookDAO = new BookDAO();

    public BookPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2));
        form.add(new JLabel("Title:"));
        txtTitle = new JTextField();
        form.add(txtTitle);
        form.add(new JLabel("Author:"));
        txtAuthor = new JTextField();
        form.add(txtAuthor);
        form.add(new JLabel("Genre:"));
        txtGenre = new JTextField();
        form.add(txtGenre);
        form.add(new JLabel("Price:"));
        txtPrice = new JTextField();
        form.add(txtPrice);

        btnAdd = new JButton("Add Book");
        form.add(btnAdd);

        add(form, BorderLayout.NORTH);

        btnAdd.addActionListener(e -> {
            Book b = new Book();
            b.setTitle(txtTitle.getText());
            b.setAuthor(txtAuthor.getText());
            b.setGenre(txtGenre.getText());
            b.setPrice(Double.parseDouble(txtPrice.getText()));
            if (bookDAO.addBook(b)) {
                JOptionPane.showMessageDialog(this, "Book added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add book!");
            }
        });
    }
}
