package sample.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.connection.DatabaseConnection;
import sample.model.Model_khoanthu;
import sample.model.Model_loaikhoanthu;

public class Service_khoanthu {
    public List<Model_khoanthu> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM `khoan thu` JOIN `loại khoản thu` USING (tenkhoanthu_id) ORDER BY tenkhoanthu_name");

            r = p.executeQuery();
            List<Model_khoanthu> list = new ArrayList<>();
            while (r.next()) {
                int makhoanthu = r.getInt("makhoanthu");
                int tenkhoanthu_id = r.getInt("tenkhoanthu_id");
                String tenkhoanthu_name = r.getString("tenkhoanthu_name");
                int sotienthu = r.getInt("sotienthu");
                Date ngaybatdauthu = r.getDate("ngaybatdauthu");
                Date ngayketthuc = r.getDate("ngayketthuc");
                String mota = r.getString("mota");

                list.add(new Model_khoanthu(makhoanthu, new Model_loaikhoanthu(tenkhoanthu_id, tenkhoanthu_name), ngaybatdauthu, sotienthu, ngayketthuc, mota));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public List<Model_khoanthu> search(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM `khoan thu` JOIN `loại khoản thu` USING (tenkhoanthu_id) WHERE (makhoanthu LIKE ? OR tenkhoanthu_name LIKE ? OR mota LIKE ?) ORDER BY tenkhoanthu_name");
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");

            r = p.executeQuery();
            List<Model_khoanthu> list = new ArrayList<>();
            while (r.next()) {
                int makhoanthu = r.getInt("makhoanthu");
                int tenkhoanthu_id = r.getInt("tenkhoanthu_id");
                String tenkhoanthu_name = r.getString("tenkhoanthu_name");
                int sotienthu = r.getInt("sotienthu");
                Date ngaybatdauthu = r.getDate("ngaybatdauthu");
                Date ngayketthuc = r.getDate("ngayketthuc");
                String mota = r.getString("mota");

                list.add(new Model_khoanthu(makhoanthu, new Model_loaikhoanthu(tenkhoanthu_id, tenkhoanthu_name), ngaybatdauthu, sotienthu, ngayketthuc, mota));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public Service_loaikhoanthu service_loaikhoanthu;
    // Phương thức để kiểm tra mã khoản thu có trùng lặp không
    public boolean isMakhoanthuDuplicate(int makhoanthu) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM `khoan thu` WHERE makhoanthu = ?";
        
        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, makhoanthu);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  // Nếu có bản ghi trùng thì trả về true
            }
        }
        return false; // Nếu không có bản ghi trùng thì trả về false
    }
    public void create(Model_khoanthu data) throws SQLException {
        // Kiểm tra nếu makhoanthu là 0, không thực hiện chèn
        if (data.getMakhoanthu() == 0) {
            throw new SQLException("Mã khoản thu không thể là 0.");
        }

        // Kiểm tra trùng lặp mã khoản thu trong cơ sở dữ liệu
        if (isMakhoanthuDuplicate(data.getMakhoanthu())) {
            throw new SQLException("Mã khoản thu đã tồn tại.");
        }

        // Lệnh INSERT vào bảng `khoan thu`
        String insertQuery = "INSERT INTO `khoan thu` (makhoanthu, tenkhoanthu_id, sotienthu, ngaybatdauthu, ngayketthuc, mota) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {

            // Gán các giá trị cho câu lệnh `INSERT`
            insertStmt.setInt(1, data.getMakhoanthu());  // Mã khoản thu
            insertStmt.setInt(2, data.getTenkhoanthu().getTenKhoanThuId());
            insertStmt.setInt(3, data.getSotienthu());
            insertStmt.setDate(4, data.getNgaybatdauthu());
            insertStmt.setDate(5, data.getNgayketthuc());
            insertStmt.setString(6, data.getMota());

            // Thực thi lệnh INSERT
            insertStmt.executeUpdate();
        }
    }

    public void edit(Model_khoanthu data) throws SQLException {
        // Kiểm tra giá trị makhoanthu nhập vào trước khi sửa
        if (data.getMakhoanthu() <= 0) {
            throw new SQLException("Mã khoản thu không thể là 0 hoặc số âm.");
        }

        String query = "UPDATE `khoan thu` SET tenkhoanthu_id=?, sotienthu=?, ngaybatdauthu=?, ngayketthuc=?, mota=? WHERE makhoanthu=? LIMIT 1";

        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement p = con.prepareStatement(query)) {

            p.setInt(1, data.getTenkhoanthu().getTenKhoanThuId());
            p.setInt(2, data.getSotienthu());
            p.setDate(3, data.getNgaybatdauthu());
            p.setDate(4, data.getNgayketthuc());
            p.setString(5, data.getMota());
            p.setInt(6, data.getMakhoanthu());
            p.execute();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM `khoan thu` WHERE makhoanthu=? LIMIT 1";

        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement p = con.prepareStatement(query)) {

            p.setInt(1, id);
            p.execute();
        }
    }

    public Service_loaikhoanthu getService_loaikhoanthu() {
        if (service_loaikhoanthu == null) {
            service_loaikhoanthu = new Service_loaikhoanthu();
        }
        return service_loaikhoanthu;
    }
}
