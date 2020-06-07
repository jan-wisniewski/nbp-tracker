package atj.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Rates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rates {

    @XmlElement(name = "Rate")
    private List<Rate> rates;

    public List<Rate> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "rates=" + rates +
                '}';
    }
}
