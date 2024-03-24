package fjs.cs.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnection {
	private static final String DB_URL = "jdbc:sqlserver://DESKTOP-DF7MO3M\\CUSTOMERSYSTEM:1433;databaseName=CustomerSystem";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1111";
    
    private Connection connection;

    public SQLServerConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from SQL Server");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean authentication(String username, String password) {
    	PreparedStatement statement = null;
        ResultSet resultSet = null;
    	try {
    		connect();
    		String query = "SELECT * FROM mstuser WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            return resultSet.next(); // Trả về true nếu tìm thấy người dùng
		} catch (Exception e) {
			System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
		} 
    	finally {
    		try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
		}
    	return false;
    }

}
