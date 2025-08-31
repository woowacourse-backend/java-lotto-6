package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.model.LottoNumberGenerator;
import lotto.model.WinningLotto;
import lotto.model.WinningLottoStatus;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> purchaseLottoList(LottoMoney lottoMoney) {
        int purchaseCount = lottoMoney.getPurchaseCount();

        List<Lotto> purchasedLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.getOrderedLottoNumbers());
            purchasedLottoList.add(lotto);
        }
        return purchasedLottoList;
    }

    public Map<WinningLottoStatus, Integer> getWinningLottoStatusAndCounts(
            WinningLotto winningLotto,
            List<Lotto> purchasedLottoList
    ) {
        Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts = new HashMap<>();
        putWinningLottoStatus(winningLottoStatusAndCounts);

        for (Lotto lotto : purchasedLottoList) {
            WinningLottoStatus status = WinningLottoStatus.getWinningLottoStatus(winningLotto, lotto);
            if (status == null) {
                continue;
            }
            winningLottoStatusAndCounts.put(status, winningLottoStatusAndCounts.get(status) + 1);
        }

        return winningLottoStatusAndCounts;
    }

    private void putWinningLottoStatus(Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts) {
        Arrays.stream(WinningLottoStatus.values())
                .forEach(winningLottoStatus ->
                        winningLottoStatusAndCounts.put(winningLottoStatus, 0));
    }

    public Double getRevenueRate(Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts, LottoMoney lottoMoney) {
        Long revenue = getRevenue(winningLottoStatusAndCounts);
        return lottoMoney.getRevenueRate(revenue);
    }

    private Long getRevenue(Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts) {
        return winningLottoStatusAndCounts.entrySet()
                .stream()
                .map(getProductOfPriceAndCount())
                .reduce(Long::sum)
                .orElse(0L);
    }

    private Function<Entry<WinningLottoStatus, Integer>, Long> getProductOfPriceAndCount() {
        return entry -> (long) entry.getKey().getPrice() * entry.getValue();
    }
}
