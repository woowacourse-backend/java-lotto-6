package lotto;

public enum LottoErrorStatus {
    INVALID_SIZE("로또 숫자의 개수가 잘못 되었습니다."),
    INVALID_RANGE("로또 숫자의 범위가 잘못 되었습니다."),
    DUPLICATE("로또 번호는 중복 될 수 없습니다."),
    INVALID_RANGE_BONUS_NUMBER("보너스 번호의 범위가 잘못 되었습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 중복 될 수 없습니다."),
    ;

    private final String message;

    LottoErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
