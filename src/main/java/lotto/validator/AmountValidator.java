package lotto.validator;

public class AmountValidator {

    public int validateAmount(String input) {
        // 공백이나 빈값인지 검증
        validateEmptyNumber(input);
        // 숫자인지 검증
        int amount = validateNumber(input);

        // 양수인지 검증
        validateNegativeNumber(amount);
        // 1000원 단위로 나누어 떨어지는지 검증
        validateNumberUnit(amount);

        return amount;
    }

    private void validateEmptyNumber(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 공백이나 빈값은 입력할 수 없습니다.");
        }
    }

    private int validateNumber(String input) {
        boolean result = input.matches("-?[0-9]+");
        if (!result) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 문자는 입력할 수 없습니다.");
        }

        return Integer.parseInt(input);
    }

    private void validateNegativeNumber(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수값은 입력할 수 없습니다.");
        }
    }

    private void validateNumberUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야합니다.");
        }
    }
}
