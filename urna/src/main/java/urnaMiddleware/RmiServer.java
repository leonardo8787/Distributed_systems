/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package urnaMiddleware;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class RmiServer {
    public RmiServer(){
        try{
            Registry reg = LocateRegistry.createRegistry(7777);
            RmiInterface objRmi = (RmiInterface) new RmiImplementacao();
            reg.rebind("ServidorVoto", (Remote) objRmi);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "erro no server: " + e.getMessage());
        }
    }
    public static void main(String[] args){
        new RmiServer();
    }
}
