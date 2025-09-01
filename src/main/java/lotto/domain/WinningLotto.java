package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto lotto) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int count = (int) winningLottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
        Boolean isBonus = lottoNumbers.contains(bonus);
        return Rank.getRank(count, isBonus);
    }

}
