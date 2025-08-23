package lotto.domain;

import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> lottoList;

    public PurchasedLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void printAll() {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}
