package lotto.controller;

import lotto.validator.AmountValidator;
import lotto.view.InputView;

public class LottoController {
    private final AmountValidator validator;

    public LottoController() {
        this.validator = new AmountValidator();
    }

    public void run() {
        int buyAmount = getAmount();

        System.out.println("구입 금액: " + buyAmount);
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
