package lotto.validator;

import lotto.domain.LottoRules;

import java.util.List;

public class BonusNumberValidator {

    public int validateBonusNumber(String input) {

        // 번호 개수 1개가 아닌지
        validateIsOverSize(input);
        // 공백이 있는지
        validateIsBlank(input);
        // 숫자가 아닌지
        validateIsNotDigitNumber(input);
        // String -> Integer
        int bonusNumber = changeBonusNumberType(input);
        // 번호의 숫자 범위를 벗어나는지
        validateIsOverNumberRange(bonusNumber);

        return bonusNumber;
    }

    public int validateDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        // 당첨번호에 중복 값이 없는지
        validateIsWinningNumberInBonusNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }

    private void validateIsWinningNumberInBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        for (Integer number : winningNumber) {
            if (bonusNumber == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
            }
        }
    }

    private void validateIsOverNumberRange(int bonusNumber) {
        if (bonusNumber < LottoRules.LOTTO_NUMBER_MIN.getValue() || bonusNumber > LottoRules.LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 입력 범위는 1~45를 벗어날 수 없습니다.");
        }
    }

    private void validateIsOverSize(String input) {
        if (input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 하나만 입력 할 수 있습니다.");
        }
    }

    private int changeBonusNumberType(String input) {
        return Integer.parseInt(input);
    }

    private void validateIsNotDigitNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 할 수 있습니다.");
        }
    }

    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호로 공백이나 빈값은 입력 할 수 없습니다.");
        }
    }

}
