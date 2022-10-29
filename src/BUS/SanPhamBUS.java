/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class SanPhamBUS {
    private ArrayList<SanPhamDTO> listSanPham = null;
    private SanPhamDAO spDAO = new SanPhamDAO();
    
    public void docDanhSach(){
        this.listSanPham = spDAO.getListSanPham();
    }
    public ArrayList<SanPhamDTO> getListSanPham(){
        return listSanPham;
    }
}
