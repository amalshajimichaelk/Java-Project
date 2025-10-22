package models;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int customerId;
    private int bookId;
    private int quantity;
    private double totalAmount;
    private String paymentMode;
    private Date transactionDate;
    private String status; // e.g., Completed, Cancelled

    public Transaction() {}

    public Transaction(int transactionId, int customerId, int bookId, int quantity, double totalAmount,
                       String paymentMode, Date transactionDate, String status) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.paymentMode = paymentMode;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction [ID=" + transactionId + ", CustomerID=" + customerId +
               ", BookID=" + bookId + ", Quantity=" + quantity + ", Total=" + totalAmount +
               ", PaymentMode=" + paymentMode + ", Date=" + transactionDate + ", Status=" + status + "]";
    }
}
