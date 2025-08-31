package lotto.io;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.WinningLottoStatus;

public interface OutputView {
    void println();
    void printInstruction(String instruction);
    void printLottoList(List<Lotto> lottoList);
    void printWinningStatus(Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts, Double revenueRate);
    void printError(String error);
}
