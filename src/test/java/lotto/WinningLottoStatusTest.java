package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.model.WinningLottoStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoStatusTest {

    public static Stream<Map<String, Object>> provideWinningLottoAndLottoAndStatus() {
        return Stream.of(
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        "WinningLottoStatus", WinningLottoStatus.FIRST),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        "WinningLottoStatus", WinningLottoStatus.SECOND),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                        "WinningLottoStatus", WinningLottoStatus.THIRD),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                        "WinningLottoStatus", WinningLottoStatus.FOURTH),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 43, 44, 45)),
                        "WinningLottoStatus", WinningLottoStatus.FIFTH)
        );
    }

    @ParameterizedTest
    @DisplayName("getWinningLottoStatus: 당첨 등수를 리턴한다.")
    @MethodSource("provideWinningLottoAndLottoAndStatus")
    void getWinningLottoStatus(Map<String, Object> args) {
        WinningLotto winningLotto = (WinningLotto) args.get("WinningLotto");
        Lotto lotto = (Lotto) args.get("Lotto");
        WinningLottoStatus winningLottoStatus = (WinningLottoStatus) args.get("WinningLottoStatus");

        assertThat(WinningLottoStatus.getWinningLottoStatus(winningLotto, lotto))
                .isEqualTo(winningLottoStatus);
    }
}