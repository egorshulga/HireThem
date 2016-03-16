package com.github.hirethem.util;


import com.github.hirethem.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String USER_NAME = "^[A-Za-z-]+$";
    private static final String USER_SURNAME = "^[A-Za-z-]+$";
    private static final String USER_EMAIL = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private static final String USER_PAYCARD = "^[0-9]+$";
    private static final String USER_LOGIN = "^[0-9a-zA-Z ]+$";
    private static final String USER_PASSWORD = "^[0-9a-zA-Z]+$";

    private static final String DISH_NAME = "^[0-9a-zA-Z ]+";
    private static final String DISH_PRICE = "^[0-9]+\\.*[0-9]*$";
    private static final String DISH_QUANTITY = "^[0-9]+$";
    private static final String DISH_IMAGE = "^[a-zA-Z]+\\.[a-zA-Z]+$";
    private static final String EMPTY_STRING = "";

    private static boolean validValue(String pattern, String  value){
        Pattern patternForName = Pattern.compile(pattern);
        Matcher matcherName = patternForName.matcher(value);
        if(matcherName.find()){
            return true;
        }
        else {
            return false;
        }
    }


    public static boolean userValid(User user){
        if(!validValue(USER_NAME,user.getName())){
            return false;
        }
        if (!validValue(USER_SURNAME,user.getSurname())){
            return false;
        }
        if (!validValue(USER_EMAIL,user.getEmail())){
            return false;
        }
        if (!validValue(USER_PAYCARD,user.getPayCard())){
            return false;
        }
        if (!validValue(USER_LOGIN,user.getLogin())){
            return false;
        }
        if (!validValue(USER_PASSWORD,user.getHash())){
            return false;
        }
        return true;
    }
}
