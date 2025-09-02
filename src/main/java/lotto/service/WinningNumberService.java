package lotto.service;

import lotto.domain.Error;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumberService {

    public Lotto getWinningNumber(String numbers) {
        List<Integer> numberList = format(numbers);
        return new Lotto(numberList);
    }

    public List<Integer> format(String numbers) {
        String[] numberArray = numbers.split(",");
        try {
            List<Integer> list = Arrays.stream(numberArray)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            return list;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NumberFormatError.getMessage());
        }
    }
}
