package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {

    Correct_3(3, "5등", "3개 일치 (5,000원)", 5000, false),
    Correct_4(4, "4등", "4개 일치 (50,000원)", 50000,false),
    Correct_5(5, "3등", "5개 일치 (1,500,000원)", 1500000, false),
    Correct_5_And_Bonus(5, "2등", "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, true),
    Correct_6(6, "1등", "6개 일치 (2,000,000,000원)", 2000000000, false),
    Correct_Not(0, null, null, 0, false),
    ;

    private final int winningNumber;
    private final String winningName;
    private final long winningMoney;
    private final Boolean isBonus;
    private final String comment;

    Rank(int winningNumber, String winningName, String comment, long winningMoney, Boolean isBonus) {
        this.winningNumber = winningNumber;
        this.winningName = winningName;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
        this.comment = comment;
    }
    public int getWinningNumber() {
        return winningNumber;
    }
    public String getWinningName() {
        return winningName;
    }
    public long getWinningMoney() {
        return winningMoney;
    }
    public String getComment() {
        return comment;
    }

    public static Rank getRank(int winningNumber, Boolean isBonus) {
        /**
         * 보너스 점수가 있을 경우
         */
        if (isBonus == true) {
            Optional<Rank> bonusRank = Arrays.stream(Rank.values())
                    .filter(rank -> rank.getWinningNumber() == winningNumber && rank.isBonus == true)
                    .findFirst();
            if (bonusRank.isPresent()) {
                return bonusRank.get();
            }
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.winningNumber == winningNumber && rank.isBonus == false)
                .findFirst()
                .orElse(Correct_Not);
    }
}
