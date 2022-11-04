/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wizardsc
 */
public class KhuyenMaiDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    private ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
        try {
            ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
            String sql = "SELECT * FROM khuyenmai";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString("MaKM"),
                        rs.getString("TenKM"),
                        rs.getInt("PhanTramKM"),
                        rs.getInt("DieuKien"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc")
                );
                dskm.add(km);
            }
            return dskm;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    
}
