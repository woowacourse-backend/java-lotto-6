package lotto.mytest.domain;

import lotto.service.WinningNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private final WinningNumberService service = new WinningNumberService();
    @Test
    void lottoTest() {

        String b = "1, 2, 3, 4, 5";
        String c = "1, 2, 3, 4, 5, 5";
        String d = "1, 2, 3, 4, 5, 50";

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getWinningNumber(b));
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getWinningNumber(c));
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getWinningNumber(d));

    }
}
