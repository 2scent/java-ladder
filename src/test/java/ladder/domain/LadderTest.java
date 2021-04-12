package ladder.domain;

import ladder.factories.LadderLineFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void create() {
        final List<LadderLine> ladderLines = Arrays.asList(
                new LadderLine(Arrays.asList(true, true, false, true, true)),
                new LadderLine(Arrays.asList(true, true, false, true, true)),
                new LadderLine(Arrays.asList(true, true, false, true, true)),
                new LadderLine(Arrays.asList(true, true, false, true, true))
        );

        LadderLineFactory.create(10);

        assertThat(new Ladder(ladderLines)).isEqualTo(new Ladder(ladderLines));
    }
}
