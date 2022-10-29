/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.compress.utils.Lists.newArrayList;

/**
 *
 * @author wizardsc
 */
public class SanPhamDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<SanPhamDTO> dssp = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<SanPhamDTO> getListSanPham() {
        try {
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "SELECT * FROM sanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("IMG")
                );
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

}
