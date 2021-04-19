package pl.edu.utp.arrays;

import pl.edu.utp.arrays.models.Table;

public class ArrayDeclaration {

    public static void main(String[] args) {
        int singular = 0;

        // array declaration
        int[] arrayOfInts;
        int[][] doubleArray;
        int[][][] tripleArray;
        // ... etc;

        /*
        brackets in array declaration may have multiple locations
        e.g.
        int [][] test[];
        int test[][][];
        int [] test[][];
        (same 3-dimensional array)
         */

        /*
        String a = "a", b = "b", c = "c";
        int[] arrA[] = new int[1][1], arrB = new int[0];
        */

        // array initialization
        // statically by elements
        arrayOfInts = new int[]{2, 3, 4, 5, 6}; // new int[5];
        doubleArray = new int[][]{ // new int[3][4];
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        // by size
        tripleArray = new int[10][2][5];

        doubleArray = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7},
                {8, 9, 10, 11, 12},
                arrayOfInts
        };

        Table[] myTables = {
                new Table(),
                new Table(Table.Material.GLASS),
                new Table(Table.Material.STEEL)
        };

        Object[] myGarbage = {
                new Table(),
                "LABEL",
                new Object(),
                singular // legal due to wrapper types (Integer)
        };

    }

}
