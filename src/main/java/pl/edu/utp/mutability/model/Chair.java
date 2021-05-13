package pl.edu.utp.mutability.model;

public class Chair {

    public enum Material {
        WOOD,
        STEEL
    }

    private int legCount;
    private String color;
    private Material material;

    public Chair(String color) {
        this.legCount = 4;
        this.color = color;
        this.material = Material.WOOD;
    }

    public Chair() {
        this("brown");
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chair{");
        sb.append("legCount=").append(legCount);
        sb.append(", color='").append(color).append('\'');
        sb.append(", material=").append(material);
        sb.append('}');
        return sb.toString();
    }
}
