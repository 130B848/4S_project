package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/10.
 */
public class CarBrand {
    private String brand;
    private Garage garage = new Garage();

    private Set<Car> carSet = new HashSet<>();
    private Set<Gift> giftSet = new HashSet<>();

    public Set<Gift> getGiftSet() {
        return giftSet;
    }

    public void setGiftSet(Set<Gift> giftSet) {
        this.giftSet = giftSet;
    }

    public String getGarageBrand(){
        return garage.getBrand();
    }

    public void setGarageBrand(String brand){
        this.garage.setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }
}
