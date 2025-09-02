package lotto;

import lotto.controller.GameController;
import lotto.service.BonusNumberService;
import lotto.service.RandomLottoService;
import lotto.service.SetOpportunityService;
import lotto.service.WinningNumberService;
import lotto.view.input.InputConsoleView;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputConsoleview = new InputConsoleView();
        OutputView outputConsoleview = new OutputView();
        RandomLottoService randomLottoService = new RandomLottoService();
        WinningNumberService winningNumberService = new WinningNumberService();
        SetOpportunityService setOpportunityService = new SetOpportunityService();
        BonusNumberService bonusNumberService = new BonusNumberService();

        GameController controller = new GameController(inputConsoleview, outputConsoleview, randomLottoService, winningNumberService, setOpportunityService, bonusNumberService);
        controller.run();
    }
}
