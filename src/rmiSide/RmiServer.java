/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiSide;

import common.Service;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Gustavo
 */
public class RmiServer {
    
    public RmiServer() {
		try {
                        java.rmi.registry.LocateRegistry.createRegistry(1099); 
			Service service = new ComputeService();
                        Service stub = (Service) UnicastRemoteObject.exportObject(service, 0);
			Naming.rebind("rmi://localhost:1099/Service", stub);
                        System.out.println("[RMISERVER]:Bind Criada Service");
		}
		catch( MalformedURLException | RemoteException e ) {
			System.out.println( "Trouble: " + e );
		}
	}
}
