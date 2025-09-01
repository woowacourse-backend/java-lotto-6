package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;


public enum LottoRank {
    NONE(0, 0, Collections.EMPTY_SET, 0L),
    FIFTH(5, 3, Set.of(Boolean.TRUE, Boolean.FALSE), 5_000L),
    FOURTH(4, 4, Set.of(Boolean.TRUE, Boolean.FALSE), 50_000L),
    THIRD(3, 5, Set.of(Boolean.FALSE), 1_500_000L),
    SECOND(2, 5, Set.of(Boolean.TRUE), 30_000_000L),
    FIRST(1, 6, Set.of(Boolean.FALSE), 2_000_000_000L),
    ;

    private final Integer place;
    private final Integer matchCount;
    private final Set<Boolean> matchBonus;
    private final Long price;

    LottoRank(Integer place, Integer containsCounts, Set<Boolean> matchBonus, Long price) {
        this.place = place;
        this.matchCount = containsCounts;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static LottoRank valueOf(Integer matchCount, Boolean matchBonus) {
        Predicate<LottoRank> condition = rank ->
                rank.matchCount.equals(matchCount) && rank.matchBonus.contains(matchBonus);

        return Arrays.stream(LottoRank.values())
                .filter(condition)
                .findFirst()
                .orElse(NONE);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Long getPrice() {
        return price;
    }
}
