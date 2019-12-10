/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import Integrity.Integrity;
import static Integrity.Integrity.getHash;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.confident.Asimetric;

/**
 *
 * @author gonca
 */
public class Block implements Serializable {
    public AtomicInteger ticket;
    private static final long serialVersionUID = 1L;
    byte[] cneSecret;
    byte[] voterSecret;
    public String hashUser;
    String hash, previous;
    int size;
    public BigInteger nonce;
    public long dataDeMineracao;
    public String tempo;

    public Block(String previous, String data) throws Exception {
        this.previous = previous;
        this.cneSecret = encryptCNE(data);
        this.voterSecret = encryptGeral(data);
        this.hashUser = getNum(data);
        this.size = 2;
        this.ticket = new AtomicInteger();
    }


    public String getNum(String data) {
        String[] vote = data.split("\n");
        String algorithm = "SHA3-256";
        String num = "";
        try {

            num = Base64.getEncoder().encodeToString(getHash(vote[0].getBytes(), algorithm));

        } catch (Exception ex) {
            Logger.getLogger(MinerThr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public String getOption(String data) {
        String[] vote = data.split("\n");
        return vote[1];
    }

    public byte[] encryptCNE(String data) throws Exception {

        // Dados para CNE
        //
        // Retirar a OPÇÃO do FACTO
        String choose = getOption(data);
        byte[] chooseBytes = choose.getBytes();
        // Encriptar a OPÇÃO com criptografia Assimétrica
//        KeyPair kp = Asimetric.generateKeyPair(2048);
        byte[] chooseCrypted = Asimetric.encrypt(chooseBytes, Asimetric.loadPublicKey("keyPublicCNE"));
//        Files.write(Paths.get(getNum(data) + ".CNEpubk"), chooseCrypted);
        return chooseCrypted;
    }

    public byte[] encryptGeral(String data) throws Exception {
        //Files.write(Paths.get(getNum(data) + ".CNEpubk"), chooseCrypted);
        //Encriptar o voto completo com criptografia Assimétrica
        byte[] factoBytes = data.getBytes();
        KeyPair kpair = Asimetric.generateKeyPair(2048);
        byte[] voteCrypted = Asimetric.encrypt(factoBytes, kpair.getPublic());
//        Files.write(Paths.get(getNum(data) + ".Voterpubk"), voteCrypted);
        return voteCrypted;
    }

    public String getHashUser() {
        return hashUser;
    }

    public byte[] getCneSecret() {
        return cneSecret;
    }

    public byte[] getVoterSecret() {
        return voterSecret;
    }

    public String getPrevious() {
        return previous;
    }

    public String getHash() {
        return hash;
    }

    public byte[] getHash(byte[] data, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        return md.digest();
    }

    public BigInteger getNonce() {
        return this.nonce;
    }

    public String getTempo() {
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss z");
        Date date = new Date(dataDeMineracao);
        return formatter.format(date);
    }

    public String toString() {
        try {
            return String.format("%10d %10s(%d) %10d %b", previous, cneSecret, voterSecret, nonce, hash, isValid());
        } catch (Exception ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isValid() throws Exception {
        String algorithm = "SHA3-256";
        return Integrity.verifyHash((previous + cneSecret + voterSecret + nonce).getBytes(), hash.getBytes(), algorithm);
    }

}
