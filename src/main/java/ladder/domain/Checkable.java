package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// TODO: 네이밍
public enum Checkable {
    FREE(point -> true, point -> point),
    MUST(point -> point, point -> true),
    NEVER(point -> !point, point -> true);

    private final Predicate<Boolean> checkable;
    private final Predicate<Boolean> shouldNext;

    Checkable(final Predicate<Boolean> checkable, final Predicate<Boolean> shouldNext) {
        this.checkable = checkable;
        this.shouldNext = shouldNext;
    }

    public boolean checkable(final boolean point) {
        return checkable.test(point);
    }

    public Checkable next(final boolean point) {
        if (!shouldNext(point)) {
            return this;
        }

        final List<Checkable> checkableList = Arrays.asList(values());

        final int currentIndex = checkableList.indexOf(this);
        final int nextIndex = currentIndex + 1;

        if (nextIndex == checkableList.size()) {
            return FREE;
        }

        return checkableList.get(nextIndex);
    }

    private boolean shouldNext(final boolean point) {
        return shouldNext.test(point);
    }
}
