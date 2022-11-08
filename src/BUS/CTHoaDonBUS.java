/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class CTHoaDonBUS {
    private ArrayList<CTHoaDonDTO> listChiTietHoaDon;
    private CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
    public void listCTHD()
    {
        CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
        listChiTietHoaDon = new ArrayList<>();
        listChiTietHoaDon = cthdDAO.getListCTHoaDon();
    }
    public void docListCTHoaDon(){
        this.listChiTietHoaDon = cthdDAO.getListCTHoaDon();
    }
    public ArrayList<CTHoaDonDTO> getListCTHoaDon(){
        return listChiTietHoaDon;
    }
}
