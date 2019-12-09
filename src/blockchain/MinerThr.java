/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import Net.IRemoteNode;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonca
 */
public class MinerThr extends Thread {

    String algorithm = "SHA3-256";
    IRemoteNode nodo;
    AtomicBoolean isDone;
    Block bloco;

    public MinerThr() {
    }
    
    public void mine(Block blk, AtomicBoolean isDone, IRemoteNode nodo){
        this.bloco = blk;
        this.isDone = isDone;
        this.nodo = nodo;
        this.start();
    }

    @Override
    public void run() {
        while (!isDone.get()) {
            long i = Math.abs(ThreadLocalRandom.current().nextLong());
            String dados;
            String hash;
            String num = (int) Math.pow(10, bloco.size) + "";
            num = num.substring(1);
            try {
                dados = Base64.getEncoder().encodeToString(getHash(bloco.getVoterSecret(), algorithm)) + Base64.getEncoder().encodeToString(getHash(bloco.getCneSecret(), algorithm)) + Base64.getEncoder().encodeToString(getHash((i + "").getBytes(), algorithm));
                hash = Base64.getEncoder().encodeToString(getHash(dados.getBytes(), algorithm));
                if (hash.regionMatches(0, num, 0, bloco.size)) {
                    bloco.hash = hash;
                    bloco.nonce = BigInteger.valueOf(i);
                    nodo.stopMiner(bloco);
                }
            } catch (Exception ex) {
                Logger.getLogger(MinerThr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(isDone.get() == true){
            return;
        }
    }

    public byte[] getHash(byte[] data, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        return md.digest();
    }

    public boolean verifyHash(byte[] data, byte[] hash, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        byte[] trueHash = md.digest();
        return Arrays.equals(trueHash, hash);
    }
    public void stoping(){
        isDone.set(true);
    }
}
