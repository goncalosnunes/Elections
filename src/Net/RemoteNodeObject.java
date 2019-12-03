/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rede;

import blockchain.BalancedMiner;
import blockchain.Block;
import blockchain.Blockchain;
import blockchain.MinerThr;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author Mauro Damásio 20606
 */
public class RemoteNodeObject  extends UnicastRemoteObject implements IRemoteNode {
    private CopyOnWriteArraySet<IRemoteNode> rede;
    private Blockchain blockchain;
    private BalancedMiner miner;
    private Block block;

    public RemoteNodeObject() throws RemoteException{
        
    }
    
    @Override
    public void addNode(IRemoteNode node) throws RemoteException{
    
    }
    
    @Override
    public void syncronizeP2P() throws RemoteException{
    
    }
    
    @Override
    public void syncronizeBlockchain() throws RemoteException{
    
    }
    
    @Override
    public List<IRemoteNode> getNodes() throws RemoteException{
        return new ArrayList<>(rede);
    }
    
    @Override
    public Block getNetworkLastBlock() throws RemoteException{
//        ArrayList<Block> networkLastBlock = new ArrayList<Block>();
//        syncronizeP2P();
//        for (IRemoteNode node : rede) {
//            networkLastBlock.add(node.getLastBlock());
//        }
//
//        return null;
    }
    
    @Override
    public Block getLastBlock() throws RemoteException{
        
        return blockchain.getBlocks().get(blockchain.getBlocks().size() - 1);
    }
    
    @Override
    public void addService() throws RemoteException{
    //contriuir o bloco
    por a rede a minar
            
    }
    
    @Override
    public void startMiner(Block blockNotMined) throws RemoteException{
       // se ja estiver a minar 
       //         sair
       //pOR O MINEIRO a trabalhar
        
        for (IRemoteNode iRemoteNode : rede) {
            iRemoteNode.startMiner(blockNotMined);
        }
    }
    
    @Override
    public void stopMiner(Block blockMined) throws RemoteException{
//        for (RemoteNodeObject node : rede) {
//            for (MinerThr aux : node.miner.thr) {
//               aux.stoping();
//            }
//        }
    }

    @Override
    public Blockchain getBlockchain() throws RemoteException {
        return blockchain;
    }
    
    
}