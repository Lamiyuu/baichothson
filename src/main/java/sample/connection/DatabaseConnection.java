package sample.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private final BasicDataSource dataSource;
    private final String host = "localhost";
    private final String port = "3306";
    private final String database = "quan ly khoan thu";
    private final String username = "root";
    private final String password = "";

    // Phương thức singleton để lấy instance duy nhất
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Constructor private để ngăn tạo mới đối tượng từ bên ngoài
    private DatabaseConnection() {
        // Khởi tạo BasicDataSource với cấu hình kết nối
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // Các thiết lập bổ sung cho BasicDataSource
        dataSource.setMinIdle(5);      // Số lượng kết nối tối thiểu
        dataSource.setMaxIdle(10);     // Số lượng kết nối tối đa khi rảnh
        dataSource.setMaxTotal(20);    // Số lượng kết nối tối đa
        dataSource.setMaxWaitMillis(10000); // Thời gian chờ kết nối
    }

    // Phương thức kết nối đến cơ sở dữ liệu
    public void connectToDatabase() throws SQLException {
        try {
            // Kiểm tra xem dataSource có null không
            if (dataSource == null) {
                throw new SQLException("DataSource chưa được khởi tạo.");
            }
        } catch (SQLException e) {
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu.", e);
        }
    }

    // Phương thức tạo kết nối từ BasicDataSource
    public Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Phương thức đóng tài nguyên
    public void close(AutoCloseable... resources) throws SQLException {
        try {
            for (AutoCloseable resource : resources) {
                if (resource != null) {
                    resource.close();
                }
            }
        } catch (Exception e) {
            throw new SQLException("Error on closing resources", e);
        }
    }
}