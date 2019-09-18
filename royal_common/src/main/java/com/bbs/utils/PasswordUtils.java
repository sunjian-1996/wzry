package com.bbs.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    // password:未加密密码  encodePassword：加密过的密码
    public static boolean decode(String password, String encodePassword) {
        return bCryptPasswordEncoder.matches(password, encodePassword);
    }

    public static void main(String[] args) {
        String p = "123";
        String encode = encode(p);
        System.out.println(decode("123", encode));
    }
}
