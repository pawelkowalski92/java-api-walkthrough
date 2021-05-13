package pl.edu.utp.mutability;

import pl.edu.utp.mutability.model.Chair;

public class MutabilityExample {

    public static void main(String[] args) {
        Chair chair = new Chair();
        System.out.println(chair);

        // change color of our chair
        changeChairColor(chair);
        System.out.println(chair);

        changeChairColorByRef(chair);
        System.out.println(chair);
    }

    public static void changeChairColor(Chair chair) {
        chair.setColor("yellow");
    }

    public static void changeChairColorByRef(Chair chair) {
        chair = new Chair("green");
    }

}
