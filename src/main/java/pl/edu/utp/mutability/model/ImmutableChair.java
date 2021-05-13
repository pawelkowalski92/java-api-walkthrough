package pl.edu.utp.mutability.model;

public class ImmutableChair extends BaseChair {

    private ImmutableChair(int legCount, String color, Material material) {
        super(legCount, color, material);
    }

    public ImmutableChair() {
        super("black");
    }

    public ImmutableChair withColor(String color) {
        return new ImmutableChair(super.legCount, color, super.material);
    }

}
