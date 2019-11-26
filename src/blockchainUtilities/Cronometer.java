/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainUtilities;

import java.math.BigInteger;

/**
 *
 * @author gonca
 */
public class Cronometer {

    private BigInteger startTime, elapsedTime;
    private boolean run;

    public Cronometer() {
        elapsedTime = BigInteger.ZERO;
        run = false;
    }

    public void start() {
        startTime = BigInteger.valueOf(System.nanoTime());
        elapsedTime = BigInteger.ZERO;
        run = true;
    }

    public void stop() {
        if (run == true) {
            elapsedTime = BigInteger.valueOf(System.nanoTime()).subtract(startTime);
            run = !run;
        }
    }

    public String getElapsedTime() {
        BigInteger seconds = elapsedTime.divide(BigInteger.valueOf(1000000000));
        BigInteger days = seconds.divide(BigInteger.valueOf(3600).multiply(BigInteger.valueOf(24)));
        seconds = seconds.subtract(days.multiply(BigInteger.valueOf(3600).multiply(BigInteger.valueOf(24))));
        BigInteger hours = seconds.divide(BigInteger.valueOf(3600));
        seconds = seconds.subtract(hours.multiply(BigInteger.valueOf(3600)));
        BigInteger minutes = seconds.divide(BigInteger.valueOf(60));
        seconds = seconds.subtract(minutes.multiply(BigInteger.valueOf(60)));
        BigInteger nanos = elapsedTime.remainder(BigInteger.valueOf(1000000000));

        String tempo = days + "d " + hours + "h " + minutes + "m " + seconds + "s " + nanos + "ns";
        return tempo;
    }
}
