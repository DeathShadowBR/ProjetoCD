/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;

import common.Task;
import java.io.Serializable;
import java.math.BigInteger;
import java.rmi.RemoteException;
/**
 *
 * @author Gustavo
 * @param <T>
 */
public class ServicePerfectNumber<T> implements Task<T>, Serializable  {

    int pos;
    
    public ServicePerfectNumber()throws RemoteException{
        super();
    }

    public ServicePerfectNumber(int pos)throws RemoteException{
        this.pos = pos;
    }
    
    private int primo(){ // posição de um primo

        if(pos == 1) return 2;
        if(pos == 2) return 3;
        int cont = 0;
        int j = 2;
        while(true) {
            double p = Math.pow(2, j) - 1;
            int exp1 = (int)Math.sqrt(p)+ 1;
            boolean primo = true;
            for (int i=3; i <= exp1; i=i+2)
                if ( p%i == 0) {primo = false; break;}
            if(primo){
                cont++;
                if(cont == pos) return j;
            }
            j++;
        } 
        
    }
    
    private String calcula(){

        int primoPos = primo();
        BigInteger result = BigInteger.valueOf( (long) Math.pow(2, primoPos - 1 ));
        BigInteger B = BigInteger.valueOf( (long) (Math.pow(2, primoPos) - 1));
  
        result = result.multiply(B);
        return result.toString();
    }

    @Override
    public T execute() {
        return (T) calcula();
    }
   

        
}
