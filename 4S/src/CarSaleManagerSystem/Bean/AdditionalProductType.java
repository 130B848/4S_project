package CarSaleManagerSystem.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class AdditionalProductType {
    private String type;
    private Set<AdditionalProduct> additionalProductSet = new HashSet<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<AdditionalProduct> getAdditionalProductSet() {
        return additionalProductSet;
    }

    public void setAdditionalProductSet(Set<AdditionalProduct> additionalProductSet) {
        this.additionalProductSet = additionalProductSet;
    }
}
