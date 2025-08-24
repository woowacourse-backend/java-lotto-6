package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningStatisticsTest {
    private LottoWinningStatistics lottoWinningStatistics;

    @BeforeEach
    void setUp() {
        lottoWinningStatistics = new LottoWinningStatistics();
    }

    @DisplayName("6개 일치, 1등을 반환한다.")
    @Test
    void determineRankFirst() {

        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> lottoList = List.of(lotto);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoWinningStatistics.lottoStatistics(lottoList, winningNumber, bonusNumber);
        Map<Rank, Integer> result = lottoWinningStatistics.getStatistics();

        assertThat(result.get(Rank.FIRST_PLACE)).isEqualTo(1);
    }

    @DisplayName("5개 일치, 보너스번호 일치, 2등을 반환한다.")
    @Test
    void determineRankSecond() {

        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));
        List<Lotto> lottoList = List.of(lotto);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoWinningStatistics.lottoStatistics(lottoList, winningNumber, bonusNumber);
        Map<Rank, Integer> result = lottoWinningStatistics.getStatistics();

        assertThat(result.get(Rank.SECOND_PLACE)).isEqualTo(1);
    }

    @DisplayName("5개 일치, 3등을 반환한다.")
    @Test
    void determineRankThird() {

        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 10)));
        List<Lotto> lottoList = List.of(lotto);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoWinningStatistics.lottoStatistics(lottoList, winningNumber, bonusNumber);
        Map<Rank, Integer> result = lottoWinningStatistics.getStatistics();

        assertThat(result.get(Rank.THIRD_PLACE)).isEqualTo(1);
    }

    @DisplayName("4개 일치, 4등을 반환한다.")
    @Test
    void determineRankFOURTH() {

        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 10, 11)));
        List<Lotto> lottoList = List.of(lotto);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoWinningStatistics.lottoStatistics(lottoList, winningNumber, bonusNumber);
        Map<Rank, Integer> result = lottoWinningStatistics.getStatistics();

        assertThat(result.get(Rank.FOURTH_PLACE)).isEqualTo(1);
    }

    @DisplayName("4개 일치, 4등을 반환한다.")
    @Test
    void determineRankFIFTH() {

        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12)));
        List<Lotto> lottoList = List.of(lotto);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoWinningStatistics.lottoStatistics(lottoList, winningNumber, bonusNumber);
        Map<Rank, Integer> result = lottoWinningStatistics.getStatistics();

        assertThat(result.get(Rank.FIFTH_PLACE)).isEqualTo(1);
    }
}
