
package com.miempresa.miproyecto;

import java.math.BigInteger;

/**
 *
 * @author javier
 */
public class Utils {

    public static boolean esEnteroValido(String str) {
        
        if (str == null || str.isBlank()) return false;
        if (!str.matches("-?\\d+")) return false;
        
        BigInteger valor = new BigInteger(str);
        return valor.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 &&
               valor.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0;

    }
    
}
