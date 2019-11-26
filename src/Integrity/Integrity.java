/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integrity;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Set;

/**
 *
 * @author gonca
 */
public class Integrity {
    public static void listMessageDigests() {
        //lista do fornecedores
        Provider providers[] = Security.getProviders();
        for (Provider provider : providers) {
            //Serviços fornecidos
            Set<Provider.Service> services = provider.getServices();
            for (Provider.Service service : services) {
                //Serviço de Integridade
                if (service.getType().equalsIgnoreCase("MessageDigest")) {
                    System.out.printf("\n\t %-20s %-20s %s",
                            service.getProvider(), service.getType(), service.getAlgorithm());
                }
            }
        }
    }

    public static byte[] getHash(byte[] data, String algorithm) 
                                                throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        return md.digest();
    }

    public static boolean verifyHash(byte[] data, byte[] hash, String algorithm)
                                                              throws Exception {
                MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        byte[] trueHash = md.digest();
        return Arrays.equals(trueHash, hash);
    }
}
