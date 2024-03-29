/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import blockchainUtilities.Cronometer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author gonca
 */
public class Blockchain implements Serializable {

    ArrayList<Block> chain;
    
    
    public Blockchain() {
        this.chain = new ArrayList<>();
    }

    public String getLast() {
        if (chain.isEmpty()) {
            return "";
        } else {
            return chain.get(chain.size() - 1).hash;
        }
    }

    public void add(String data) throws Exception {

        Cronometer cronometer = new Cronometer();
        cronometer.start();
        String hash = getLast();
        System.out.println("oi");

        Block newBlock = new Block(hash, data);
        cronometer.stop();
        newBlock.tempo = cronometer.getElapsedTime();
        chain.add(newBlock);

    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        String chainStr = "";
        for (Block block : chain) {
            chainStr += block.toString() + "\n";
        }
        return chainStr;
    }

    public void save() throws Exception {
        JFileChooser fileSave = new JFileChooser();
        //fileSave.getChoosableFileFilters();
        int returnValue = fileSave.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            FileOutputStream myBlockchain = new FileOutputStream(fileSave.getSelectedFile() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(myBlockchain);
            oos.writeObject(chain);
            oos.close();
        }
    }

    public void load(File file) throws Exception {
        ObjectInputStream myFile = new ObjectInputStream(new FileInputStream(file));
        this.chain = (ArrayList<Block>) myFile.readObject();
    }

    public ArrayList<Block> getBlocks() {
        return chain;
    }
}
