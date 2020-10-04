package main;


import com.sun.deploy.security.SelectableSecurityManager;
import human.Car;
import human.Coordinates;
import human.Mood;
import human.WeaponType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
/**
 * Класс filler (Используется для заполнения элеметов колекции)
 * @author Мишанин Никита
 */
public class Filler {
    HashSet <Long> ID;
    Scanner in = new Scanner(System.in);

    Filler() {
        //this.ID = ID;
    }

    public Long fillId(Long n) {
        if (ID.isEmpty() || !ID.contains(n)) {
            ID.add(n);
            return n;
        }
        else {
            return fillId(n + 1);
        }
    }

    public String fillName(String args) {
        String name;
        System.out.print("Введите имя персонажа: ");
        if (!args.equals(""))
            name = args;
        else
            name = in.nextLine();
        if (name.trim().length() == 0) {
            System.out.print("Вы не ввели имя. ");
            try {
                return fillName(args);
            } catch (StackOverflowError e) {
                System.out.println("Неверные данные скрипта!");
                return null;
            }
        } else {
            return name;
        }
    }

    public Coordinates fillCoordinates(String args1, String args2) {
        try {
            float x;
            System.out.println("Введите координаты");
            System.out.print("X: ");
            if (!args1.equals("") && !args2.equals(""))
                x = Float.parseFloat(args1);
            else
                x = Float.parseFloat(in.nextLine());
            if (x - 0.000001 > 717) {
                System.out.println("Ошибка! Значение превышает допустимое (717)");
                try {
                    return fillCoordinates(args1, args2);
                } catch (StackOverflowError e) {
                    System.out.println("Неверные данные скрипта!");
                }
            }
            System.out.print("");
            System.out.print("Y: ");
            int y;
            if (!args1.equals("") && !args2.equals(""))
                y = Integer.parseInt(args2);
            else
                y = Integer.parseInt(in.nextLine());
            return new Coordinates(x, y);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Недопустимые координаты.");
            try {
                return fillCoordinates(args1, args2);
            } catch (StackOverflowError e1) {
                System.out.println("Неверные данные скрипта!");
                return null;
            }
        }
    }

    public java.time.LocalDate fillDate() {
        return LocalDate.now();
    }

    public boolean isHero(String args) {
        System.out.print("Ваш персонаж реальный герой ? (Да / Нет) ");
        String ans;
        if (!args.equals(""))
            ans = args;
        else
            ans = in.nextLine();
        if (ans.equalsIgnoreCase("Да"))
            return true;
        else
        if (ans.equalsIgnoreCase("Нет"))
            return false;
        else {
            System.out.println("Вы не ответили на вопрос, используйте только допустимый ответ");
            try {
                return isHero(args);
            } catch (StackOverflowError e) {
                System.out.println("Неверные данные скрипта!");
                return false;
            }
        }
    }

    public boolean tooth(String args) {
        System.out.print("У вашего персонажа есть зубы ? (Да / Нет) ");
        String ans;
        if (!args.equals(""))
            ans = args;
        else
            ans = in.nextLine();
        if (ans.equalsIgnoreCase("Да"))
            return true;
        else
        if (ans.equalsIgnoreCase("Нет"))
            return false;
        else {
            System.out.println("Вы некорректно ввели ответ");
            try {
                return tooth(args);
            } catch (StackOverflowError e) {
                System.out.println("Неверные данные скрипта!");
                return false;
            }
        }
    }

    public Integer fillSpeed(String args) {
        System.out.print("Введите скорость: Внимание, скорость в диапазоне от -937 до 2147483647: ");
        String s;
        if (!args.equals(""))
            s = args;
        else
            s = in.nextLine();
        try {
            int speed = Integer.parseInt(s);
            if (speed < -937 || (double) speed == Double.POSITIVE_INFINITY) {
                System.out.println("Вы ввели недопустимую скорость, повторите ввод");
                try {
                    return fillSpeed(args);
                } catch (StackOverflowError e) {
                    System.out.println("Неверные данные скрипта!");
                    return null;
                }
            } else
                return speed;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимую скорость, повторите ввод");
            try {
                return fillSpeed(args);
            } catch (StackOverflowError e1) {
                System.out.println("Неверные данные скрипта!");
                return null;
            }
        }

    }

    public WeaponType fillWeapon(String args) {
        String weapon;
        System.out.print("Выберите оружие.\nСписок доуступного оружия: \n   HAMMER\n" +
                "   AXE\n" +
                "   SHOTGUN\n" +
                "   RIFLE\n" +
                "   BAT: ");
        if (!args.equals(""))
            weapon = args.toUpperCase();
        else
            weapon = in.nextLine().toUpperCase();
        //String weapon = in.nextLine().toUpperCase();
        //System.out.println(weapon + "ывывыв");
        switch (weapon) {
            case "HAMMER": return WeaponType.HAMMER;
            case "AXE": return WeaponType.AXE;
            case "SHOTGUN": return WeaponType.SHOTGUN;
            case "RIFLE": return WeaponType.RIFLE;
            case "BAT": return WeaponType.BAT;
            default:
                System.out.println("Вы не выбрали ни одного оружия, пожалуйста, повторите");
                try {
                    return fillWeapon(args);
                } catch (StackOverflowError e) {
                    System.out.println("Неверные данные скрипта!");
                    return null;
                }
        }
    }

    public Mood fillMood(String args) {
        System.out.print("Какое настроение у вашего персонажа ? \n   LONGING\n" +
                "   GLOOM\n" +
                "   CALM\n" +
                "   RAGE\n" +
                "   FRENZY: ");
        String mood;
        if (!args.equals(""))
            mood = args.toUpperCase();
        else
            mood = in.nextLine().toUpperCase();
        //String mood = in.nextLine().toUpperCase();
        switch (mood) {
            case "LONGING": return Mood.LONGING;
            case "GLOOM": return Mood.GLOOM;
            case "CALM": return Mood.CALM;
            case "RAGE": return Mood.RAGE;
            case "FRENZY": return Mood.FRENZY;
            default:
                System.out.println("Вы не выбрали настроение или ввели что-то не верно :) Пожалуйста, повторите");
                try {
                    return fillMood(args);
                } catch (StackOverflowError e) {
                    System.out.println("Неверные данные скрипта!");
                    return null;
                }
        }
    }

    public Car isCoolCar(String args) {
        System.out.print("У вашего героя крутая машина ? (Да / Нет) ");
        String ans;
        if (!args.equals(""))
            ans = args.toLowerCase();
        else
            ans = in.nextLine().toLowerCase();
        if (ans.equals("да"))
            return new Car(true);
        else
        if (ans.equals("нет"))
            return new Car(false);
        else {
            System.out.println("Вы не ответили на вопрос или ввели что-то не так, пожалуйста, повторите");
            try {
                return isCoolCar(args);
            } catch (StackOverflowError e) {
                System.out.println("Неверные данные скрипта!");
                return null;
            }
        }
    }
}
