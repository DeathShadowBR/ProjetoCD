/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Gustavo
 */
public class ServiceImageImpl extends UnicastRemoteObject implements ServiceImage  {
    
    public ServiceImageImpl() throws RemoteException{
        super();
    }
    
    @Override
     public Integer[][] negativo(Integer[][] matriz){
        int largura = matriz[0].length;
        int altura = matriz.length;
        
        Integer[][] matrizNegativo = new Integer[altura][largura];
        int novoValor;
        for(int y=0;y<largura;y++){
            for(int x=0; x<altura;x++){
                novoValor = 255 - matriz[x][y];
                matrizNegativo[x][y] = novoValor;
                
            }
        }
        return matrizNegativo;
    }
    
}
