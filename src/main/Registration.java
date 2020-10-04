package main;

import sun.plugin2.message.Message;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Registration {
    public static Customer reg() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Scanner in = new Scanner(System.in);
            System.out.print("Введите логин: ");
            String login = in.next();
            System.out.print("Введите пароль: ");
            String password = in.next();
            password = Arrays.toString(md.digest(password.getBytes()));
            return new Customer(login, password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
