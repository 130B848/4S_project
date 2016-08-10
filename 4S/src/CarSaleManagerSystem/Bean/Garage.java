package CarSaleManagerSystem.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Garage {
    private String brand;

    private Set<Car> carSet = new HashSet<>();

    private Set<CarBrand> carBrandSet = new HashSet<>();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public Set<CarBrand> getCarBrandSet() {
        return carBrandSet;
    }

    public void setCarBrandSet(Set<CarBrand> carBrandSet) {
        this.carBrandSet = carBrandSet;
    }
}
