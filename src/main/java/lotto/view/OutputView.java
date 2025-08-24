package lotto.view;

import lotto.domain.Rank;

import java.util.Map;

public class OutputView {

    public void lottoWinningStatistics(Map<Rank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(Rank.FIFTH_PLACE) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(Rank.FOURTH_PLACE) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(Rank.THIRD_PLACE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(Rank.SECOND_PLACE) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(Rank.FIRST_PLACE) + "개");
    }

    public void totalProfitPrint(double totalProfit) {
        String formatTotalProfit = String.format("%.1f", totalProfit);
        System.out.println("총 수익률은 " + formatTotalProfit + "입니다.");
    }
}
