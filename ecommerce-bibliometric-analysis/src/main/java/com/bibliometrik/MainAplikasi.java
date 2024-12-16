import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

public class MainAplikasi {
    public static void main(String[] args) {
        // Selection
        int choice = showMenu();
        
        switch (choice) {
            case 1:
                inputData();
                break;
            case 2:
                displayData();
                break;
            case 3:
                updateData();
                break;
            case 4:
                deleteData();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
    
    // Swing JOptionPane
    private static int showMenu() {
        String[] options = {"Input Data", "Display Data", "Update Data", "Delete Data", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Pilih opsi:", "Menu Utama",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return choice;
    }
    
    // Input data
    private static void inputData() {
        String name = JOptionPane.showInputDialog("Masukkan nama:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Masukkan umur:"));
        
        // Array
        String[] data = {name, String.valueOf(age)};
        
        // JDBC
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
            stmt.setString(1, data[0]);
            stmt.setInt(2, Integer.parseInt(data[1]));
            stmt.executeUpdate();
            System.out.println("Data berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Display data
    private static void displayData() {
        // ArrayList
        ArrayList<String[]> data = new ArrayList<>();
        
        // JDBC
        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                data.add(new String[]{name, String.valueOf(age)});
            }
            
            // Display data using Swing
            StringBuilder sb = new StringBuilder();
            for (String[] row : data) {
                sb.append("Nama: ").append(row[0]).append(", Umur: ").append(row[1]).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Data Pengguna", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Update data
    private static void updateData() {
        String name = JOptionPane.showInputDialog("Masukkan nama yang akan diupdate:");
        int newAge = Integer.parseInt(JOptionPane.showInputDialog("Masukkan umur baru:"));
        
        // JDBC
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET age = ? WHERE name = ?");
            stmt.setInt(1, newAge);
            stmt.setString(2, name);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Tidak ada data yang diupdate.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Delete data
    private static void deleteData() {
        String name = JOptionPane.showInputDialog("Masukkan nama yang akan dihapus:");
        
        // JDBC
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE name = ?");
            stmt.setString(1, name);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Tidak ada data yang dihapus.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // JDBC connection
    private static Connection getConnection() {
        try {
            // Kode untuk koneksi ke database menggunakan JDBC
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}