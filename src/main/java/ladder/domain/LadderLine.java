package ladder.domain;

import java.util.List;
import java.util.Objects;

public final class LadderLine {
    private final List<Boolean> points;

    public LadderLine(final List<Boolean> points) {
        validate(points);

        this.points = points;
    }

    private void validate(final List<Boolean> points) {
        // 0 -> true, false 가능
        // 1 -> true만 가능
        // 2 -> false만 가능

        int status = 0;

        for (boolean point : points) {
            switch (status) {
                case 1:
                    if (!point) {
                        throw new IllegalArgumentException();
                    }
                    status = 2;
                    break;
                case 2:
                    if (point) {
                        throw new IllegalArgumentException();
                    }
                    status = 0;
                    break;
                default:
                    if (point) {
                        status = 1;
                    }
            }
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
