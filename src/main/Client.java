package main;

import Timer.MyThreadForCheckServerConnection;
import command.Command;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;
import java.util.Scanner;



public class Client implements Runnable, Serializable {
    private static Scanner in = new Scanner(System.in);
    private InetSocketAddress serverAddr;
    private ByteBuffer buffer = ByteBuffer.allocate(65507);
    private ByteBuffer output = ByteBuffer.allocate(65507);
    private DatagramChannel client;
    private Customer user;
    MyThreadForCheckServerConnection t = new MyThreadForCheckServerConnection();
    String[] message = new String[1];
    public Client(DatagramChannel client, int port) {
        this.client = client;
        serverAddr = new InetSocketAddress("localhost", port);

    }
    @Override
    public void run() {
        String reg = "";
        String[] mas = new String[5];
        while (!reg.equals("Зарегистрирован") && !reg.equals("Добро пожаловать")) {
            user = Registration.reg();
            Command command = new Command("login", mas);
            command.setUser(user);
            command.setRemoteAdd(null);
            buffer.clear();
            try {
                buffer.put(Serializer.serialize(command));
                buffer.flip();
                client.send(buffer, serverAddr);
                Thread check = new Thread(t);
                check.start();
                client.receive(output);
                check.interrupt();
                command = (Command) Serializer.deserialize(output.array());
                //StringBuilder stringBuilder = (StringBuilder) Serializer.deserialize(output.array());
                reg = command.getAns().toString();
                System.out.println(reg);
                output.clear();
                buffer.clear();
                buffer.put(new byte[65507]);
                buffer.clear();
                if (reg.equals("Зарегистрирован")) {
                    System.out.println("Авторизация прошла успешно");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }







        message[0] = "";
        System.out.println("Привет! Это мое приложение, для просмотра возможных команд введите help");
        while (true) {
            try {
                System.out.println("Введите команду: ");
                message = in.nextLine().split(" ");
                if (message[0].equals("exit"))
                    break;
                Command command = new Command(message[0], Arrays.copyOfRange(message, 0, message.length));
                command.setUser(user);
                command.setRemoteAdd(null);
                Request.setNameOfCommand(command.getNameOfCommand());
                Request.setArgs(command.getArgs());
                Request.typeOfRequest();
                command.setHuman(Request.getElement());
                buffer.clear();
                buffer.put(Serializer.serialize(command));
                buffer.flip();
                client.send(buffer, serverAddr);
                System.out.println("Отправленно.");
                Thread check = new Thread(t);
                check.start();
                client.receive(output);
                check.interrupt();
                command = (Command) Serializer.deserialize(output.array());
                StringBuilder ans = command.getAns();
                System.out.println("Принято.");
                System.out.println(ans);
                output.clear();
                buffer.clear();
                buffer.put(new byte[65507]);
                buffer.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
