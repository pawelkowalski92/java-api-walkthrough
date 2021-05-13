package pl.edu.utp.mutability.api;

import pl.edu.utp.mutability.model.BaseChair;
import pl.edu.utp.mutability.model.ImmutableChair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableChairSpecification implements ChairSpecification {

    @Override
    public List<BaseChair> prepareProducts(int amount, String color) {
        List<BaseChair> chairs = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            ImmutableChair chair = new ImmutableChair().withColor(color);
            chairs.add(chair);
        }
        return Collections.unmodifiableList(chairs);
    }

}
