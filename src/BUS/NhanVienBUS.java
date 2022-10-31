/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhanVienBUS {
    private ArrayList<NhanVienDTO> listNhanVien = null;
    public NhanVienDAO nvDAO = new NhanVienDAO();
    
    public void docDanhSach(){
        this.listNhanVien = nvDAO.getListNhanVien();
    }
    
    public ArrayList<NhanVienDTO> getListNhanVien(){
        return listNhanVien;
    }
    
    public void add(NhanVienDTO nv){
        listNhanVien.add(nv);
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.insertNhanVien(nv);
    }
    
    public void delete(String MaNV){
        for(NhanVienDTO nv : listNhanVien){
            if(nv.getMaNV().equals(MaNV)){
                listNhanVien.remove(nv);
                NhanVienDAO nvDAO = new NhanVienDAO();
                nvDAO.deleteNhanVien(MaNV);
                return;
            }
        }
    }
    public void updates(NhanVienDTO nv){
        for(int i=0; i<listNhanVien.size();i++){
            if(listNhanVien.get(i).getMaNV().equals(nv.getMaNV())){
                listNhanVien.set(i, nv);
               // NhanVienDAO nvDao = new NhanVienDAO();
                nvDAO.updatesNhanVien(nv);
                return;
            }
        }
    }
    public void ExportExcel() {
        nvDAO.ExportExcel();
    }

    public void ImportExcel(File file) {
        nvDAO.ImportExcel(file);
    }
    
    public void listNV() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        listNhanVien = new ArrayList<>();
        listNhanVien = nvDAO.getListNhanVien();
    }
}
