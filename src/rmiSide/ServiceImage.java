/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Gustavo
 */
public interface ServiceImage extends Remote {
    
    public Integer[][] negativo(Integer[][] matriz) throws RemoteException;
    
}