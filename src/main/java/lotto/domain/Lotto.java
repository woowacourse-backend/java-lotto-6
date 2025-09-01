package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;


    public Lotto(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>(numbers);
        isBoundary(list);
        isDuplicate(list);
        list.sort(Comparator.naturalOrder());
        this.numbers = list;

    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void isBoundary(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.LottoSizeError.getMessage());
        }
        for (int number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(Error.LottoNumberError.getMessage());
            }
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            int count = (int)numbers.stream()
                    .filter(n -> n == number)
                    .count();
            if (count > 1) {
                throw new IllegalArgumentException(Error.LottoDuplicateNumber.getMessage());
            }
        }
    }

    public String printLotto() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        numbers.forEach(number -> sb.append(number).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
