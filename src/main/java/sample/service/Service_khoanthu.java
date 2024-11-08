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
import sample.service.Service_loaikhoanthu;


public class Service_khoanthu {
    public List<Model_khoanthu> getAll() throws SQLException {
            Connection con = null;
            PreparedStatement p = null;
            ResultSet r = null;
            try{
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
        } finally{
                DatabaseConnection.getInstance().close(r, p, con);
            }
    }
    public Service_loaikhoanthu service_loaikhoanthu;

    public void create(Model_khoanthu data) throws SQLException {
        String query = "INSERT INTO `khoan thu` (tenkhoanthu_id, sotienthu, ngaybatdauthu, ngayketthuc, mota) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DatabaseConnection.getInstance().createConnection();
             PreparedStatement p = con.prepareStatement(query)) {

            p.setInt(1, data.getTenkhoanthu().getTenKhoanThuId());
            p.setInt(2, data.getSotienthu());
            p.setDate(3, data.getNgaybatdauthu());
            p.setDate(4, data.getNgayketthuc());
            p.setString(5, data.getMota());
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
