package lotto.view.output;

import lotto.domain.LottoList;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void resultPrint(Map<Rank, Integer> map) {
        List<Rank> rankList = getSortRanks(map);
        StringBuilder sb = new StringBuilder();
        for (Rank rank : rankList) {
            sb.append(rank.getComment())
                    .append(" - ")
                    .append(map.getOrDefault(rank, 0))
                    .append("개")
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static List<Rank> getSortRanks(Map<Rank, Integer> map) {
        List<Rank> rankList = map.keySet().stream()
                .sorted((o1, o2) -> o1.getWinningNumber() - o2.getWinningNumber())
                .toList();
        return rankList;
    }

    public void printAllLotto(LottoList list) {
        System.out.println(list.printAllLottos());
    }
}
