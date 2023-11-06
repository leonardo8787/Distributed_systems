/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package urnaMiddleware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class RmiImplementacao extends UnicastRemoteObject implements RmiInterface {
    
    public RmiImplementacao() throws RemoteException {
        super();
    }

    @Override
    public boolean GravaVoto(String cor) throws RemoteException {
        try {
            FileWriter writer;
            writer = new FileWriter("/home/leonardo/NetBeansProjects/urna/src/main/webapp/texto.txt", true);
            writer.write(cor + "\n");
            writer.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro em GravaVoto: " + ex.getMessage());
            Logger.getLogger(RmiImplementacao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String RecuperaVoto() throws RemoteException {
        StringBuilder messages = new StringBuilder();
        try {
            FileReader reader;

                reader = new FileReader("/home/leonardo/NetBeansProjects/urna/src/main/webapp/texto.txt");
                BufferedReader buffer = new BufferedReader(reader);
                String line;
                while ((line = buffer.readLine()) != null) {
                    messages.append(line).append("\n");
                }
                buffer.close();
                reader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro em RecuperaVoto: " + ex.getMessage());
            Logger.getLogger(RmiImplementacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages.toString();
    }
}
