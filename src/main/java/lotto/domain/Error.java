package lotto.domain;

public enum Error {

    NumberFormatError("숫자가 아닙니다."),
    LottoSizeError("로또 크기가 올바르지 않습니다."),
    LottoNumberError("로또 번호의 범위가 올바르지 않습니다"),
    LottoDuplicateNumber("로또 번호가 중복됩니다.");
    private final String message;
    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
