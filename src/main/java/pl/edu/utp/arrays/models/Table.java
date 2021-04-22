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

    public double getWeight() {
        String materialName = material.name();
        double weight = 0;
        for (char c : materialName.toCharArray()) {
            weight += c;
        }
        return weight;
    }


}
