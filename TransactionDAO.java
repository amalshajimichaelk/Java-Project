package dao;
import java.sql.*;
import java.util.*;
import models.Transaction;
import db.DBConnection;

public class TransactionDAO {
    public boolean addTransaction(Transaction t) {
        String sql = "INSERT INTO transactions (customer_id, book_id, quantity, totalAmount, paymentMode, dateOfTransaction, status) VALUES (?,?,?,?,?,NOW(),?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, t.getCustomerId());
            ps.setInt(2, t.getBookId());
            ps.setInt(3, t.getQuantity());
            ps.setDouble(4, t.getTotalAmount());
            ps.setString(5, t.getPaymentMode());
            ps.setString(6, t.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM transactions")) {
            while (rs.next()) {
                Transaction t = new Transaction();
                t.setTransactionId(rs.getInt("transaction_id"));
                t.setCustomerId(rs.getInt("customer_id"));
                t.setBookId(rs.getInt("book_id"));
                t.setQuantity(rs.getInt("quantity"));
                t.setTotalAmount(rs.getDouble("totalAmount"));
                t.setPaymentMode(rs.getString("paymentMode"));
                t.setStatus(rs.getString("status"));
                list.add(t);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
