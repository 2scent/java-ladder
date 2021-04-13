package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
