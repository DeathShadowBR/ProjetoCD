/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiSide;

import common.Service;
import common.Task;


/**
 *
 * @author Gustavo
 */
public class ComputeService implements Service {
    @Override
    public <T> T executeTask(Task<T> t){
        long tempoInicial = System.currentTimeMillis();
        String name = t.getClass().getName();
        ViewRmiFXMLController.instancia.setConsole("[RMISERVER: " + "]: Executando o Serviço -> " + name + "\n");
        T result = t.execute();
        ViewRmiFXMLController.instancia.setConsole("[RMISERVER: " + "]: Serviço executado em " + ((System.currentTimeMillis() - tempoInicial) / 1000d) + "\n");
        return result;
    }
}
