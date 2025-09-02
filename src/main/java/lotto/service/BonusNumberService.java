package lotto.service;

import lotto.domain.Error;
import lotto.domain.Lotto;

public class BonusNumberService {

    public int getBonusNumber(String number) {
        validate(number);
        return Integer.parseInt(number);
    }

    private void validate(String number) {
        String regex = "[0-9]*";
        if (number.matches(regex) == false) {
            throw new IllegalArgumentException(Error.NumberFormatError.getMessage());
        }
        int format = Integer.parseInt(number);
        if (format < Lotto.MINIMUM_NUMBER && format > Lotto.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(Error.LottoNumberError.getMessage());
        }
    }
}
