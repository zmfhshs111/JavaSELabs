package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> typeCounts = new HashMap<>();
        Map<String, Long> typeTotalPrices = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
            typeTotalPrices.put(type, typeTotalPrices.getOrDefault(type, 0L) + pub.getPrice());
        }

        Map<String, Double> averagePrices = new HashMap<>();
        for (String type : typeCounts.keySet()) {
            averagePrices.put(type, (double) typeTotalPrices.get(type) / typeCounts.get(type));
        }
        return averagePrices;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCounts = new HashMap<>();
        int total = publications.length;
        if (total == 0) return new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : typeCounts.keySet()) {
            distribution.put(type, (double) typeCounts.get(type) * 100 / total);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        if (publications.length == 0) return 0.0;
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count * 100 / publications.length;
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat priceDf = new DecimalFormat("#,##0");
        DecimalFormat percentDf = new DecimalFormat("0.00");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        avgPrices.forEach((type, avgPrice) -> {
            System.out.println("- " + type + ": " + priceDf.format(avgPrice) + "원");
        });

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        distribution.forEach((type, dist) -> {
            System.out.println("- " + type + ": " + percentDf.format(dist) + "%");
        });

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + percentDf.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }
}