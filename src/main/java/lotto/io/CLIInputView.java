package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CLIInputView implements InputView {
    public static final String DELIMITER = ",";
    private final OutputView outputView;

    public CLIInputView(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public Integer readCost() {
        outputView.printInstruction("구입금액을 입력해 주세요.");

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
        outputView.printInstruction("당첨 번호를 입력해 주세요.");

        return Arrays.stream(Console.readLine()
                        .split(DELIMITER))
                .map(this::parseInteger)
                .toList();
    }

    @Override
    public Integer readBonusNumber() {
        outputView.printInstruction("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();
        return parseInteger(input);
    }
}
