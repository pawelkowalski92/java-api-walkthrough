package pl.edu.utp.arrays;

public class ArrayUsability {

    public static void main(String[] args) {
        // let's read the program arguments
        iterateWithForLoop(args);
        System.out.println("---");
        iterateInReverseWithWhileLoop(args);
        System.out.println("---");
        fancyReverseWhileLoop(args);
        System.out.println("---");
        iterateWithDoWhileLoop(args);

        System.out.println();
        System.out.println("Checking args with while loop");
        fancyReverseWhileLoop(new String[0]);
        /*
        System.out.println("Checking args with do-while loop");
        iterateWithDoWhileLoop(new String[0]);
        ends with exception :(
        */
        //how pre and post incrementation works?
        displayPreAndPostIncrementation();
    }

    public static void iterateWithForLoop(String[] args) {
        for (int i = 0; i < args.length; i++ /* i=i+1 */) {
            String arg = args[i];
            System.out.println("Arg nr: " + i + " = " + arg);
        }
    }

    public static void iterateInReverseWithWhileLoop(String[] args) {
        int i = args.length - 1;
        while (i >= 0) {
            String arg = args[i];
            System.out.println("Arg nr: " + i + " = " + arg);
            i--; /* i=i-1 */
        }
    }

    public static void fancyReverseWhileLoop(String[] args) {
        int i = args.length;
        while (--i >= 0) {
            System.out.println("Arg nr: " + i + " = " + args[i]);
        }
    }

    public static void iterateWithDoWhileLoop(String[] args) {
        int i = args.length - 1;
        do {
            System.out.println("Arg nr: " + i + " = " + args[i]);
        } while (--i >= 0);
    }

    public static void displayPreAndPostIncrementation() {
        int arg = 10;
        System.out.println(arg);
        System.out.println(arg++); //?1
        System.out.println(arg); //?2
        System.out.println(++arg); //?3
        System.out.println(arg); //?4
    }


}
