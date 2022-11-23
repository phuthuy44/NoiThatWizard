/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTPhieuXuatDAO;
import DTO.CTHoaDonDTO;
import DTO.CTPhieuXuatDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class CTPhieuXuatBUS {

    private CTPhieuXuatDAO ctpxDAO = new CTPhieuXuatDAO();
    private ArrayList<CTPhieuXuatDTO> listCTPX = null;

    public void docDanhSach(){
        this.listCTPX = ctpxDAO.getListCTPX();
    }

    public ArrayList<CTPhieuXuatDTO> getListCTPX() {
        return listCTPX;
    }
    
    public void add(CTPhieuXuatDTO ctpx){
        listCTPX.add(ctpx);
        CTPhieuXuatDAO ctpxDAO = new CTPhieuXuatDAO();
        ctpxDAO.insertCTPX(ctpx);
    }
}
