package sample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.connection.DatabaseConnection;
import sample.model.Model_khoanthu;
import sample.service.Service_loaikhoanthu;


public class Service_khoanthu {
public void create(Model_khoanthu data) throws SQLException{
    Connection con = null;
    PreparedStatement p = null;
    try{
         con = DatabaseConnection.getInstance().createConnection();
         p = con.prepareStatement("insert into `khoan thu` (tenkhoanthu_id, sotienthu, ngaybatdauthu, ngayketthuc, mota) values(?,?,?,?,?)");
         p.setInt(1, data.getTenkhoanthu().getTenKhoanThuId());
         p.setInt(2, data.getSotienthu());
         p.setDate(3, data.getNgaybatdauthu());
         p.setDate(4, data.getNgayketthuc());
         p.setString(5, data.getMota());
         p.execute();
         
    }finally {
         DatabaseConnection.getInstance().close(p, con);
    }
    }
    public Service_loaikhoanthu getService_loaikhoanthu() {
        if (service_loaikhoanthu == null) {
            service_loaikhoanthu = new Service_loaikhoanthu();
        }
        return service_loaikhoanthu;
    }
    private Service_loaikhoanthu service_loaikhoanthu;
}
