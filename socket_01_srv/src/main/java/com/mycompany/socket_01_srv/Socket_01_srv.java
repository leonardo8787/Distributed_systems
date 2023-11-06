/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.socket_01_srv;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Socket_01_srv {

    public static void main(String[] args) {
        try{
            ServerSocket serversocket = new ServerSocket(3322);
            String msg = JOptionPane.showInputDialog("mensagem do servidor para o cliente");
            try (Socket cliente = serversocket.accept()) {
                ObjectOutputStream writer = new ObjectOutputStream(cliente.getOutputStream());
                writer.writeUTF(msg);
                writer.close();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "erro no servidor: " + e.getMessage());
        }
    }
}
