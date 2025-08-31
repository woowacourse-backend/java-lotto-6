package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CLIInputView implements InputView {
    public static final String DELIMITER = ",";

    @Override
    public Integer readCost() {
        String input = Console.readLine();
        return parseInteger(input);
    }

    private Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IOException.INVALID_NUMBER.getMessage());
        }
    }

    @Override
    public List<Integer> readWinningNumbers() {
        return Arrays.stream(Console.readLine()
                        .split(DELIMITER))
                .map(this::parseInteger)
                .toList();
    }

    @Override
    public Integer readBonusNumber() {
        String input = Console.readLine();
        return parseInteger(input);
    }
}
