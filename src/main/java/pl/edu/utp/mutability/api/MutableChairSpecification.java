package pl.edu.utp.mutability.api;

import pl.edu.utp.mutability.model.BaseChair;
import pl.edu.utp.mutability.model.Chair;

import java.util.ArrayList;
import java.util.List;

public class MutableChairSpecification implements ChairSpecification {

    @Override
    public List<BaseChair> prepareProducts(int amount, String color) {
        List<BaseChair> chairs = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Chair chair = new Chair();
            chair.setColor(color);
            chairs.add(chair);
        }
        return chairs;
    }

}
