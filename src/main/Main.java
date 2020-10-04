package main;

import human.HumanBeing;

import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class Main {
    static ArrayList<Long> objectId = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.bind(null);
        Client client = new Client(channel, 8080);
        client.run();
    }
}
