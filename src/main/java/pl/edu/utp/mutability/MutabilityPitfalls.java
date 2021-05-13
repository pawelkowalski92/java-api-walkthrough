package pl.edu.utp.mutability;

import pl.edu.utp.mutability.api.ChairSpecification;
import pl.edu.utp.mutability.api.ImmutableChairSpecification;
import pl.edu.utp.mutability.api.MutableChairSpecification;
import pl.edu.utp.mutability.model.BaseChair;
import pl.edu.utp.mutability.model.Chair;
import pl.edu.utp.mutability.model.ImmutableChair;

import java.util.List;

public class MutabilityPitfalls {

    public static void main(String[] args) {
        ChairSpecification mutable = new MutableChairSpecification();
        ChairSpecification immutable = new ImmutableChairSpecification();
        List<BaseChair> chairs = getChairs(immutable);

        System.out.println(chairs);
        System.out.println(chairs.size());

        // uh-oh; if we're using mutable specs, we can remove products! :O
        // when switching to immutable specs, removal is impossible
        // chairs.remove(0);
        BaseChair firstChair = chairs.get(0);
        if (firstChair instanceof Chair) {
            // we can modify products ! :O
            ((Chair) firstChair).setColor("white");
        }
        if (firstChair instanceof ImmutableChair) {
            ImmutableChair changedChair = ((ImmutableChair) firstChair).withColor("white");
            // replacing elements is not acceptable in immutable collection
            chairs.set(0, changedChair);
        }
        System.out.println(chairs);
        System.out.println(chairs.size());
    }

    public static List<BaseChair> getChairs(ChairSpecification specs) {
        return specs.prepareProducts(10, "red");
    }

}
