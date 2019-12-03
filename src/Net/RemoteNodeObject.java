/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Net;

import blockchain.BalancedMiner;
import blockchain.Block;
import blockchain.Blockchain;
import blockchain.MinerThr;
import blockchainGUI.GeneratorPanel;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauro Damásio 20606
 */
public class RemoteNodeObject  extends UnicastRemoteObject implements IRemoteNode {
    public static final String NAME = "NET_NODE";
    String host = "unknown";
    int port;
    GeneratorPanel gui;

    CopyOnWriteArraySet<IRemoteNode> nodeList;

    Blockchain myBlockChain;
    BalancedMiner miner = new BalancedMiner();

    public RemoteNodeObject(int port, Blockchain chain, GeneratorPanel gui) throws RemoteException{
        super(port);
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(RemoteNodeObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        nodeList = new CopyOnWriteArraySet<IRemoteNode>();
        this.gui = gui;
        this.myBlockChain = chain;
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
        return new ArrayList<>(nodeList);
    }
    
    @Override
    public Block getNetworkLastBlock() throws RemoteException{
//        ArrayList<Block> networkLastBlock = new ArrayList<Block>();
//        syncronizeP2P();
//        for (IRemoteNode node : rede) {
//            networkLastBlock.add(node.getLastBlock());
//        }
//
        return null;
    }
    
    @Override
    public Block getLastBlock() throws RemoteException{
        
        return myBlockChain.getBlocks().get(myBlockChain.getBlocks().size() - 1);
    }
    
    @Override
    public void addService(String txt) throws RemoteException{
        try {
            Block blk = new Block(myBlockChain.getLast(), txt);
            mine(blk);
        } catch (Exception ex) {
            Logger.getLogger(RemoteNodeObject.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    @Override
    public void mine(Block blockNotMined) throws RemoteException{
       // se ja estiver a minar 
       //         sair
       //pOR O MINEIRO a trabalhar
       //se o mineiro já estiver a minar sai
        if (miner.isWorking()) {
            gui.writeMessage("Miner busy");
            System.out.println("BUSY");
            return;
        }
        gui.startMining();
        //minar de forma assincrona
        new Thread(
                //lambda expression
                () -> {
                    try {
                        //enviar bloco para minagem para a rede
                        for (IRemoteNode nodeList1 : nodeList) {
                            nodeList1.mine(blockNotMined);
                        }

                        //começar a minar
                        miner.mine(blockNotMined, gui);
                    } catch (Exception ex) {
                        Logger.getLogger(RemoteNodeObject.class.getName()).log(Level.SEVERE, null, ex);
                        gui.displayLog(host, ex);
                    }

                }
        ).start();
    }
    
    @Override
    public void stopMiner(Block blockMined) throws RemoteException{
        miner.stopMining();
    }

    @Override
    public Blockchain getBlockchain() throws RemoteException {
        return myBlockChain;
    }

 
    
}