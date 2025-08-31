package lotto.model;

public enum WinningLottoStatus {
    FIFTH(5, 3, null, 5_000L),
    FOURTH(4, 4, null, 50_000L),
    THIRD(3, 5, Boolean.FALSE, 1_500_000L),
    SECOND(2, 5, Boolean.TRUE, 30_000_000L),
    FIRST(1, 6, null, 2_000_000_000L),
    ;

    private final Integer place;
    private final Integer containsCounts;
    private final Boolean matchBonusNumber;
    private final Long price;

    WinningLottoStatus(Integer place, Integer containsCounts, Boolean matchBonusNumber, Long price) {
        this.place = place;
        this.containsCounts = containsCounts;
        this.matchBonusNumber = matchBonusNumber;
        this.price = price;
    }

    public static WinningLottoStatus getWinningLottoStatus(WinningLotto winningLotto, Lotto purchasedLotto) {
        int containsCounts = winningLotto.containsCounts(purchasedLotto);
        boolean isMatchBonusNumber = winningLotto.matchBonusNumber(purchasedLotto);

        for (WinningLottoStatus winningLottoStatus : WinningLottoStatus.values()) {
            if (winningLottoStatus.checkCondition(containsCounts, isMatchBonusNumber)) {
                return winningLottoStatus;
            }
        }
        return null;
    }

    private boolean checkCondition(int containsCounts, boolean isMatchBonusNumber) {
        if (this == SECOND || this == THIRD) {
            return this.containsCounts == containsCounts && isMatchBonusNumber == matchBonusNumber;
        }
        return this.containsCounts == containsCounts;
    }

    public Integer getContainsCounts() {
        return containsCounts;
    }

    public Long getPrice() {
        return price;
    }
}
