package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    public static Stream<Map<String, Object>> provideWinningLottoAndLottoAndStatus() {
        return Stream.of(
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        "WinningLottoStatus", LottoRank.FIRST),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        "WinningLottoStatus", LottoRank.SECOND),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                        "WinningLottoStatus", LottoRank.THIRD),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                        "WinningLottoStatus", LottoRank.FOURTH),
                Map.of(
                        "WinningLotto", new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        "Lotto", new Lotto(List.of(1, 2, 3, 43, 44, 45)),
                        "WinningLottoStatus", LottoRank.FIFTH)
        );
    }

    @ParameterizedTest
    @DisplayName("getWinningLottoStatus: 당첨 등수를 리턴한다.")
    @MethodSource("provideWinningLottoAndLottoAndStatus")
    void getResult(Map<String, Object> args) {
        WinningLotto winningLotto = (WinningLotto) args.get("WinningLotto");
        Lotto lotto = (Lotto) args.get("Lotto");
        LottoRank lottoRank = (LottoRank) args.get("WinningLottoStatus");

        assertThat(LottoRank.valueOf(winningLotto.matchCount(lotto), winningLotto.matchBonus(lotto)))
                .isEqualTo(lottoRank);
    }
}