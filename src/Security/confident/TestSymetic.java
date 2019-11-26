/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.confident;

import java.security.Key;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doctmanso
 */
public class TestSymetic {
    
    public static void main(String[] args) {
        try {
            Simetric.listAlgorithms();
            
            System.out.println("\nCRIPTOGRAFIA\n");
            String message = "hello world";
            System.out.println("Mensagem : " + message);
            
            String algorithm = "AESWrap_256";
            
            Key k = Simetric.generateKey("AES",256);
            byte secret[] = Simetric.encrypt(message.getBytes(), k);
            
            System.out.println("Segredo : " + Base64.getEncoder().encodeToString(secret));
            byte [] plain =  Simetric.decrypt(secret, k);
            System.out.println("Original: " + new String(plain));
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(TestSymetic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
