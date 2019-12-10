/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Net;

import blockchain.Block;
import blockchain.Blockchain;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mauro Damásio 20606
 */
public interface IRemoteNode extends Remote{
    public void addNode(IRemoteNode node) throws RemoteException;
    public void syncronizeP2P() throws RemoteException;
    public void syncronizeBlockchain() throws RemoteException;
    public List<IRemoteNode> getNodes() throws RemoteException;
    public Block getNetworkLastBlock() throws RemoteException;
    public Block getLastBlock() throws RemoteException;
    public Blockchain getBlockchain() throws RemoteException;
    public void addService(String txt) throws RemoteException;
    public void mine(Block blockNotMined) throws RemoteException;
    public void stopMiner(Block blockMined) throws RemoteException;
    public void stopMiningNetwork(Block blockMined) throws RemoteException;
    public String getName() throws RemoteException;
}