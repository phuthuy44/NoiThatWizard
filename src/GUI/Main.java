/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.MainForNhanVienGUI;
import javax.swing.UIManager;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        new MainForQuanLyGUI().setVisible(true);
<<<<<<< HEAD
       //new MainForNhanVienGUI().setVisible(true);
        // new DangNhapGUI().setVisible(true);
=======
//        new MainForNhanVienGUI().setVisible(true);
//        new MainForKeToanGUI().setVisible(true);
//        new DangNhapGUI().setVisible(true);
>>>>>>> 2da52343057c52acf327b7037871597d550dbe27

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
