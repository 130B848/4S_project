package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/11.
 */
public class AdditionalProduct {
    private int additionalProductID;
    private String name;
    private float cost;
    private float default_price;
    private float selling_price;
    private float discount;
    private float actualGetMoney;
    private String valid;
    private Order order;
    private AdditionalProductType additionalProductType = new AdditionalProductType();

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public int getAdditionalProductID() {
        return additionalProductID;
    }

    public void setAdditionalProductID(int additionalProductID) {
        this.additionalProductID = additionalProductID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDefault_price() {
        return default_price;
    }

    public void setDefault_price(float default_price) {
        this.default_price = default_price;
    }

    public float getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getActualGetMoney() {
        return actualGetMoney;
    }

    public void setActualGetMoney(float actualGetMoney) {
        this.actualGetMoney = actualGetMoney;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public AdditionalProductType getAdditionalProductType() {
        return additionalProductType;
    }

    public void setAdditionalProductType(AdditionalProductType additionalProductType) {
        this.additionalProductType = additionalProductType;
    }

    public String getType() {
        return additionalProductType.getType();
    }

    public void setType(String type) {
        this.additionalProductType.setType(type);
    }
}
