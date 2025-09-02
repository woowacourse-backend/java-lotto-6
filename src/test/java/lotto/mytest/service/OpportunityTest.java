package lotto.mytest.service;

import lotto.domain.LottoList;
import lotto.service.RandomLottoService;
import lotto.service.SetOpportunityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpportunityTest {
    private final SetOpportunityService setOpportunityService = new SetOpportunityService();
    private final RandomLottoService randomLottoService = new RandomLottoService();
    @Test
    void getOpportunity() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> setOpportunityService.getOpportunity("1111"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> setOpportunityService.getOpportunity("1000100"));
    }

    @Test
    void getIntegerOpportunity() {
        String price = "10000";
        int opportunity = 10;

        Assertions.assertEquals(opportunity, setOpportunityService.getOpportunity(price));
    }

    @Test
    void getLottos() {
        LottoList list = randomLottoService.opportunityLotto(10);
        System.out.println(list.printAllLottos());
    }
}
