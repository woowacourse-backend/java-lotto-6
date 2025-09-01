package lotto.domain;

public enum Comment {

    Start_Comment("구입금액을 입력해 주세요."),
    Buy_Lotto("개를 구매했습니다."),
    Winning_Lotto("당첨 번호를 입력해 주세요."),
    Bonus_Number("보너스 번호를 입력해 주세요."),
    Winning_Analyse("당첨 통계"),
    Boundary("---"),
    ;

    private final String description;
    Comment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
