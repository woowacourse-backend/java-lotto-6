package lotto.service;

public class SetOpportunityService {

    public int getOpportunity(String price) {
        validate(price);
        return Integer.parseInt(price) / 1000;
    }

    private void validate (String price) {
        String regex = "[0-9]*";
        if (price.matches(regex) == false) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
