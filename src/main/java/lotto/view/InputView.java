package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String buyAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String winningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
