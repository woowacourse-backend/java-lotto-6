package lotto.mytest.domain;

import lotto.domain.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void getRank() {
        Assertions.assertEquals(Rank.Correct_5, Rank.getRank(5, false));
        Assertions.assertEquals(Rank.Correct_5_And_Bonus, Rank.getRank(5, true));
        Assertions.assertEquals(Rank.Correct_6, Rank.getRank(6, false));
        Assertions.assertEquals(Rank.Correct_4, Rank.getRank(4, true));
    }
}
