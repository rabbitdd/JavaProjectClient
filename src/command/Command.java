package command;

import human.HumanBeing;
import main.Customer;

import java.io.Serializable;
import java.net.SocketAddress;
import java.util.ArrayDeque;

public class Command implements Serializable {
    private HumanBeing human;
    private ArrayDeque<HumanBeing> People;

    public ArrayDeque<HumanBeing> getPeople() {
        return People;
    }

    public void setPeople(ArrayDeque<HumanBeing> people) {
        People = people;
    }

    StringBuilder ans = new StringBuilder();
    SocketAddress remoteAdd;
    public SocketAddress getRemoteAdd() {
        return remoteAdd;
    }
    public void setRemoteAdd(SocketAddress remoteAdd) {
        this.remoteAdd = remoteAdd;
    }



    public StringBuilder getAns() {
        return ans;
    }

    public void setAns(StringBuilder ans) {
        this.ans = ans;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    private Customer user;

    public HumanBeing getHuman() {
        return human;
    }

    public void setHuman(HumanBeing human) {
        this.human = human;
    }

    public String getNameOfCommand() {
        return nameOfCommand;
    }

    public void setNameOfCommand(String nameOfCommand) {
        this.nameOfCommand = nameOfCommand;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    private String nameOfCommand;
    private String[] args;

    public Command(String name, String[] args) {
        this.nameOfCommand = name;
        this.args = args;
    }




}
