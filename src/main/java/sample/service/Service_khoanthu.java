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
    private int getNextMakhoanthu() throws SQLException {
        String query = "SELECT MAX(makhoanthu) FROM `khoan thu`";
        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement p = con.prepareStatement(query);
             ResultSet r = p.executeQuery()) {

            if (r.next()) {
                return r.getInt(1) + 1; // Lấy makhoanthu lớn nhất và cộng 1
            } else {
                return 1; // Nếu bảng trống, bắt đầu từ 1
            }
        }
    }
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
            p = con.prepareStatement("SELECT khoan_thu.makhoanthu, khoan_thu.tenkhoanthu_id, loai_khoan_thu.tenkhoanthu_name, khoan_thu.sotienthu, khoan_thu.ngaybatdauthu, khoan_thu.ngayketthuc, khoan_thu.mota " +
                                     "FROM `khoan thu` JOIN `loại khoản thu` ON khoan_thu.tenkhoanthu_id = loai_khoan_thu.tenkhoanthu_id " +
                                     "ORDER BY loai_khoan_thu.tenkhoanthu_name");
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

    public void create(Model_khoanthu data) throws SQLException {
        String query = "UPDATE `khoan thu` SET tenkhoanthu_id=?, sotienthu=?, ngaybatdauthu=?, ngayketthuc=?, mota=? WHERE makhoanthu=? LIMIT 1";

        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement p = con.prepareStatement(query)) {

            p.setInt(1, data.getTenkhoanthu().getTenKhoanThuId());
            p.setInt(2, data.getSotienthu());
            p.setDate(3, data.getNgaybatdauthu());
            p.setDate(4, data.getNgayketthuc());
            p.setString(5, data.getMota());
            p.setInt(6, data.getMakhoanthu());
            p.executeUpdate();
        }
    }

    public void edit(Model_khoanthu data) throws SQLException {
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
