/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.SanPhamBUS;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author wizardsc
 */
public class HoaDonGUI extends javax.swing.JPanel {

    HoaDonBUS hdBUS = new HoaDonBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmGioHang;

    String imgName = "null";
    private BufferedImage i = null;

    private ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();

    public HoaDonGUI() {
        initComponents();
        dtmSanPham = (DefaultTableModel) tblDSSP.getModel();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        init();
        loadDataDSSP();
        loadDataMaHD(); //load mã HD lên form
        txtMaHD.setEnabled(false);
    }

    public void init() {
        //set giao diện cho Table
        //DSSP
        tblDSSP.setFocusable(false);
        tblDSSP.setIntercellSpacing(new Dimension(0, 0));
        tblDSSP.setRowHeight(25);
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.getTableHeader().setOpaque(false);
        tblDSSP.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSSP.getTableHeader().setForeground(Color.WHITE);
        tblDSSP.setSelectionBackground(new Color(188, 206, 248));
        tblDSSP.setSelectionForeground(Color.BLACK);
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSSP.getTableHeader().setReorderingAllowed(false);
        tblDSSP.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        //GioHang
        tblGioHang.setFocusable(false);
        tblGioHang.setIntercellSpacing(new Dimension(0, 0));
        tblGioHang.setRowHeight(25);
        tblGioHang.setFillsViewportHeight(true);
        tblGioHang.getTableHeader().setOpaque(false);
        tblGioHang.getTableHeader().setBackground(new Color(152, 168, 248));
        tblGioHang.getTableHeader().setForeground(Color.WHITE);
        tblGioHang.setSelectionBackground(new Color(188, 206, 248));
        tblGioHang.setSelectionForeground(Color.BLACK);
        tblGioHang.setFont(new Font("Arial", Font.PLAIN, 13));
        tblGioHang.getTableHeader().setReorderingAllowed(false);
        tblGioHang.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        //set SoLuong Spinner
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, -10, 100, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(true);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        txtSpinner.setBackground(Color.white);
    }

    public void showAllDSSP(ArrayList<SanPhamDTO> dssp) {
        dtmSanPham.setRowCount(0);
        for (int i = 0; i < dssp.size(); i++) {
            dtmSanPham.addRow(new String[]{
                dssp.get(i).getMaSP(),
                dssp.get(i).getTenSP(),
                String.valueOf(dssp.get(i).getSoLuong()),
                String.valueOf(dssp.get(i).getDonGia()),
                dssp.get(i).getIMG()
            });
        }
    }

    public void loadDataDSSP() {
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        showAllDSSP(dssp);
    }
//--    Load mã hóa đơn mới nhất lên form

    private void loadDataMaHD() {
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        showAllDSHD(dshd);
    }

    public void showAllDSHD(ArrayList<HoaDonDTO> dshd) {
        for (int i = 0; i < dshd.size(); i++) {
            int sum = Integer.parseInt(dshd.get(i).getMaHD().substring(2)) + 1;
            if (sum < 10) {
                txtMaHD.setText(String.valueOf("HD0" + sum));
            } else {
                txtMaHD.setText(String.valueOf("HD" + sum));
            }
            sum = 0;

        }
    }
//--    

    private void loadDataGioHang() {
        dtmGioHang.setRowCount(0);
        ArrayList<SanPhamDTO> dssp = null;

    }
//-- Xuất sản phẩm vừa thêm vào giỏ hàng ra table

    public void outModelGioHang(DefaultTableModel dtmGioHang, ArrayList<CTHoaDonDTO> dscthd) {
        Vector data;
        dtmGioHang.setRowCount(0);
        for (int i = 0; i < dscthd.size(); i++) {
            dtmGioHang.addRow(new String[]{
                dscthd.get(i).getMaSP(),
                dscthd.get(i).getTenSP(),
                String.valueOf(dscthd.get(i).getSoLuong()),
                String.valueOf(dscthd.get(i).getDonGia()),
                String.valueOf(dscthd.get(i).getThanhTien())
            });
        }
    }
//--

//-- Tính tổng tiền hóa đơn
    public int sumHD() {
        int sum = 0;
        for (CTHoaDonDTO cthd : dscthd) {
            int SoLuong = cthd.getSoLuong();
            int DonGia = cthd.getDonGia();
            sum += SoLuong * DonGia;
        }
        return sum;
    }
//--

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblDSSP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        txtIMG = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JSpinner();
        lblMaSP8 = new javax.swing.JLabel();
        txtMaSP7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnChinhSua1 = new javax.swing.JLabel();
        btnChinhSua2 = new javax.swing.JLabel();
        lblMaSP1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        lblMaSP2 = new javax.swing.JLabel();
        txtMaSP2 = new javax.swing.JTextField();
        lblMaSP3 = new javax.swing.JLabel();
        txtMaSP3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lblMaSP4 = new javax.swing.JLabel();
        lblMaSP5 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lblMaSP6 = new javax.swing.JLabel();
        txtMaSP5 = new javax.swing.JTextField();
        lblMaSP7 = new javax.swing.JLabel();
        txtMaSP6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnThemSP1 = new javax.swing.JLabel();

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Danh sách sản phẩm");
        jPanel1.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 523, -1));

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Còn lại", "Đơn Giá", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSSP);
        if (tblDSSP.getColumnModel().getColumnCount() > 0) {
            tblDSSP.getColumnModel().getColumn(0).setResizable(false);
            tblDSSP.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblDSSP.getColumnModel().getColumn(1).setResizable(false);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblDSSP.getColumnModel().getColumn(2).setResizable(false);
            tblDSSP.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblDSSP.getColumnModel().getColumn(3).setResizable(false);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblDSSP.getColumnModel().getColumn(4).setResizable(false);
            tblDSSP.getColumnModel().getColumn(4).setPreferredWidth(1);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 75, 500, 370));

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(txtIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 160, 190));

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã SP");
        jPanel1.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));
        jPanel1.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 230, 24));
        jPanel1.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 230, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Tên SP");
        jPanel1.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Đơn giá");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, -1, -1));
        jPanel1.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, 230, 24));

        btnThemSP.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnThemSP.setText("Thêm sản phẩm");
        btnThemSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });
        jPanel1.add(btnThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 170, -1));
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 230, 24));

        lblMaSP8.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP8.setText("Mã HD");
        jPanel1.add(lblMaSP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(txtMaSP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, -1));

        jPanel2.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setResizable(false);
            tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblGioHang.getColumnModel().getColumn(1).setResizable(false);
            tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblGioHang.getColumnModel().getColumn(2).setResizable(false);
            tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(45);
            tblGioHang.getColumnModel().getColumn(3).setResizable(false);
            tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblGioHang.getColumnModel().getColumn(4).setResizable(false);
            tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnChinhSua1.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnChinhSua1.setText("Tạo hóa đơn");
        btnChinhSua1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSua1MouseClicked(evt);
            }
        });

        btnChinhSua2.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnDelete.png"))); // NOI18N
        btnChinhSua2.setText("Hủy tạo");
        btnChinhSua2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSua2MouseClicked(evt);
            }
        });

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã HD");

        lblMaSP2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP2.setText("Mã KH");

        lblMaSP3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP3.setText("Mã NV");

        lblMaSP4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP4.setText("Ngày tạo");

        lblMaSP5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP5.setText("Tổng tiền");

        lblMaSP6.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP6.setText("Khuyến mãi");

        lblMaSP7.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP7.setText("Thanh toán");

        jButton1.setText("...");

        jButton2.setText("...");

        jButton3.setText("...");

        btnThemSP1.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThemSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnDelete.png"))); // NOI18N
        btnThemSP1.setText("Xóa sản phẩm");
        btnThemSP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSP1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP3)
                                    .addComponent(lblMaSP4))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaSP3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP1)
                                    .addComponent(lblMaSP2))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaSP5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMaSP7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMaSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(4, 4, 4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChinhSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnChinhSua2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThemSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemSP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSP1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP2)
                                    .addComponent(txtMaSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP3)
                                    .addComponent(txtMaSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP4)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP6)
                                    .addComponent(txtMaSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaSP5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChinhSua2)
                    .addComponent(btnChinhSua1))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        int k = tblDSSP.getSelectedRow();

        txtMaSP.setText(tblDSSP.getModel().getValueAt(k, 0).toString());
        txtTenSP.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
//        txtSoLuong.setText(tblDSSP.getModel().getValueAt(k,2).toString());
        txtDonGia.setText(tblDSSP.getModel().getValueAt(k, 3).toString());
        imgName = tblDSSP.getModel().getValueAt(k, 4).toString();
        Image newImage;
        newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(155, 185, Image.SCALE_DEFAULT);
        txtIMG.setIcon(new ImageIcon(newImage));

        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);

        txtDonGia.setEnabled(false);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked
        String MaHD = txtMaHD.getText();
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getValue().toString());
        int DonGia = Integer.parseInt(txtDonGia.getText());
        int ThanhTien = SoLuong * DonGia;

        int k = tblDSSP.getSelectedRow();
        int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString());

        spBUS.capNhatSoLuongHD(MaSP, -SoLuong, SoLuongConLai);
        spBUS.docDanhSach();
        boolean flag = true;
        for (CTHoaDonDTO cthd : dscthd) {
            if (cthd.getMaSP().equals(MaSP)) {
                int old = cthd.getSoLuong();
                cthd.setSoLuong(old + SoLuong);
                int new1 = cthd.getSoLuong();
                cthd.setThanhTien(new1 * DonGia);
                flag = false;
                break;
            }
        }
        if (flag) {
            dscthd.add(new CTHoaDonDTO(MaHD, MaSP, TenSP, SoLuong, DonGia, ThanhTien));

        }
        outModelGioHang(dtmGioHang, dscthd);
        txtTongTien.setText(String.valueOf(sumHD()));
        loadDataDSSP();
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtSoLuong.setValue(0);
        txtDonGia.setText("");
        txtIMG.setIcon(null);
        txtIMG.setText("IMAGE");
        imgName = null;
//
//        dtmGioHang.addRow(new String[]{
//            MaSP,
//            TenSP,
//            String.valueOf(SoLuong),
//            String.valueOf(DonGia),
//            String.valueOf(ThanhTien)
//        });
    }//GEN-LAST:event_btnThemSPMouseClicked

    private void btnChinhSua2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSua2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSua2MouseClicked

    private void btnChinhSua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSua1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSua1MouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int k = tblGioHang.getSelectedRow();
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnThemSP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSP1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemSP1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChinhSua1;
    private javax.swing.JLabel btnChinhSua2;
    private javax.swing.JLabel btnThemSP;
    private javax.swing.JLabel btnThemSP1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP2;
    private javax.swing.JLabel lblMaSP3;
    private javax.swing.JLabel lblMaSP4;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP6;
    private javax.swing.JLabel lblMaSP7;
    private javax.swing.JLabel lblMaSP8;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSP2;
    private javax.swing.JTextField txtMaSP3;
    private javax.swing.JTextField txtMaSP5;
    private javax.swing.JTextField txtMaSP6;
    private javax.swing.JTextField txtMaSP7;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
