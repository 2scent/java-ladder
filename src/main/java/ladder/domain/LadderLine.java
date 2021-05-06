package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private static final int MIN_WIDTH = 2;
    private static final String MIN_WIDTH_ERROR_MESSAGE = String.format("width는 %d보다 커야 합니다.", MIN_WIDTH);
    private static final String WRONG_INDEX_ERROR_MESSAGE = "잘못된 인덱스입니다.";

    private final List<Point> points;

    public LadderLine(final List<Point> points) {
        this.points = points;
    }

    public static LadderLine from(final int width) {
        return from(width, HalfRandomDirectionDeterminer.getInstance());
    }

    public static LadderLine from(final int width, final DirectionDeterminer directionDeterminer) {
        validateMinWidth(width);

        final List<Point> points = new ArrayList<>();

        Point point = initFirst(points, directionDeterminer);
        point = initBody(width, points, point, directionDeterminer);
        initLast(points, point);

        return new LadderLine(points);
    }

    private static void validateMinWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException(MIN_WIDTH_ERROR_MESSAGE);
        }
    }

    private static Point initFirst(List<Point> points, DirectionDeterminer directionDeterminer) {
        final Point point = Point.first(directionDeterminer);
        points.add(point);
        return point;
    }

    private static Point initBody(int width, List<Point> points, Point point, DirectionDeterminer directionDeterminer) {
        for (int i = 1; i < width - 1; i++) {
            point = point.next(directionDeterminer);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        points.add(point.last());
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }

    public int move(final int index) {
        return points.stream()
                .filter(point -> point.current(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_INDEX_ERROR_MESSAGE))
                .move();
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
