package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호로 중복된 값은 들어올 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int findWinningNumber(List<Integer> winningNumber) {
        int count = 0;
        for (Integer winningNum : winningNumber) {
            if (this.numbers.contains(winningNum)) {
                count++;
            }
        }

        return count;
    }

    public boolean findBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
