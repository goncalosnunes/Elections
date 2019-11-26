/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author gonca
 */
public class Voter {
    String num;

    public Voter(String num) throws Exception {
        this.num = num;
//        createKeys();
    }

    public String getNum() {
        return num;
    }
    
//    public void createKeys() throws Exception {
//            KeyPair kp = Asimetric.generateKeyPair(2048);
//            Asimetric.saveKey( kp.getPrivate(), this.getNum()+ ".priv" );
//            Asimetric.saveKey( kp.getPublic(), this.getNum()+ ".pub" );   
//    }   
}
