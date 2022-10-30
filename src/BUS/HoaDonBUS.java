/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class HoaDonBUS {
    
    private ArrayList<HoaDonDTO> listHoaDon;
    private HoaDonDAO hdDAO = new HoaDonDAO();
    
    public void docDanhSach(){
//        this.listHoaDon = hdDAO.getListHoaDon();
    }
    public ArrayList<HoaDonDTO> getListHoaDon(){
        return listHoaDon;
    }
    
}
