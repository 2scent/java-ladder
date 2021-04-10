package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    public void create() {
        final List<Boolean> points = Arrays.asList(true, true, false, true, true);

        assertThat(new LadderLine(points)).isEqualTo(new LadderLine(points));
    }


    @Test
    public void create_when_trueIsNotContinuous() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Boolean> points = Arrays.asList(true, false, true, false, true);

            new LadderLine(points);
        });
    }

    @Test
    public void create_when_trueIsContinuousMoreThan2() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Boolean> points = Arrays.asList(true, true, true, true, true);

            new LadderLine(points);
        });
    }
}
