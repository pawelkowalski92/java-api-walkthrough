package pl.edu.utp.arrays.models;

public class Table {

    public static enum Material {
        WOOD,
        GLASS,
        STEEL
    }

    private Material material;

    public Table(Material material) {
        this.material = material;
    }

    public Table() {
        this(Material.WOOD);
    }


}
