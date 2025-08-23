package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    private static final int LOTTO_SIZE = 6;

    public List<Integer> validateWinningNumber(String input) {
        List<String> inputNumber = Arrays.stream(input.split(","))
                .map(String::trim).collect(Collectors.toList());

        // 공백이나 빈 값을 입력 받을 경우
        validateIsBlank(inputNumber);

        // 숫자가 아닌 문자를 입력 받을 경우
        validateIsNotNumber(inputNumber);

        // int형으로 만들기
        List<Integer> winningNumber = changInputNumberType(inputNumber);

        // 입력 숫자 범위 1~45 벗어 날 경우
        validateOverRange(winningNumber);

        // 중복된 숫자를 입력 받을 경우
        validateDuplicate(winningNumber);

        // 입력받은 번호의 개수가 6개가 아닌 경우
        validateOverSize(winningNumber);

        return winningNumber;
    }

    private void validateOverSize(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> winningNumber) {
        HashSet<Integer> noDuplicateNumber = new HashSet<>(winningNumber);
        if (noDuplicateNumber.size() != winningNumber.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호로 중복된 숫자는 입력 받을 수 없습니다.");
        }
    }

    private void validateIsBlank(List<String> inputNumber) {
        for (String number : inputNumber) {
            if (number.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호로 공백이나 빈값은 입력할 수 없습니다.");
            }
        }
    }

    private List<Integer> changInputNumberType(List<String> inputNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : inputNumber) {
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    private void validateIsNotNumber(List<String> inputNumber) {
        for (String string : inputNumber) {
            try {
                Integer.parseInt(string);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자는 입력 할 수 없습니다.");
            }
        }
    }

    private void validateOverRange(List<Integer> winningNumber) {
        for (Integer number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 입력받은 숫자 범위가 1~45를 넘어 갈 수 없습니다.");
            }
        }
    }
}
