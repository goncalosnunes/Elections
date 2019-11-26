/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipt.sd.messenger;

import blockchain.Blockchain;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Key;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import myUtils.Crypt;
import myUtils.GuiUtils;
import myUtils.ImageUtils;
import myUtils.RMI;

/**
 *
 * @author zulu
 */
public class MessengerGUI extends javax.swing.JFrame {

    IRemoteMessage remoteObject;
    RemoteMessageObject myObject;
    Key aes;
    Blockchain bc;
    
    /**
     * Creates new form MessengerGUI
     */
    public MessengerGUI() {
        initComponents();
        bc = new Blockchain();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnConnectTo1 = new javax.swing.JPanel();
        btStartServer = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtServerPort = new javax.swing.JTextField();
        pnConnectTo = new javax.swing.JPanel();
        btConnect = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtConnectAdress = new javax.swing.JTextField();
        txtConnectPortNumber = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstNodes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        txtMessage = new javax.swing.JTextField();
        btSendMEssage = new javax.swing.JButton();
        btSendPhoto = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnConnectTo1.setLayout(new java.awt.BorderLayout());

        btStartServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipt/sd/messenger/start.png"))); // NOI18N
        btStartServer.setText("Connect");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });
        pnConnectTo1.add(btStartServer, java.awt.BorderLayout.EAST);

        jPanel7.setLayout(new java.awt.GridLayout());

        txtServerPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtServerPort.setText("10010");
        txtServerPort.setBorder(javax.swing.BorderFactory.createTitledBorder("Port Number"));
        txtServerPort.setPreferredSize(new java.awt.Dimension(200, 36));
        jPanel7.add(txtServerPort);

        pnConnectTo1.add(jPanel7, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Start Server", pnConnectTo1);

        pnConnectTo.setLayout(new java.awt.BorderLayout());

        btConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipt/sd/messenger/start.png"))); // NOI18N
        btConnect.setText("Connect");
        btConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectActionPerformed(evt);
            }
        });
        pnConnectTo.add(btConnect, java.awt.BorderLayout.EAST);

        jPanel5.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        txtConnectAdress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtConnectAdress.setText("localhost");
        txtConnectAdress.setBorder(javax.swing.BorderFactory.createTitledBorder("Adress"));
        jPanel5.add(txtConnectAdress);

        txtConnectPortNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtConnectPortNumber.setText("10010");
        txtConnectPortNumber.setBorder(javax.swing.BorderFactory.createTitledBorder("Port Number"));
        jPanel5.add(txtConnectPortNumber);

        pnConnectTo.add(jPanel5, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Connect To ....", pnConnectTo);

        jPanel4.setLayout(new java.awt.BorderLayout());

        lstNodes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(lstNodes);

        jPanel4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Network", jPanel4);

        jPanel2.add(jTabbedPane1, java.awt.BorderLayout.WEST);

        txtLog.setColumns(20);
        txtLog.setRows(5);
        txtLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));
        jScrollPane2.setViewportView(txtLog);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(txtDisplay);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        txtMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMessage.setText("hello");
        txtMessage.setBorder(javax.swing.BorderFactory.createTitledBorder("Send Message"));

        btSendMEssage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipt/sd/messenger/p2pSET.jpg"))); // NOI18N
        btSendMEssage.setText("message");
        btSendMEssage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSendMEssage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSendMEssage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendMEssageActionPerformed(evt);
            }
        });

        btSendPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipt/sd/messenger/photos-icon.png"))); // NOI18N
        btSendPhoto.setText("Send");
        btSendPhoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSendPhoto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSendPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendPhotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSendMEssage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSendPhoto))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMessage)
            .addComponent(btSendMEssage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btSendPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectActionPerformed
        try {
            // TODO add your handling code here:
            int port=Integer.valueOf(txtConnectPortNumber.getText());
            String address=txtConnectAdress.getText();
            String name= RemoteMessageObject.NAME; 
                    
            remoteObject=(IRemoteMessage) RMI.getRemote(address, port, name);        
            txtLog.append("connection established");
            
            byte [] secret=remoteObject.getKey(myObject.rsa.getPublic());
            byte [] plain=Crypt.decrypt(secret, myObject.rsa.getPrivate());
            aes=new SecretKeySpec(plain,0,plain.length,"AES");
            myObject.addNode(remoteObject);
            displayNetwork();
        } catch (NotBoundException ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConnectActionPerformed

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed
        try {
            // TODO add your handling code here:
            int serverPort=Integer.valueOf(txtServerPort.getText());
            String nameObject= RemoteMessageObject.NAME; 
            
            myObject=new RemoteMessageObject(serverPort,this, bc);
            
             RMI.startRemoteObject(myObject, serverPort, nameObject);
            
            txtLog.append("Remote Object ready \n");
            
        } catch (Exception ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
            txtLog.append(ex.getMessage()+"\n");
            

        }
        
    }//GEN-LAST:event_btStartServerActionPerformed

    private void btSendPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendPhotoActionPerformed
        try {
            // TODO add your handling code here:
            BufferedImage img=ImageIO.read(new File("images.jpg"));
            byte [] data=ImageUtils.imageToByteArray(img);
            data=Crypt.encrypt(data, aes);
            remoteObject.writeImage(data);
        } catch (Exception ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
            txtLog.append(ex.getMessage());
        }
    }//GEN-LAST:event_btSendPhotoActionPerformed

    private void btSendMEssageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendMEssageActionPerformed
        try {
            List<IRemoteMessage> nodes = myObject.getListNodes();
            for (IRemoteMessage node : nodes) {
                node.writeMessage(txtMessage.getText());
            }
//            // TODO add your handling code here:
//            remoteObject.writeMessage(txtMessage.getText());
//             txtLog.append("Message Sent\n");
//             txtDisplay.setText(txtDisplay.getText()+"\n\t\t\t\t"+txtMessage.getText());
        } catch (Exception ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
            txtLog.append(ex.getMessage()+"\n");
            txtDisplay.setText(txtDisplay.getText()+"\n\t\t\t\t"+txtMessage.getText());
        }
    }//GEN-LAST:event_btSendMEssageActionPerformed

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
            java.util.logging.Logger.getLogger(MessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessengerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btSendMEssage;
    private javax.swing.JButton btSendPhoto;
    private javax.swing.JButton btStartServer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lstNodes;
    private javax.swing.JPanel pnConnectTo;
    private javax.swing.JPanel pnConnectTo1;
    private javax.swing.JTextField txtConnectAdress;
    private javax.swing.JTextField txtConnectPortNumber;
    private javax.swing.JTextPane txtDisplay;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables

    
    public void writeMessage(String txt){
        txtDisplay.setText(txtDisplay.getText()+"\n" + txt);
    }
    
    public void displayImage(BufferedImage img){
        GuiUtils.addImage(txtDisplay, "Image",new ImageIcon(img));
        
    }
    public void displayException(String source, Exception ex){
        txtDisplay.setText(source+"\n\t\t\t\t"+ex.getMessage()+txtLog.getText());
        Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
    public void displayNetwork(){
        try {
            DefaultListModel model = new DefaultListModel();
            List<IRemoteMessage> nodes = myObject.getListNodes();
            for (IRemoteMessage node : nodes) {
                model.addElement(node.getName());
            }
            lstNodes.setModel(model);
            
        } catch (RemoteException ex) {
            Logger.getLogger(MessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}