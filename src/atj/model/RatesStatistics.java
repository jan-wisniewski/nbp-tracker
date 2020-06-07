package atj.model;

import atj.service.RateService;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RatesStatistics {
    @SerializedName("average")
    @Expose
    private String average;

    public RatesStatistics() {
    }

    public RatesStatistics(RateService rateService) {
        this.average = rateService.calculateAverage();
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

}
