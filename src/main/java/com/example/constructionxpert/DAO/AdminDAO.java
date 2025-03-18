package com.example.constructionxpert.DAO;


import com.example.constructionxpert.Models.Admin;

import java.sql.*;

public class AdminDAO {
    public Admin login(String email, String password) {
        Admin admin = null;
        String sql = "SELECT * FROM Admin WHERE email = ? AND password = ?";

        DatabaseMetaData ConnectionDb = null;
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}