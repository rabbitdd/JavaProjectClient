package human;

import java.io.Serializable;

public enum WeaponType implements Serializable {
    HAMMER("HAMMER"),
    AXE("AXE"),
    SHOTGUN("SHOTGUN"),
    RIFLE("RIFLE"),
    BAT("BAT");
    public final String weapon;
    WeaponType (String weapon) {
        this.weapon = weapon;
    }
    public String getWeapon() {
        return weapon;
    }
}
