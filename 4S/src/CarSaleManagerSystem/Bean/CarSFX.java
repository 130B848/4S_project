package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class CarSFX {
    private String sfx;
    private Set<CarType> carTypeSet = new HashSet<>();

    public String getSfx() {
        return sfx;
    }

    public void setSfx(String sfx) {
        this.sfx = sfx;
    }

    public Set<CarType> getCarTypeSet() {
        return carTypeSet;
    }

    public void setCarTypeSet(Set<CarType> carTypeSet) {
        this.carTypeSet = carTypeSet;
    }
}
