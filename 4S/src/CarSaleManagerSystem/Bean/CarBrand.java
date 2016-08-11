package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/10.
 */
public class CarBrand {
    private Garage garage = new Garage();
    private String brand;
    private Set<CarType> carTypeSet = new HashSet<>();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<CarType> getCarTypeSet() {
        return carTypeSet;
    }

    public void setCarTypeSet(Set<CarType> carTypeSet) {
        this.carTypeSet = carTypeSet;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
