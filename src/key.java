
import java.security.KeyPair;
import security.confident.Asimetric;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gonca
 */
public class key {
    private static void getKey() throws Exception{
        KeyPair kp = Asimetric.generateKeyPair(2048);
        Asimetric.saveKey(kp.getPublic(), "keyPublicCNE");
    }
    public static void main(String[] args) throws Exception {
        getKey();
    }
}
