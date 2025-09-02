package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoList {

    private List<Lotto> lottos;

    public LottoList() {
        lottos = new ArrayList<>();
    }
    public void add (Lotto lotto) {
        lottos.add(lotto);
    }


    public Map<Rank, Integer> resultWinningLottos(WinningLotto winningLotto) {
        Map<Rank, Integer> result = initialMap();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            if (rank.getWinningNumber() == 0) continue;
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private Map<Rank, Integer> initialMap() {
        Map<Rank, Integer> map = new HashMap<>();
        for (Rank rank : Rank.values()) {
            map.put(rank, 0);
        }
        map.remove(Rank.Correct_Not);
        return map;
    }

    public String printAllLottos() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            String lottoString = lotto.printLotto();
            sb.append(lottoString).append("\n");
        }
        return sb.toString();
    }

}
