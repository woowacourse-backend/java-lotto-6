package lotto.io;

import java.util.List;

public interface InputView {
    public Integer readCost();
    public List<Integer> readWinningNumbers();
    public Integer readBonusNumber();
}
