package lotto.io;

public enum IOException {
    INVALID_NUMBER("숫자를 입력해 주세요."),
    ;
    private final String message;

    IOException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
