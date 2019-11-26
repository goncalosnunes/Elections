/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipt.sd.messenger;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.Key;
import blockchain.Block;

/**
 *
 * @author nusil
 */
public interface IRemoteMessage extends Remote{
    public void writeMessage (String txt) throws RemoteException;
    
    public void writeImage (byte[] img) throws RemoteException;
    
    public byte[] getKey ( Key pub) throws RemoteException;
    
    public void addNode(IRemoteMessage node) throws RemoteException;
    public List<IRemoteMessage> getListNodes() throws RemoteException;
    public String getName() throws RemoteException;
    public void addBlock(String data) throws RemoteException;
    public String getLastBlock() throws RemoteException;
    public void mineBlock(Block block) throws RemoteException;
}
