/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;

import common.Task;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.rmi.RemoteException;

/**
 *
 * @author Gustavo
 */
public class ServiceHarmonicSeries<T> implements Task<T>, Serializable{
    
    private int range;
    
    public ServiceHarmonicSeries()throws RemoteException{
        super();
    }

    public ServiceHarmonicSeries(int range)throws RemoteException{
        this.range = range;
    }
    
    public String calcula(){
        
        Double result = 1.0;
        
        for(int i=2; i<=(range); i++){
            result+= (double) (1.0/i);
        }
        
        return Double.toString(result);
    }
    
    public T execute() {
        return (T) calcula();
    }
   
    
    
}
