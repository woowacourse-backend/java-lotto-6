package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberValidatorTest {

    @DisplayName("번호가 1개가 아니면 예외를 발생한다.")
    @Test
    void isOverSize() {
        String bonusNumber = "1, 2";

        assertThatThrownBy(() -> new BonusNumberValidator().validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백이나 빈값이라면 예외를 발생한다.")
    @Test
    void isBlankNumber() {
        String bonusNumber = " ";

        assertThatThrownBy(() -> new BonusNumberValidator().validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자라면 예외를 발생한다.")
    @Test
    void isNotDigitNumber() {
        String bonusNumber = "abc";

        assertThatThrownBy(()-> new BonusNumberValidator().validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 번호의 숫자 범위를 벗어나는지
    //validateIsOverNumberRange(bonusNumber);
    @DisplayName("보너스 번호가 1~45의 범위가 아니라면 예외를 발생한다.")
    @Test
    void isOverNumberRange() {

        assertThatThrownBy(()->new BonusNumberValidator().validateBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->new BonusNumberValidator().validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 같은 값이 있다면 예외를 발생한다.")
    @Test
    void isIncludeWinningNumber() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        assertThatThrownBy(()->new BonusNumberValidator().validateDuplicateBonusNumber(bonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 보너스 번호가 입력된다면 예외를 발생하지 않는다.")
    @Test
    void correctBonusNumber() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "7";

        int validatedBonusNumber = assertDoesNotThrow(()-> new BonusNumberValidator().validateBonusNumber(bonusNumber));
        assertDoesNotThrow(() -> new BonusNumberValidator().validateDuplicateBonusNumber(validatedBonusNumber, winningNumber));
    }

}
