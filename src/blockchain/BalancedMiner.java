/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import blockchainGUI.GeneratorPanel;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author gonca
 */
public class BalancedMiner {
    long nonce = 0;
    AtomicBoolean isWorking;

    public BalancedMiner() {
        isWorking = new AtomicBoolean(false);
    }

    public long getNonce() {
        return nonce;
    }

    public void stopMining() { 
        isWorking.set(false);
        System.out.println("mandei parar");
       
        
    }

    public boolean isWorking() {
        return isWorking.get();
    }
    
    public void mine(Block blk, GeneratorPanel gui) throws InterruptedException{
        int numCores = Runtime.getRuntime().availableProcessors();
        MinerThr[] thr = new MinerThr[numCores];
        //----------------------------------------------------------------------
        //----- construir e por a threads a correr -----------
        //----------------------------------------------------------------------
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new MinerThr();
            thr[i].mine(blk, isWorking);
        }
        //----------------------------------------------------------------------
        //----- esperar que a threads concluam o trabalho ------
        //----------------------------------------------------------------------
        for (int i = 0; i < thr.length; i++) {
            thr[i].join();
        }
    }
    
}
