package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final WinningLotto winningLotto;
    private final LottoMoney lottoMoney;
    private final List<Lotto> purchasedLottoList;
    private final Map<WinningLottoStatus, Integer> status;

    public LottoService(
            LottoNumberGenerator lottoNumberGenerator,
            WinningLotto winningLotto,
            LottoMoney lottoMoney) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.winningLotto = winningLotto;
        this.lottoMoney = lottoMoney;
        this.purchasedLottoList = purchaseLottos(lottoMoney.getPurchaseCount());
        status = getWinningLottoStatusAndCounts();
    }

    private List<Lotto> purchaseLottos(Integer purchaseCount) {
        List<Lotto> purchasedLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            purchasedLottoList.add(new Lotto(lottoNumberGenerator.getOrderedLottoNumbers()));
        }
        return purchasedLottoList;
    }

    private Map<WinningLottoStatus, Integer> getWinningLottoStatusAndCounts() {
        Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts = new HashMap<>();
        putWinningLottoStatus(winningLottoStatusAndCounts);

        for (Lotto lotto : purchasedLottoList) {
            WinningLottoStatus status = WinningLottoStatus.getWinningLottoStatus(winningLotto, lotto);

            winningLottoStatusAndCounts.put(status, winningLottoStatusAndCounts.get(status) + 1);
        }

        return winningLottoStatusAndCounts;
    }

    private void putWinningLottoStatus(Map<WinningLottoStatus, Integer> winningLottoStatusAndCounts) {
        Arrays.stream(WinningLottoStatus.values())
                .forEach(winningLottoStatus ->
                        winningLottoStatusAndCounts.put(winningLottoStatus, 0));
    }


    public Integer getPurchaseCounts() {
        return lottoMoney.getPurchaseCount();
    }

    public List<Lotto> getPurchasedLottoList() {
        return purchasedLottoList.stream()
                .toList();
    }

    public Double getRevenueRate() {
        Long revenue = status.entrySet().stream()
                .map(getProductOfPriceAndCount())
                .reduce(Long::sum)
                .orElse(0L);

        return lottoMoney.getRevenueRate(revenue);
    }

    private Function<Entry<WinningLottoStatus, Integer>, Long> getProductOfPriceAndCount() {
        return entry -> (long) entry.getKey().getPrice() * entry.getValue();
    }

    public Map<WinningLottoStatus, Integer> getStatus() {
        return status;
    }
}
