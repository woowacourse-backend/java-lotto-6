package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> purchaseTicket(LottoMoney lottoMoney) {
        Supplier<Lotto> createLotto = () ->
                new Lotto(lottoNumberGenerator.getOrderedLottoNumbers());

        return Stream.generate(createLotto)
                .limit(lottoMoney.getPurchaseCount())
                .toList();
    }

    public Map<LottoRank, Integer> getRankResults(
            WinningLotto winningLotto,
            List<Lotto> purchasedLotto
    ) {
        Map<LottoRank, Integer> winningLottoStatusAndCounts = new HashMap<>();

        purchasedLotto.stream()
                .map(lotto -> rankOf(winningLotto, lotto))
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(lottoRank -> winningLottoStatusAndCounts.merge(lottoRank, 1, Integer::sum));

        return winningLottoStatusAndCounts;
    }

    private LottoRank rankOf(WinningLotto winningLotto, Lotto lotto) {
        return LottoRank.valueOf(
                winningLotto.matchCount(lotto),
                winningLotto.matchBonus(lotto));
    }

    public Double getRevenueRate(Map<LottoRank, Integer> winningLottoStatusAndCounts, LottoMoney lottoMoney) {
        Long revenue = getRevenue(winningLottoStatusAndCounts);
        return lottoMoney.getRevenueRate(revenue);
    }

    private Long getRevenue(Map<LottoRank, Integer> winningLottoStatusAndCounts) {
        return winningLottoStatusAndCounts.entrySet()
                .stream()
                .map(this::toCost)
                .reduce(Long::sum)
                .orElse(0L);
    }

    private Long toCost(Entry<LottoRank, Integer> rankResult) {
        return (long) rankResult.getKey().getPrice() * rankResult.getValue();
    }
}
