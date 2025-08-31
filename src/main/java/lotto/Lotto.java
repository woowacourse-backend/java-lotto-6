package lotto;

import java.util.List;

public class Lotto {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .toList()
                .size() != SIZE) {
            throw new IllegalArgumentException(LottoErrorStatus.DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number ->
                        number > MAX_VALUE || number < MIN_VALUE)) {
            throw new IllegalArgumentException(LottoErrorStatus.INVALID_RANGE.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(LottoErrorStatus.INVALID_SIZE.getMessage());
        }
    }
}
