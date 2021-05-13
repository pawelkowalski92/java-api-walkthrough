package pl.edu.utp.mutability.model;

public abstract class BaseChair {

    public enum Material {
        WOOD,
        STEEL
    }

    protected int legCount;
    protected String color;
    protected Chair.Material material;

    protected BaseChair(int legCount, String color, Material material) {
        this.legCount = legCount;
        this.color = color;
        this.material = material;
    }

    protected BaseChair(String color) {
        this(4, color, Material.WOOD);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{");
        sb.append("legCount=").append(legCount);
        sb.append(", color='").append(color).append('\'');
        sb.append(", material=").append(material);
        sb.append('}');
        return sb.toString();
    }

}
