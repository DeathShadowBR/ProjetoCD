/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiSide;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Gustavo
 */
public class RmiServer {
    
    public RmiServer() {
		try {
                        java.rmi.registry.LocateRegistry.createRegistry(1099); 
			ServiceImage serviceImage = new ServiceImageImpl();
			Naming.rebind("rmi://localhost:1099/ServiceImage", serviceImage);
                        System.out.println("[RMISERVER]:Bind Criada ServiceImage");
		}
		catch( MalformedURLException | RemoteException e ) {
			System.out.println( "Trouble: " + e );
		}
	}
}
