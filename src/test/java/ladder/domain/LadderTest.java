package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {
    @Test
    public void create() {
        final int width = 5;

        final List<LadderLine> ladderLines = Arrays.asList(
                LadderLine.from(width),
                LadderLine.from(width),
                LadderLine.from(width),
                LadderLine.from(width)
        );

        assertThatCode(() -> new Ladder(ladderLines))
                .doesNotThrowAnyException();
    }

    @Test
    public void ladderResults() {
        final Person pobi = new Person("pobi");
        final Person honux = new Person("honux");
        final Person crong = new Person("crong");
        final Person jk = new Person("jk");

        final Prize blank = new Prize("꽝");
        final Prize threeThousand = new Prize("3000");
        final Prize fiveThousand = new Prize("5000");

        final List<LadderLine> ladderLines = Arrays.asList(
                firstLine(),
                secondLine(),
                thirdLine(),
                fourthLine(),
                fifthLine()
        );

        final Ladder ladder = new Ladder(ladderLines);

        final People people = new People(Arrays.asList(pobi, honux, crong, jk));
        final Prizes prizes = new Prizes(Arrays.asList(blank, fiveThousand, blank, threeThousand));

        final LadderResults expected = new LadderResults(Arrays.asList(
                new LadderResult(pobi, blank),
                new LadderResult(honux, threeThousand),
                new LadderResult(crong, blank),
                new LadderResult(jk, fiveThousand)
        ));

        final LadderResults actual = ladder.ladderResults(people, prizes);

        assertThat(actual).isEqualTo(expected);
    }

    private LadderLine firstLine() {
        return new LadderLine(Arrays.asList(
                new Point(0, Direction.RIGHT),
                new Point(1, Direction.LEFT),
                new Point(2, Direction.RIGHT),
                new Point(3, Direction.LEFT)
        ));
    }

    private LadderLine secondLine() {
        return new LadderLine(Arrays.asList(
                new Point(0, Direction.NONE),
                new Point(1, Direction.RIGHT),
                new Point(2, Direction.LEFT),
                new Point(3, Direction.NONE)
        ));
    }

    private LadderLine thirdLine() {
        return new LadderLine(Arrays.asList(
                new Point(0, Direction.RIGHT),
                new Point(1, Direction.LEFT),
                new Point(2, Direction.NONE),
                new Point(3, Direction.NONE)
        ));
    }

    private LadderLine fourthLine() {
        return new LadderLine(Arrays.asList(
                new Point(0, Direction.NONE),
                new Point(1, Direction.RIGHT),
                new Point(2, Direction.LEFT),
                new Point(3, Direction.NONE)
        ));
    }

    private LadderLine fifthLine() {
        return new LadderLine(Arrays.asList(
                new Point(0, Direction.RIGHT),
                new Point(1, Direction.LEFT),
                new Point(2, Direction.RIGHT),
                new Point(3, Direction.LEFT)
        ));
    }
}
