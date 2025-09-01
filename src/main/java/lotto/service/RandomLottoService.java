package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoList;

import java.util.List;

public class RandomLottoService {

    public static final int MINIMUM = 1;
    public static final int MAX = 45;
    public static final int SIZE = 6;

    public Lotto getRandomLotto() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(MINIMUM, MAX, SIZE);
        return new Lotto(list);
    }

    public LottoList opportunityLotto(int opportunity) {
        LottoList list = new LottoList();
        for (int i = 0; i < opportunity; i++) {
            Lotto lotto = getRandomLotto();
            list.add(lotto);
        }
        return list;
    }
}
