package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String buyAmountInput() {
        System.out.print("구입금액을 입력해 주세요.");
        return Console.readLine();

    }
}
