package com.github.hirethem.util;

import java.io.UnsupportedEncodingException;

public class CharsetUtil {
    private static String UTF_8 = "UTF-8";
    private static String ISO = "ISO-8859-1";

    public static String encodeToUTF8(String inputString){

        String value = new String();
        byte ptext[];
        try {
            ptext = inputString.getBytes(ISO);
            value = new String(ptext, UTF_8);
        } catch (UnsupportedEncodingException e) {
            //TODO LOGGER
        }

        return value;
    }
}
