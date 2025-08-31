package lotto;

import lotto.controller.Controller;
import lotto.io.CLIInputView;
import lotto.io.CLIOutputView;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.model.LottoNumbersGeneratorImpl;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new CLIOutputView();
        InputView inputView = new CLIInputView(outputView);
        LottoService lottoService = new LottoService(new LottoNumbersGeneratorImpl());
        Controller controller = new Controller(inputView, outputView, lottoService);

        controller.run();
    }
}
