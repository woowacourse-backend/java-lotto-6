package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.BonusNumberService;
import lotto.service.RandomLottoService;
import lotto.service.SetOpportunityService;
import lotto.service.WinningNumberService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.Map;

public class GameController {

    private final InputView inputConsoleview;
    private final OutputView outputConsoleview;
    private final RandomLottoService randomLottoService;
    private final WinningNumberService winningNumberService;
    private final SetOpportunityService setOpportunityService;
    private final BonusNumberService bonusNumberService;

    public GameController(InputView inputConsoleview, OutputView outputConsoleview, RandomLottoService randomLottoService, WinningNumberService winningNumberService, SetOpportunityService setOpportunityService, BonusNumberService bonusNumberService) {
        this.inputConsoleview = inputConsoleview;
        this.outputConsoleview = outputConsoleview;
        this.randomLottoService = randomLottoService;
        this.winningNumberService = winningNumberService;
        this.setOpportunityService = setOpportunityService;
        this.bonusNumberService = bonusNumberService;
    }

    public void run() {
        int opportunity = getOpportunity();
        LottoList lottoList = getLottoList(opportunity);
        Lotto winningLotto = winningLotto();
        int bonus = bonusNumber();
        WinningLotto winLotto = saveWinningLotto(winningLotto, bonus);
        ranking(lottoList, winLotto);
    }

    private int getOpportunity() {
        while (true) {
            try {
                String price = inputConsoleview.inputPrice();
                return setOpportunityService.getOpportunity(price);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoList getLottoList(int opportunity) {
        LottoList list =  randomLottoService.opportunityLotto(opportunity);
        outputConsoleview.printAllLotto(list);
        return list;
    }

    private Lotto winningLotto() {
        while (true) {
            try {
                String winningLotto = inputConsoleview.inputWinningLotto();
                return winningNumberService.getWinningNumber(winningLotto);

            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int bonusNumber() {
        while (true) {
            try {
                String bonus = inputConsoleview.inputBonusNumber();
                return bonusNumberService.getBonusNumber(bonus);

            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto saveWinningLotto(Lotto lotto, int bonus) {
        return new WinningLotto(lotto, bonus);
    }

    private void ranking(LottoList lottoList, WinningLotto winningLotto) {
        Map<Rank, Integer> map = lottoList.resultWinningLottos(winningLotto);
        outputConsoleview.resultPrint(map);
    }
}
