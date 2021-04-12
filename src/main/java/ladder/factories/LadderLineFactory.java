package ladder.factories;

import ladder.domain.Checkable;
import ladder.domain.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class LadderLineFactory {
    public static LadderLine create(final int count) {
        final List<Boolean> points = new ArrayList<>();

        Checkable checkable = Checkable.FREE;

        final Random random = new Random();

        for (int i = 0; i < count; i++) {
            boolean point = false;

            if (checkable == Checkable.MUST) {
                point = true;
            } else if (checkable == Checkable.NEVER) {
                point = false;
            } else if (i != count - 1 && checkable == Checkable.FREE && random.nextInt(100) < 50) {
                point = true;
            }

            points.add(point);

            checkable = checkable.next(point);
        }

        System.out.println(points);

        return new LadderLine(points);
    }
}
