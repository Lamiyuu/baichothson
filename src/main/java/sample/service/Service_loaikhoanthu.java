package sample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; // Import đúng List
import sample.connection.DatabaseConnection;
import sample.model.Model_loaikhoanthu;

/**
 *
 * @author Admin
 */
public class Service_loaikhoanthu {

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Model_loaikhoanthu> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM `loại khoản thu`");
            r = p.executeQuery();
            List<Model_loaikhoanthu> list = new ArrayList<>(); // Sử dụng Model_loaikhoanthu
            while (r.next()) {
                int tenkhoanthu_id = r.getInt("tenkhoanthu_id");
                String tenkhoanthu_name = r.getString("tenkhoanthu_name");
                // Giả sử Model_loaikhoanthu có constructor nhận vào (int, String)
                list.add(new Model_loaikhoanthu(tenkhoanthu_id, tenkhoanthu_name)); // Khởi tạo đúng đối tượng
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con); // Đảm bảo các tài nguyên được đóng
        }
    }
}
