package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchasedLotto;
import lotto.validator.AmountValidator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final AmountValidator validator;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.validator = new AmountValidator();
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        int buyAmount = getAmount();
        System.out.println();

        List<Lotto> lottoList = lottoMachine.issueLotto(buyAmount);
        PurchasedLotto purchasedLotto = new PurchasedLotto(lottoList);

        purchasedLotto.printAll();

    }


    public int getAmount() {
        while (true) {
            try {
                String input = InputView.buyAmountInput();
                return validator.validateAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
