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
        return t.execute();
    }
}
