/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainGUI;

import java.math.BigInteger;

/**
 *
 * @author gonca
 */
public class Blocks extends javax.swing.JPanel {

    /**
     * Creates new form Blocks
     */
    public Blocks() {
        initComponents();
        
        customInit();
    }
    
    private void customInit() {
        this.BlockValue.setEnabled(false);
    }
    
    public void setFact(String fact){
        this.BlockValue.setText(fact);
    }
    
    public void setPrevious(String previous){
        this.previousLabel.setText("Previous = " + previous);
    }
    
    public void setHash(String hash){
        this.Hash.setText("Hash = " + hash);
    }
    
    public void setNonce(BigInteger nonce){
        this.Nonce.setText("Nonce = " + nonce);
    }
    
    public void setTempo(String tempo){
        this.tempo.setText("Tempo de mineração = " + tempo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollBlocksPanel = new javax.swing.JScrollPane();
        BlockValue = new javax.swing.JTextArea();
        previousLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Hash = new javax.swing.JLabel();
        Nonce = new javax.swing.JLabel();
        tempo = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        BlockValue.setColumns(20);
        BlockValue.setRows(5);
        scrollBlocksPanel.setViewportView(BlockValue);

        add(scrollBlocksPanel, java.awt.BorderLayout.CENTER);

        previousLabel.setText("Previous");
        add(previousLabel, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        Hash.setText("Hash");
        jPanel1.add(Hash, java.awt.BorderLayout.CENTER);

        Nonce.setText("Nonce");
        jPanel1.add(Nonce, java.awt.BorderLayout.PAGE_START);

        tempo.setText("Tempo");
        jPanel1.add(tempo, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BlockValue;
    private javax.swing.JLabel Hash;
    private javax.swing.JLabel Nonce;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel previousLabel;
    private javax.swing.JScrollPane scrollBlocksPanel;
    private javax.swing.JLabel tempo;
    // End of variables declaration//GEN-END:variables
}
