package lotto;

public enum LottoErrorStatus {
    INVALID_SIZE("로또 번호의 개수는 %d개 여야 합니다.".formatted(Lotto.SIZE)),
    INVALID_RANGE("로또 번호는 %d부터 %d사이의 숫자여야 합니다.".formatted(Lotto.MIN_VALUE, Lotto.MAX_VALUE)),
    DUPLICATE("로또 번호는 중복 될 수 없습니다."),
    INVALID_RANGE_BONUS_NUMBER("보너스 번호는 %d 부터 %d사이의 숫자여야 합니다.".formatted(Lotto.MIN_VALUE, Lotto.MAX_VALUE)),
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
