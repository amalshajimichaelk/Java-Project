package dao;
import java.sql.*;
import java.util.*;
import models.Supplier;
import db.DBConnection;

public class SupplierDAO {
    public boolean addSupplier(Supplier s) {
        String sql = "INSERT INTO suppliers (name, email, contactNumber, location) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getContactNumber());
            ps.setString(4, s.getLocation());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<Supplier> getAllSuppliers() {
        List<Supplier> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM suppliers")) {
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplierId(rs.getInt("supplier_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setContactNumber(rs.getString("contactNumber"));
                s.setLocation(rs.getString("location"));
                list.add(s);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
