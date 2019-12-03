/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author gonca
 */
public class BalancedMiner {
    Block bloco;
    AtomicInteger ticket;
    AtomicBoolean isDone = new AtomicBoolean(false);
    public MinerThr[] thr;

    public BalancedMiner(Block bloco, AtomicInteger ticket) {
        this.bloco = bloco;
        this.ticket = ticket;
    }
    
    public void MineBlock() throws InterruptedException{
        int numCores = Runtime.getRuntime().availableProcessors();
        ticket = new AtomicInteger(0);
        thr = new MinerThr[numCores];
        //----------------------------------------------------------------------
        //----- construir e por a threads a correr -----------
        //----------------------------------------------------------------------
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new MinerThr(isDone, bloco);
            thr[i].start();
        }
        //----------------------------------------------------------------------
        //----- esperar que a threads concluam o trabalho ------
        //----------------------------------------------------------------------
        for (int i = 0; i < thr.length; i++) {
            thr[i].join();
        }
    }
    
}
