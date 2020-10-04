package human;

import java.io.Serializable;

public enum Mood implements Serializable {
    LONGING("LONGING"),
    GLOOM("GLOOM"),
    CALM("CALM"),
    RAGE("RAGE"),
    FRENZY("FRENZY");
    public final String mood;
    Mood (String mood) {
        this.mood = mood;
    }
    public String getMood() {
        return mood;
    }
}
