package atj.service;

import atj.model.Rates;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class RateService {
    private Rates rates;

    public RateService(Rates rates) {
        this.rates = rates;
    }

    public String calculateAverage() {
        DoubleSummaryStatistics bidStats = rates
                .getRates()
                .stream()
                .collect(Collectors.summarizingDouble(rate -> Double.parseDouble(rate.getBid())));
        return String.valueOf(bidStats.getAverage());
    }
}
