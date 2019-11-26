/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonca
 */
public class MinerThr extends Thread {

    String algorithm = "SHA3-256";
    AtomicInteger ticket;
    AtomicBoolean isDone;
    Block bloco;

    public MinerThr(AtomicInteger ticket, AtomicBoolean isDone, Block b) {
        this.ticket = ticket;
        this.isDone = isDone;
        this.bloco = b;
    }

    @Override
    public void run() {
        while (!isDone.get()) {
            int i = ticket.getAndIncrement();
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
                    isDone.set(true);
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(MinerThr.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
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
}
