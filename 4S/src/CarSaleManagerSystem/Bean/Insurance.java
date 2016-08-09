package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Insurance {
    private String insuranceID;
    private String name;
    private String type;
    private float cost;
    private float default_price;
    private float selling_price;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
