package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberValidatorTest {

    @DisplayName("공백이나 빈 값을 입력 받을 경우 예외를 발생한다.")
    @Test
    void isBlankWinningNumber() {
        assertThatThrownBy(() -> new WinningNumberValidator().validateWinningNumber(" ,,  , 2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자를 입력 받을 경우 예외를 발생한다.")
    @Test
    void isNotDigitNumber() {
        assertThatThrownBy(() -> new WinningNumberValidator().validateWinningNumber("a, b, c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자 범위 1~45 벗어날 경우 예외를 발생한다.")
    @Test
    void isOverNumberRange() {
        assertThatThrownBy(() -> new WinningNumberValidator().validateWinningNumber("0, 50, 200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자를 입력 받을 경우")
    @Test
    void isIncludeDuplicateNumber() {
        assertThatThrownBy(() -> new WinningNumberValidator().validateWinningNumber("1, 2, 3, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 입력받은 번호의 개수가 6개가 아닌 경우
    //validateOverSize(winningNumber);
    @DisplayName("입력받은 번호의 개수가 6개가 아닌 경우")
    @Test
    void isOverNumberSize() {
        assertThatThrownBy(() -> new WinningNumberValidator().validateWinningNumber("1, 2, 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
