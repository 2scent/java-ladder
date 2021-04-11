package ladder.domain;

import java.util.List;
import java.util.Objects;

public final class LadderLine {
    private static final String CONTINUOUS_ERROR_MESSAGE = "연속된 체크는 오직 2번만 가능합니다.";

    // TODO: 네이밍
    private final List<Boolean> points;

    public LadderLine(final List<Boolean> points) {
        validate(points);

        this.points = points;
    }

    private void validate(final List<Boolean> points) {
        Checkable checkable = Checkable.FREE;

        for (final boolean point : points) {
            validateContinuous(checkable, point);

            checkable = checkable.next(point);
        }
    }

    private void validateContinuous(final Checkable checkable, final boolean point) {
        if (!checkable.checkable(point)) {
            throw new IllegalArgumentException(CONTINUOUS_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
