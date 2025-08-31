package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    public static Stream<List<Object>> provideLottoListAndContains() {
        int min = Lotto.MAX_VALUE;
        int max = Lotto.MIN_VALUE;
        int size = Lotto.SIZE;

        List<List<Object>> twoLottoAndContains = new ArrayList<>();

        Lotto lotto = getLotto(max, size, min, 0);
        for (int i = 0; i < Lotto.SIZE; i++) {
            Lotto other = getLotto(max, i, min, size - i);
            twoLottoAndContains.add(List.of(lotto, other, i));
        }

        return twoLottoAndContains.stream();
    }

    private static Lotto getLotto(int minValue, int minValueCount, int maxValue, int maxValueCount) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < minValueCount; i++) {
            int value = minValue + i;
            numbers.add(value);
        }
        for (int i = 0; i < maxValueCount; i++) {
            int value = maxValue - i;
            numbers.add(value);
        }
        return new Lotto(numbers);
    }

    @ParameterizedTest
    @DisplayName("contains(Lotto) : 보유한 숫자의 개수를 리턴한다")
    @MethodSource("provideLottoListAndContains")
    void contains(List<Object> lottoListAndContains) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(other))
                .isEqualTo(6);
    }

    @Nested
    @DisplayName("new Lotto(List<Integer>): ")
    class Create {

        public static Stream<List<Integer>> provideInvalidSizeNumbers() {
            return Stream.of(
                    List.of(1, 2, 3, 4, 5),
                    List.of(1, 2, 3, 4, 5, 6, 7)
            );
        }

        public static Stream<List<Integer>> privateInvalidRangeNumbers() {
            return Stream.of(
                    List.of(1, 2, 3, 4, 5, Lotto.MIN_VALUE - 1),
                    List.of(1, 2, 3, 4, 5, Lotto.MAX_VALUE + 1)
            );
        }

        @ParameterizedTest
        @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
        @MethodSource("provideInvalidSizeNumbers")
        void invalidSize(List<Integer> numbers) {
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorStatus.INVALID_SIZE.getMessage());
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void duplicatedNumber() {
            // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorStatus.DUPLICATE.getMessage());
        }

        @ParameterizedTest
        @DisplayName("로또 번호의 범위에 맞지 않으면 예외가 발생한다.")
        @MethodSource("privateInvalidRangeNumbers")
        void invalidRange(List<Integer> numbers) {
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoErrorStatus.INVALID_RANGE.getMessage());
        }
    }
}