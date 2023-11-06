/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package urnaMiddleware;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author leonardo
 */
public interface RmiInterface extends Remote{
    public boolean GravaVoto(String msg) throws RemoteException;
    public String RecuperaVoto() throws RemoteException;
}
