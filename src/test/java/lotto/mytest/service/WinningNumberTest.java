package lotto.mytest.service;

import lotto.domain.Lotto;
import lotto.service.WinningNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberTest {

    private final WinningNumberService winningNumberService = new WinningNumberService();

    @Test
    void getWinningNumber() {
        String a = "1, 2, 3, 4, 5, 6";

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Lotto lotto = new Lotto(list);

        Assertions.assertEquals(lotto.getNumbers(), winningNumberService.getWinningNumber(a).getNumbers());
        Assertions.assertEquals(list, winningNumberService.format(a));

        String b = "1, 2, 3, 4, 5, ㅁ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> winningNumberService.getWinningNumber(b));
    }
}
