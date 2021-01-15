package com.walmart.service.palindromo.util;

public class PalindromoHelper {

    private PalindromoHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean evaluate(String cadena) {
        if (cadena.length() < 3) {
            return false;
        }
        
        int inc = 0;
        int des = cadena.length() - 1;

        while ((inc < des)) {
            if (cadena.charAt(inc) == cadena.charAt(des)) {
                inc++;
                des--;
            } else {
                return false;
            }
        }

        return true;
    }

}
