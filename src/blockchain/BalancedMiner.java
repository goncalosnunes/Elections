/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import Net.IRemoteNode;
import blockchainGUI.GeneratorPanel;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonca
 */
public class BalancedMiner {
    Block bloco;
    long nonce = 0;
    AtomicBoolean isDone;
    IRemoteNode nodo;
    MinerThr[] thr;
    public BalancedMiner(IRemoteNode nodo) {
        isDone = new AtomicBoolean(true);
        this.nodo = nodo;
    }

    public long getNonce() {
        return nonce;
    }

    public void stopMining() { 
        try {
            for (MinerThr minerThr : thr) {
                minerThr.stoping();
            }
            isDone.set(true);
        } catch (Exception ex) {
            Logger.getLogger(BalancedMiner.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    public boolean isWorking() {
        return isDone.get();
    }
    
    public void mine(Block blk, GeneratorPanel gui) throws InterruptedException{
        isDone.set(false);
        int numCores = Runtime.getRuntime().availableProcessors();
        thr = new MinerThr[numCores];
        //----------------------------------------------------------------------
        //----- construir e por a threads a correr -----------
        //----------------------------------------------------------------------
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new MinerThr();
            thr[i].mine(blk, isDone, nodo);
        }
        //----------------------------------------------------------------------
        //----- esperar que a threads concluam o trabalho ------
        //----------------------------------------------------------------------
        for (int i = 0; i < thr.length; i++) {
            thr[i].join();
        }
    }
    
}
