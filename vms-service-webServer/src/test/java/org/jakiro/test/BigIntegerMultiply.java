package org.jakiro.test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: jakiro
 * Date: 2017/8/11
 * Time: 上午8:56
 * To change this template use File | Settings | File Templates.
 */
public class BigIntegerMultiply {

    public static void main(String args[]){

        Integer base = new Integer(1000);
        BigInteger result = new BigInteger("1");
        for(int i = 1; i <= base; i++){
            String temp1 = Integer.toString(i);
            BigInteger temp2 = new  BigInteger(temp1);
            result = result.multiply(temp2);
        }
        System.out.println("" + base + "! = " + result);

    }
}
