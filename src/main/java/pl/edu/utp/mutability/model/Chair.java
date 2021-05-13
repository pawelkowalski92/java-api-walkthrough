package pl.edu.utp.mutability.model;

public class Chair extends BaseChair {

    public Chair() {
        super("brown");
    }

    public void setColor(String color) {
        super.color = color;
    }

}
