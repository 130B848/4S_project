package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/8.
 */
public class CarColor {
    private String color;

    private Set<CarType> carTypeSet = new HashSet<>();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<CarType> getCarTypeSet() {
        return carTypeSet;
    }

    public void setCarTypeSet(Set<CarType> carTypeSet) {
        this.carTypeSet = carTypeSet;
    }
}
