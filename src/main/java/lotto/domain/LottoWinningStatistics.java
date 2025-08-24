package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {

    private final Map<Rank, Integer> statistics;

    public LottoWinningStatistics() {
        this.statistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.FAIL) {
                statistics.put(rank, 0);
            }
        }
    }

    public void lottoStatistics(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            Rank rank = hitLotto(lotto, winningNumber, bonusNumber);
            if (rank != Rank.FAIL) {
                recordRank(rank);
            }
        }
    }

    private void recordRank(Rank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    private Rank hitLotto(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = lotto.findWinningNumber(winningNumber);
        boolean hasBonus = lotto.findBonusNumber(bonusNumber);

        if (matchCount == 3) {
            return Rank.FIFTH_PLACE;
        }
        if (matchCount == 4) {
            return Rank.FOURTH_PLACE;
        }
        if (matchCount == 5 && hasBonus) {
            return Rank.SECOND_PLACE;
        }
        if (matchCount == 5) {
            return Rank.THIRD_PLACE;
        }
        if (matchCount == 6) {
            return Rank.FIRST_PLACE;
        }

        return Rank.FAIL;
    }

    public Map<Rank, Integer> getStatistics() {
        return new EnumMap<>(statistics);
    }
}
