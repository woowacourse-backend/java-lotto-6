package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGeneratorImpl implements LottoNumberGenerator {
    @Override
    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE, Lotto.SIZE);
    }
}
