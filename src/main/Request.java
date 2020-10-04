package main;

import human.HumanBeing;

public class Request {
    static private String nameOfCommand;
    static private String[] args;
    static private HumanBeing element;

    public static HumanBeing getElement() {
        return element;
    }

    public static String getNameOfCommand() {
        return nameOfCommand;
    }

    public static void setNameOfCommand(String nameOfCommand) {
        Request.nameOfCommand = nameOfCommand;
    }

    public static String[] getArgs() {
        return args;
    }

    public static void setArgs(String[] args) {
        Request.args = args;
    }

    static public void typeOfRequest() {
        if (nameOfCommand.equals("add") || nameOfCommand.equals("add_if_min") || nameOfCommand.equals("update")) {
            Filler fill = new Filler();
            HumanBeing element = new HumanBeing();
            if (args.length <= 2) {
                element.setName(fill.fillName(""));
                element.setCoordinates(fill.fillCoordinates("", ""));
                element.setRealHero(fill.isHero(""));
                element.setHasToothpick(fill.tooth(""));
                element.setImpactSpeed(fill.fillSpeed(""));
                element.setWeaponType(fill.fillWeapon(""));
                element.setMood(fill.fillMood(""));
                element.setCar(fill.isCoolCar(""));
            } else {
                element.setName(fill.fillName(args[1]));
                element.setCoordinates(fill.fillCoordinates(args[2], args[3]));
                element.setRealHero(fill.isHero(args[4]));
                element.setHasToothpick(fill.tooth(args[5]));
                element.setImpactSpeed(fill.fillSpeed(args[6]));
                element.setWeaponType(fill.fillWeapon(args[7]));
                element.setMood(fill.fillMood(args[8]));
                element.setCar(fill.isCoolCar(args[9]));
            }
            element.setCoolCar(element.getCar().isCool());
            element.setxPoint(element.getCoordinates().getX());
            element.setyPoint(element.getCoordinates().getY());
            Request.element = element;
        }
    }
}
