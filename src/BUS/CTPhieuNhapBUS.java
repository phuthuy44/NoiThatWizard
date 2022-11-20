/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class CTPhieuNhapBUS {
    private CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
    private ArrayList<CTPhieuNhapDTO> listCTPN = null;
    
    public void docDanhSach(){
        this.listCTPN = ctpnDAO.getListCTPN();
    }
    
    public ArrayList<CTPhieuNhapDTO> getListCTPN(){
        return listCTPN;
    }
    
    public void add(CTPhieuNhapDTO ctpn){
        listCTPN.add(ctpn);
        ctpnDAO.insertCTPN(ctpn);
    }
}
