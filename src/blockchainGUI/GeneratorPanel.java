/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchainGUI;

import static Integrity.Integrity.getHash;
import Net.IRemoteNode;
import Net.RemoteNodeObject;
import blockchain.Blockchain;
import blockchain.MinerThr;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.KeyPair;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import myUtils.RMI;
import pt.ipt.sd.messenger.IRemoteMessage;
import security.confident.Asimetric;

/**
 *
 * @author gonca
 */
public class GeneratorPanel extends javax.swing.JFrame {
    private RemoteNodeObject myObject;
    private Blockchain bc;
    String algorithm = "SHA3-256";
    private KeyPair kp;
    
    /** Creates new form GeneratorPanel */
    public GeneratorPanel() {
        try {
            kp = Asimetric.generateKeyPair(2048);
        } catch (Exception ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        try {
            customInit();
        } catch (RemoteException ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setExtendedState(MAXIMIZED_BOTH);
        
        
    }
    
     private void customInit() throws RemoteException {
        this.bc = new Blockchain();
        //myObject = new RemoteNodeObject(10010, bc, this);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOptions = new javax.swing.ButtonGroup();
        blockScroll = new javax.swing.JScrollPane();
        blocksPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        load = new javax.swing.JButton();
        Chooser = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btStartServer = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtConnectPort = new javax.swing.JTextField();
        btConnectTo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNodes = new javax.swing.JList<>();
        panel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        psBtn = new javax.swing.JRadioButton();
        beBtn = new javax.swing.JRadioButton();
        cdsBtn = new javax.swing.JRadioButton();
        psdBtn = new javax.swing.JRadioButton();
        addBlock = new javax.swing.JButton();
        txtWorking = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        blocksPanel.setLayout(new javax.swing.BoxLayout(blocksPanel, javax.swing.BoxLayout.LINE_AXIS));
        blockScroll.setViewportView(blocksPanel);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save);

        load.setText("Load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        jPanel1.add(load);

        Chooser.setText("Escolher");
        Chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooserActionPerformed(evt);
            }
        });
        jPanel1.add(Chooser);

        jLabel2.setText("Número de eleitor");

        num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numActionPerformed(evt);
            }
        });

        jLabel1.setText("Port:");

        txtPort.setText("10010");

        btStartServer.setText("Start");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                    .addComponent(btStartServer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btStartServer)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Start Server", jPanel4);

        jLabel3.setText("Address:");

        txtAddress.setText("localhost");

        jLabel4.setText("Port");

        txtConnectPort.setText("10010");

        btConnectTo.setText("Connect");
        btConnectTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectToActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress)
                    .addComponent(txtConnectPort)
                    .addComponent(btConnectTo, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConnectPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btConnectTo)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Connect ", jPanel5);

        jScrollPane2.setViewportView(listNodes);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Network", jPanel6);

        panel4.setBackground(new java.awt.Color(255, 255, 255));

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Log", panel4);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroupOptions.add(psBtn);
        psBtn.setText("PS");
        jPanel3.add(psBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 57, -1));

        buttonGroupOptions.add(beBtn);
        beBtn.setText("BE");
        jPanel3.add(beBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 41, 57, -1));

        buttonGroupOptions.add(cdsBtn);
        cdsBtn.setText("CDS");
        jPanel3.add(cdsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 41, -1, -1));

        buttonGroupOptions.add(psdBtn);
        psdBtn.setText("PSD");
        jPanel3.add(psdBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 18, -1, -1));

        addBlock.setText("Add");
        addBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBlockActionPerformed(evt);
            }
        });
        jPanel3.add(addBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 10, 122, 56));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtWorking.setText("A minerar...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtWorking))
                    .addComponent(blockScroll))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWorking))
                .addGap(22, 22, 22))
        );

        txtWorking.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBlockActionPerformed
        String fact = num.getText()+ "\n" + option();
        try {
            if(!validateUSer(fact)){
                myObject.addService(fact);
               
            }
        } catch (Exception ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
//        data.setText("");
        //num.setText("");
        //this.drawChain();
        
    }//GEN-LAST:event_addBlockActionPerformed
public void drawChain() {
        // Remove all blocks from blocks panel
        this.blocksPanel.removeAll();
        // Add new list of blocks to the blocks panel
        this.bc.getBlocks().stream().forEach((block) -> {
            Blocks newBlock = new Blocks();
           
            try {
                newBlock.setFact(block.getHashUser() + "\n" + Base64.getEncoder().encodeToString(getHash(block.getVoterSecret(), algorithm))+ "\n"+
                        Base64.getEncoder().encodeToString(getHash(block.getCneSecret(), algorithm)));
                
            } catch (Exception ex) {
                Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            newBlock.setPrevious(block.getPrevious());
            newBlock.setNonce(block.getNonce());
            newBlock.setHash(block.getHash());
            newBlock.setTempo(block.getTempo());
            
            newBlock.setMaximumSize(new Dimension(600, 500));

            this.blocksPanel.add(newBlock);

            this.blocksPanel.revalidate();
        });
    }
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       //JFileChooser myFile = new JFileChooser();
        try {
            bc.save();
        } catch (Exception ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        try {
            bc.load(new File("D:\\myBlockchain.ser"));
            this.drawChain();
        } catch (Exception ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadActionPerformed

    private void ChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserActionPerformed
        JFileChooser chooseFile = new JFileChooser();
        chooseFile.setDialogTitle("Choose a directory to open a file: ");
        int returnValue = chooseFile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooseFile.getSelectedFile();
			try {
                            bc.load(selectedFile);
                            this.drawChain();
                        } catch (Exception ex) {
                            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        };
		}
    }//GEN-LAST:event_ChooserActionPerformed

    private void numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numActionPerformed

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int serverPort=Integer.valueOf(txtPort.getText());
            String nameObject= RemoteNodeObject.NAME; 
            
            myObject = new RemoteNodeObject(serverPort, bc, this);
            
             RMI.startRemoteObject(myObject, serverPort, nameObject);
            
            txtLog.append("Remote Object ready \n");
            
        } catch (Exception ex) {
            txtLog.append(ex.getMessage()+"\n");
        }
    }//GEN-LAST:event_btStartServerActionPerformed

    private void btConnectToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectToActionPerformed
        try {
            // TODO add your handling code here:
            int port=Integer.valueOf(txtConnectPort.getText());
            String address=txtAddress.getText();
            String name= RemoteNodeObject.NAME;
            
            IRemoteNode remoteObject =(IRemoteNode) RMI.getRemote(address, port, name);
            myObject.addNode(remoteObject);
            
            txtLog.append("connection established\n");
            displayNetwork();
        } catch (NotBoundException ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }//GEN-LAST:event_btConnectToActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneratorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratorPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Chooser;
    private javax.swing.JButton addBlock;
    private javax.swing.JRadioButton beBtn;
    private javax.swing.JScrollPane blockScroll;
    private javax.swing.JPanel blocksPanel;
    private javax.swing.JButton btConnectTo;
    private javax.swing.JButton btStartServer;
    private javax.swing.ButtonGroup buttonGroupOptions;
    private javax.swing.JRadioButton cdsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listNodes;
    private javax.swing.JButton load;
    private javax.swing.JTextField num;
    private javax.swing.JPanel panel4;
    private javax.swing.JRadioButton psBtn;
    private javax.swing.JRadioButton psdBtn;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtConnectPort;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtPort;
    private javax.swing.JLabel txtWorking;
    // End of variables declaration//GEN-END:variables

    public int option(){
        if(psBtn.isSelected()){return 1;}
        else if(psdBtn.isSelected()){return 2;}
        else if(beBtn.isSelected()){return 3;}
        else if(cdsBtn.isSelected()){return 4;}
        return 0;
    }
     public boolean validateUSer(String data) {
        boolean valida = false;
        for (int i = 0; i < bc.getBlocks().size(); i++) {
            if (getNum(data).equals(bc.getBlocks().get(i).hashUser)) {
                valida = true;
            }
            
        }
        if(valida) System.out.println("Entrada duplicada. Já submeteu o seu voto.");
        return valida;
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
     
     public void displayLog(String source, Exception ex) {
        txtLog.setText(source + "\t" + ex.getMessage() + "\n" + txtLog.getText());
        Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
     
     public void startMining() {
        txtWorking.setVisible(true);
    }

    public void stopMining() {

        SwingUtilities.invokeLater(() -> {
            num.setText("");
            psBtn.setSelected(false);
            psdBtn.setSelected(false);
            beBtn.setSelected(false);
            cdsBtn.setSelected(false);
            txtWorking.setVisible(false);
            drawChain();
            writeLog("block ready" + "\n" + "----------------------");
        });

    }
    
    public void writeLog(String txt) {
        txtLog.setText(txtLog.getText() + "\n" + txt);
    }
    
    public void displayLastNode() {
        drawChain();
    }

    public void displayMessage(String source, String msg) {
        txtLog.setText(txtLog.getText() + "\n" + source + " - " + msg);
    }

    public void writeMessage(String txt) {
        txtLog.setText(txtLog.getText() + "\n" + txt);
    }
    
    public void setIsWorking(boolean bool){
        txtWorking.setVisible(bool);
    }

    private void displayNetwork() {
        try {
            DefaultListModel model = new DefaultListModel();
            List<IRemoteNode> nodes = myObject.getNodes();
            for (IRemoteNode node : nodes) {
                model.addElement(node.getName());
            }
            listNodes.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(GeneratorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
