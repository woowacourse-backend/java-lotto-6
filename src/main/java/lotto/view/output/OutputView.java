package lotto.view.output;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public String resultPrint(Map<Rank, Integer> map) {
        List<Rank> rankList = getSortRanks(map);
        StringBuilder sb = new StringBuilder();
        for (Rank rank : rankList) {
            sb.append(rank.getComment())
                    .append(" - ")
                    .append(rank.getWinningName())
                    .append(map.get(rank))
                    .append("개")
                    .append("\n");
        }
        return sb.toString();
    }

    private static List<Rank> getSortRanks(Map<Rank, Integer> map) {
        List<Rank> rankList = map.keySet().stream()
                .sorted((o1, o2) -> o1.getWinningNumber() - o2.getWinningNumber())
                .toList();
        return rankList;
    }
}
