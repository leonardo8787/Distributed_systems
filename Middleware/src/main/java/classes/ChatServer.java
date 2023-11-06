/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class ChatServer {
    public ChatServer(){
        try{
            Registry reg = LocateRegistry.createRegistry(7777);
            RmiInterface objRmi = new RmiImpl();
            reg.rebind("ServidorChat", objRmi);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "erro no server: " + e.getMessage());
        }
    }
    public static void main(String[] args){
        new ChatServer();
    }
}
