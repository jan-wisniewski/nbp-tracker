package atj.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AverageRate {
    private String avg;

    public AverageRate() {
    }

    public AverageRate(String avg) {
        this.avg = avg;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "AverageRate{" +
                "avg='" + avg + '\'' +
                '}';
    }
}
