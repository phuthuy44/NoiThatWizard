/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.ChangeScreenQuanLy;
import GUI.model.DanhMuc;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author Administrator
 */
public class MainKhachSanGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainKhachSanGUI
     */
    public MainKhachSanGUI() {
        setUndecorated(true);      
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("./src/image/lblIconHotel32x32");
        setIconImage(logo.getImage());
        
        ChangeScreenQuanLy controller = new ChangeScreenQuanLy(pnView);
//        controller.setView(pnNhanVien,lblNhanVien);
//        
        ArrayList<DanhMuc> list = new ArrayList<>();
        list.add(new DanhMuc("NhanVien", pnNhanVien, lblNhanVien));
        list.add(new DanhMuc("TrangChu", pnTrangChu, lblTrangChu));
        list.add(new DanhMuc("CaLam", pnCaLam, lblCaLam));
        list.add(new DanhMuc("TaiKhoan", pnTaiKhoan, lblTaiKhoan));
        list.add(new DanhMuc("TrangChu", pnTrangChu, lblTrangChu));
        list.add(new DanhMuc("ChucVu", pnChucVu, lblChucVu));
        
        controller.setEvent(list);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        lblThongTin = new javax.swing.JLabel();
        cbxPhanQuyen = new javax.swing.JComboBox<>();
        pnView = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        lblIconHotel = new javax.swing.JLabel();
        pnTaiKhoan = new javax.swing.JPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        pnCaLam = new javax.swing.JPanel();
        lblCaLam = new javax.swing.JLabel();
        pnNhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        pnChucVu = new javax.swing.JPanel();
        lblChucVu = new javax.swing.JLabel();
        pnTrangChu = new javax.swing.JPanel();
        lblTrangChu = new javax.swing.JLabel();
        pnDangXuat = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 700));

        pnRoot.setBackground(new java.awt.Color(255, 255, 255));
        pnRoot.setPreferredSize(new java.awt.Dimension(1300, 730));

        pnHeader.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader.setToolTipText("");
        pnHeader.setPreferredSize(new java.awt.Dimension(102, 40));

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minus.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        lblThongTin.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        lblThongTin.setText("BẠN ĐANG ĐĂNG NHẬP VỚI TƯ CÁCH");

        cbxPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản trị viên" }));
        cbxPhanQuyen.setEnabled(false);

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeaderLayout.createSequentialGroup()
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnView.setBackground(new java.awt.Color(250, 247, 240));
        pnView.setPreferredSize(new java.awt.Dimension(1089, 700));

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1099, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pnMenu.setBackground(new java.awt.Color(188, 206, 248));
        pnMenu.setPreferredSize(new java.awt.Dimension(211, 650));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hotel.png"))); // NOI18N
        pnMenu.add(lblIconHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 201, 186));

        pnTaiKhoan.setBackground(new java.awt.Color(188, 206, 248));
        pnTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        pnTaiKhoan.setPreferredSize(new java.awt.Dimension(300, 43));

        lblTaiKhoan.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblAccount.png"))); // NOI18N
        lblTaiKhoan.setText("  Tài khoản");

        javax.swing.GroupLayout pnTaiKhoanLayout = new javax.swing.GroupLayout(pnTaiKhoan);
        pnTaiKhoan.setLayout(pnTaiKhoanLayout);
        pnTaiKhoanLayout.setHorizontalGroup(
            pnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTaiKhoanLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(lblTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTaiKhoanLayout.setVerticalGroup(
            pnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 476, 201, -1));

        pnCaLam.setBackground(new java.awt.Color(188, 206, 248));
        pnCaLam.setForeground(new java.awt.Color(255, 255, 255));
        pnCaLam.setPreferredSize(new java.awt.Dimension(300, 43));

        lblCaLam.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblCaLam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblCaLam.png"))); // NOI18N
        lblCaLam.setText("  Ca làm");

        javax.swing.GroupLayout pnCaLamLayout = new javax.swing.GroupLayout(pnCaLam);
        pnCaLam.setLayout(pnCaLamLayout);
        pnCaLamLayout.setHorizontalGroup(
            pnCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCaLamLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(lblCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnCaLamLayout.setVerticalGroup(
            pnCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCaLam, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 415, 201, -1));

        pnNhanVien.setBackground(new java.awt.Color(188, 206, 248));
        pnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        pnNhanVien.setPreferredSize(new java.awt.Dimension(300, 43));

        lblNhanVien.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblNhanVien.png"))); // NOI18N
        lblNhanVien.setText("  Nhân viên");

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 293, 201, -1));

        pnChucVu.setBackground(new java.awt.Color(188, 206, 248));
        pnChucVu.setForeground(new java.awt.Color(255, 255, 255));
        pnChucVu.setPreferredSize(new java.awt.Dimension(300, 43));

        lblChucVu.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblChucVu.png"))); // NOI18N
        lblChucVu.setText("  Chức vụ");

        javax.swing.GroupLayout pnChucVuLayout = new javax.swing.GroupLayout(pnChucVu);
        pnChucVu.setLayout(pnChucVuLayout);
        pnChucVuLayout.setHorizontalGroup(
            pnChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChucVuLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnChucVuLayout.setVerticalGroup(
            pnChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 354, 201, -1));

        pnTrangChu.setBackground(new java.awt.Color(188, 206, 248));
        pnTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        pnTrangChu.setPreferredSize(new java.awt.Dimension(300, 43));

        lblTrangChu.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblHome.png"))); // NOI18N
        lblTrangChu.setText("  Trang chủ");

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTrangChuLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(lblTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 232, 201, -1));

        pnDangXuat.setBackground(new java.awt.Color(188, 206, 248));
        pnDangXuat.setForeground(new java.awt.Color(255, 255, 255));

        lblDangXuat.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/power.png"))); // NOI18N
        lblDangXuat.setText("  Đăng xuất");

        javax.swing.GroupLayout pnDangXuatLayout = new javax.swing.GroupLayout(pnDangXuat);
        pnDangXuat.setLayout(pnDangXuatLayout);
        pnDangXuatLayout.setHorizontalGroup(
            pnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDangXuatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnDangXuatLayout.setVerticalGroup(
            pnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 201, -1));

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnView, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(pnRootLayout.createSequentialGroup()
                        .addComponent(pnView, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainKhachSanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainKhachSanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainKhachSanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainKhachSanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainKhachSanGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JComboBox<String> cbxPhanQuyen;
    private javax.swing.JLabel lblCaLam;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblIconHotel;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblTaiKhoan1;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JPanel pnCaLam;
    private javax.swing.JPanel pnChucVu;
    private javax.swing.JPanel pnDangXuat;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnTaiKhoan;
    private javax.swing.JPanel pnTaiKhoan1;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JPanel pnView;
    // End of variables declaration//GEN-END:variables
}
