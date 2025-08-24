package lotto.domain;

public enum LottoRules {

    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
