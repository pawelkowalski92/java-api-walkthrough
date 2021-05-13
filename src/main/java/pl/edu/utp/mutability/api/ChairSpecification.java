package pl.edu.utp.mutability.api;

import pl.edu.utp.mutability.model.BaseChair;

import java.util.List;

public interface ChairSpecification {

    List<BaseChair> prepareProducts(int amount, String color);

}
