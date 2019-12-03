/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipt.sd.messenger;

import blockchain.Blockchain;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Key;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import blockchain.Block;
import myUtils.Crypt;
import myUtils.ImageUtils;

/**
 *
 * @author nusil
 */
public class RemoteMessageObject extends UnicastRemoteObject implements IRemoteMessage {
    
    public static final String NAME = "P2P";
    MessengerGUI gui;
    Blockchain bc;
    KeyPair rsa;
    Key aes;
    CopyOnWriteArraySet<IRemoteMessage> listOfNodes;
    String name;
    int port;
    

    public RemoteMessageObject (int port, MessengerGUI gui, Blockchain bc) throws Exception{
        super(port);
        this.bc = bc;
        this.gui=gui;
        aes=Crypt.generateKey("AES");
        rsa=Crypt.generateKeyPair("RSA");
        listOfNodes = new CopyOnWriteArraySet<>();
        name = InetAddress.getLocalHost().getHostName();
        this.port = port;
    }
    @Override
    public void writeMessage(String txt) throws RemoteException {
//        System.out.println("REMOTE MESSAGE :"+ txt);
        gui.writeMessage(txt);
       
    }

    @Override
    public void writeImage(byte[] img) throws RemoteException {
        try {
            img=Crypt.decrypt(img, aes);
            gui.displayImage(ImageUtils.byteArrayToImage(img));
        } catch (IOException ex) {
            Logger.getLogger(RemoteMessageObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public byte[] getKey(Key pub) throws RemoteException {
        return Crypt.encrypt(aes.getEncoded(), pub);
    }

    @Override
    public void addNode(IRemoteMessage node) throws RemoteException {
        listOfNodes.add(node);
    }

    @Override
    public List<IRemoteMessage> getListNodes() throws RemoteException {
        return new ArrayList<>(listOfNodes);
    }

    @Override
    public String getName() throws RemoteException {
        return name + " : " + port;
    }

    @Override
    public void addBlock(String data) throws RemoteException {
        try {
            bc.add(data);
        } catch (Exception ex) {
            Logger.getLogger(RemoteMessageObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getLastBlock() throws RemoteException {
        return bc.getLast();
    }

    @Override
    public void mineBlock(Block block) throws RemoteException {
        try {
            //block.mine();
        } catch (Exception ex) {
            Logger.getLogger(RemoteMessageObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
  
    
}
