package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class HumanBeing implements Serializable, Comparable<HumanBeing>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private Boolean hasToothpick; //Поле не может быть null
    private Integer impactSpeed; //Значение поля должно быть больше -937, Поле не может быть null
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле не может быть null
    private Car car; //Поле не может быть null
    private float x;

    public float getxPoint() {
        return x;
    }

    public void setxPoint(float xPoint) {
        x = xPoint;
    }

    public Integer getyPoint() {
        return yPoint;
    }

    public void setyPoint(Integer yPoint) {
        this.yPoint = yPoint;
    }

    private Integer yPoint;
    public boolean isCoolCar() {
        return CoolCar;
    }

    public void setCoolCar(boolean coolCar) {
        CoolCar = coolCar;
    }

    private boolean CoolCar;
    /*HumanBeing(Long id, String name, Coordinates coordinates, java.time.LocalDate creationDate, boolean realHero, Boolean hasToothpick,
               Integer impactSpeed, WeaponType weaponType, Mood mood, Car car){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isRealHero() {
        return realHero;
    }

    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public Integer getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(Integer impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public String  getWeaponType() {
        return weaponType.getWeapon();
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public String getMood() {
        return mood.getMood();
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public int compareTo(HumanBeing o) {
        return name.compareTo(o.getName());
    }
}
