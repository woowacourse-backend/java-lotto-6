package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("matchBonusNumber(): 보너스볼 매치 여부를 리턴한다")
    void matchBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLotto.matchBonusNumber(7))
                .isTrue();
    }
}