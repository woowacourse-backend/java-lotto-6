package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Comment;

public class InputConsoleView implements InputView {

    @Override
    public String inputPrice() {
        System.out.println(Comment.Start_Comment.getDescription());
        return Console.readLine();
    }

    @Override
    public String inputWinningLotto() {
        System.out.println(Comment.Winning_Lotto.getDescription());
        return Console.readLine();
    }

    @Override
    public String inputBonusNumber() {
        System.out.println(Comment.Bonus_Number.getDescription());
        return Console.readLine();
    }
}
