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
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(LottoErrorStatus.INVALID_RANGE.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(LottoErrorStatus.INVALID_SIZE.getMessage());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int containsCounts(Lotto otherLotto) {
        int count = 0;
        for (Integer otherNumber : otherLotto.numbers) {
            if (contains(otherNumber)) {
                count++;
            }
        }
        return count;
    }
}
