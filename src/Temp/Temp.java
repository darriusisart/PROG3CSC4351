package Temp;

public class Temp {
    private static int count = 0;
    private int num;

    public Temp() {
        num = count++;
    }

    public String toString() {
        return "t" + num;
    }

    public static Label namedLabel(String name) {
        return new Label(name);
    }
} 