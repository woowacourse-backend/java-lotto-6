package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchasedLotto;
import lotto.validator.AmountValidator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final AmountValidator amountValidator;
    private final LottoMachine lottoMachine;
    private final WinningNumberValidator winningNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public LottoController() {
        this.amountValidator = new AmountValidator();
        this.lottoMachine = new LottoMachine();
        this.winningNumberValidator = new WinningNumberValidator();
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    public void run() {
        int buyAmount = getAmount();
        System.out.println();

        List<Lotto> lottoList = lottoMachine.issueLotto(buyAmount);
        PurchasedLotto purchasedLotto = new PurchasedLotto(lottoList);

        purchasedLotto.printAll();
        System.out.println();

        // 당첨 번호 입력
        List<Integer> winningNumber = getWinningNumber();
        System.out.println();

        System.out.println("winningNumber = " + winningNumber);
        // 보너스 번호 입력
        int bonusNumber = getBonusNumber(winningNumber);
        System.out.println();

        System.out.println("bonusNumber = " + bonusNumber);
    }


    public int getAmount() {
        while (true) {
            try {
                String input = InputView.buyAmountInput();
                return amountValidator.validateAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        while (true) {
            try {
                String input = InputView.winningNumberInput();
                return winningNumberValidator.validateWinningNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                String input = InputView.bonusNumberInput();
                int bonusNumber = bonusNumberValidator.validateBonusNumber(input);
                return bonusNumberValidator.validateDuplicateBonusNumber(bonusNumber, winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
