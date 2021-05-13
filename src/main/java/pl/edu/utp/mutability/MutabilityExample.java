package pl.edu.utp.mutability;

import pl.edu.utp.mutability.model.Chair;
import pl.edu.utp.mutability.model.ImmutableChair;

public class MutabilityExample {

    public static void main(String[] args) {
        Chair chair = new Chair();
        System.out.println(chair);

        // change color of our chair
        changeChairColor(chair);
        System.out.println(chair);

        changeChairColorByRef(chair);
        System.out.println(chair);

        ImmutableChair immutableChair = new ImmutableChair();
        System.out.println(immutableChair);

        // we're creating new object with changed color; in order to keep it, we need to overwrite reference
        immutableChair = changeChairColor(immutableChair);
        System.out.println(immutableChair);

        // String is a good example of immutable object
        String color = "yellow";
        System.out.println(color);
        // method chaining - simpler way to execute chain of commands
        color = color.toUpperCase()
                .indent(2)
                .replace('Y', 'H')
                .replace('W', '!');
        /*
        equivalent to:
        color = color.toUpperCase();
        color = color.indent(2);
        color = color.replace('Y', 'H');
        color = color.replace('W', '!')
         */
        System.out.println(color);

        StringBuilder colorBuilder = new StringBuilder("yellow");
        System.out.println(colorBuilder);
        colorBuilder.replace(0, 1, "H");
        colorBuilder.replace(colorBuilder.length() - 1, colorBuilder.length(), "!");
        System.out.println(colorBuilder);
    }

    public static void changeChairColor(Chair chair) {
        chair.setColor("yellow");
    }

    public static ImmutableChair changeChairColor(ImmutableChair immutableChair) {
        return immutableChair.withColor("yellow");
    }

    public static void changeChairColorByRef(Chair chair) {
        chair = new Chair();
    }

}
