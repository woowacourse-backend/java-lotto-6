package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {

    @Test
    @DisplayName("new LottoMoney(): 돈의 단위가 맞지 않으면 예외를 던진다.")
    void create() {
        assertThatThrownBy(() -> new LottoMoney(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorStatus.INVALID_MONEY_UNIT.getMessage());
    }

    @Test
    @DisplayName("getPurchaseCount(): 구매 개수를 리턴한다.")
    void getPurchaseCount() {
        int count = 10;
        int money = LottoMoney.UNIT * count;

        LottoMoney lottoMoney = new LottoMoney(money);

        assertThat(lottoMoney.getPurchaseCount())
                .isEqualTo(count);
    }

}