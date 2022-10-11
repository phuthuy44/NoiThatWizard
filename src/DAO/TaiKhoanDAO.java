/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    
    
}
