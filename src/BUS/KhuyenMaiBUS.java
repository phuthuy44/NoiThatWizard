/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> listKhuyenMai = null;
    private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    
    public void docDanhSach(){
        this.listKhuyenMai = kmDAO.getListKhuyenMai();
    }
    public ArrayList<KhuyenMaiDTO> getListKhuyenMai(){
        return listKhuyenMai;
    }
}
