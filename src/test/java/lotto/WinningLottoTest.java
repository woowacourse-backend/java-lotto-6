package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("matchBonusNumber(): 보너스볼 매치 여부를 리턴한다")
    void matchBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(7,8,9,10,11,12));

        assertThat(winningLotto.matchBonusNumber(lotto))
                .isTrue();
    }
}