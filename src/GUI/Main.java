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
<<<<<<< HEAD
        //new MainForQuanLyGUI().setVisible(true);
//<<<<<<< HEAD
       new MainForNhanVienGUI().setVisible(true);
=======
//        new MainForQuanLyGUI().setVisible(true);
>>>>>>> b3664833b6b08a2ff59e381d55b1accc6ce73d57
        // new DangNhapGUI().setVisible(true);
        new MainForNhanVienGUI().setVisible(true);
//        new MainForKeToanGUI().setVisible(true);



        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
