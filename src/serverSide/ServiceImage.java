/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;


import common.Task;
import java.io.Serializable;
import java.rmi.RemoteException;


/**
 *
 * @author Gustavo
 */
public class ServiceImage implements Task<int[][]>, Serializable  {
    
    public ServiceImage() throws RemoteException{
        super();
    }
    
    private int[][] matriz;
    
    public ServiceImage(int[][] matriz) throws RemoteException{
        this.matriz = matriz;
    }
    
    @Override
    public int[][] execute(){
        return negativo();
    };
    
    private int[][] negativo(){
        int largura = matriz[0].length;
        int altura = matriz.length;
        
        int[][] matrizNegativo = new int[altura][largura];
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
