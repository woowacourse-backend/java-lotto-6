package lotto;

public class LottoMoney {
    public static final Integer UNIT = 1_000;

    private final Integer money;

    public LottoMoney(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(LottoErrorStatus.INVALID_MONEY_UNIT.getMessage());
        }
    }

    public Integer getPurchaseCount() {
        return money / UNIT;
    }

    public double getRevenueRate(long revenue){
        return (double) revenue /UNIT;
    }
}
