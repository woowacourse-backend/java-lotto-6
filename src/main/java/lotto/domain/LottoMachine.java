package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> issueLotto(int amount) {
        int count = amount / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateRandomNumber();
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
