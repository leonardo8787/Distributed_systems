/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.socket_02_cct;

import java.awt.Component;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.constant.ConstantDescs.NULL;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Socket_02_cct {

    public static void main(String[] args) throws IOException {
        try (Socket cliente = new Socket("200.128.142.104", 3322)) {
            ObjectInputStream reader = new ObjectInputStream(cliente.getInputStream());
            JOptionPane.showMessageDialog((Component) NULL, "mensagem recebida: " + reader.readUTF());
            reader.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Server error: " + e.getMessage());
        }
    }
}
