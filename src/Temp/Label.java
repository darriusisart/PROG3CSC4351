package Temp;

public class Label {
    private String name;
    private static int count = 0;

    public Label(String n) {
        name = n;
    }

    public Label() {
        name = "L" + count++;
    }

    public String toString() {
        return name;
    }
} 