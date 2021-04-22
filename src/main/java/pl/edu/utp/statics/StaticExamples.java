package pl.edu.utp.statics;

import pl.edu.utp.arrays.models.Table;
import pl.edu.utp.statics.model.MyObject;

public class StaticExamples {

    public static void main(String[] args) {

        Table t1 = new Table(Table.Material.WOOD);
        System.out.println("My wooden table weights: " + t1.getWeight() + " kg");

        Table t2 = new Table(Table.Material.STEEL);
        System.out.println("My steel table weights: " + t2.getWeight() + " kg");

        // getWeight() can be accessed only from instance (non-static context)
        // t2.getWeight()
        // it's illegal to invoke this method like below:
        // Table.getWeight()

        // Material enum is bound to the Table CLASS, not OBJECT INSTANCE
        Table.Material material = Table.Material.STEEL;

        // even such expression is illegal
        // t2.Material.STEEL;

        MyObject a = new MyObject("a");
        MyObject b = new MyObject("b");

        // access static member only via class
        System.out.println(MyObject.getCounter());
        /* it's discouraged to reference static members via object instances
        System.out.println(a.counter);
        System.out.println(b.counter);
         */

    }

    // factory method for table
    public static Table createTable(String material) {
        switch (material) {
            case "GLASS":
                return new Table(Table.Material.GLASS);
            default:
                return new Table(Table.Material.WOOD);
        }
    }

}
