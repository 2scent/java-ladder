package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
