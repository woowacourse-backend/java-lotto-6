package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AmountValidatorTest {

    @DisplayName("로또 구입금액이 문자가 입력되면 예외를 발생한다.")
    @Test
    void inputNotNumber() {
        assertThatThrownBy(() -> new AmountValidator().validateAmount("abs"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 음수가 입력되면 예외를 발생한다.")
    @Test
    void inputNegativeAmount() {
        assertThatThrownBy(() -> new AmountValidator().validateAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 공백이나 빈값이 입력되면 예외를 발생한다.")
    @Test
    void inputIsEmptyNumber() {
        assertThatThrownBy(() -> new AmountValidator().validateAmount("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 1,000원 단위로 나누어떨어지지 않는 값이 입력되면 예외를 발생한다.")
    @Test
    void notCorrectAmountUnit() {
        assertThatThrownBy(() ->new AmountValidator().validateAmount("1234567"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액을 입력하면 정상 처리된다.")
    @Test
    void correctInput() {
        assertDoesNotThrow(() -> new AmountValidator().validateAmount("3000"));
    }
}
