/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author leonardo
 */
public interface RmiInterface extends Remote {
    public boolean GravaMsg(String msg) throws RemoteException;

    /**
     *
     * @return
     */
    public String RecuperaMsgs() throws RemoteException;
    
}
