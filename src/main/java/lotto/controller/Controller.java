package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoMoney;
import lotto.LottoService;
import lotto.WinningLotto;
import lotto.WinningLottoStatus;
import lotto.io.InputView;
import lotto.io.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public Controller(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            LottoMoney lottoMoney = new LottoMoney(inputView.readCost());
            outputView.println();

            List<Lotto> lottoList = lottoService.purchaseLottoList(lottoMoney);
            outputView.printLottoList(lottoList);
            outputView.println();

            Lotto lotto = new Lotto(inputView.readWinningNumbers());
            outputView.println();

            Integer bonusNumber = inputView.readBonusNumber();
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            outputView.println();

            Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts = lottoService.getWinningLottoStatusAndCounts(
                    winningLotto, lottoList);
            Double revenueRate = lottoService.getRevenueRate(winningLottoStatusAndCounts, lottoMoney);
            outputView.printWinningStatus(winningLottoStatusAndCounts, revenueRate);
        }catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
