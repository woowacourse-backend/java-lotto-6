package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        super(lotto);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber);
    }

    private void validateRange(Integer bonusNumber) {
        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException(LottoErrorStatus.INVALID_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    private void validateDuplicate(Integer bonusNumber) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorStatus.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
