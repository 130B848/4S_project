package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Gift {
    private int giftID;
    private String name;
//    private String type;
    private float cost;
    private float default_price;
    private float selling_price;
    private float discount;
    private float actualGetMoney;
    private Order order;
    private GiftType giftType = new GiftType();
//    private CarBrand carBrand = new CarBrand();
    private String garage;
    private String brand;
    private String valid;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public GiftType getGiftType() {
        return giftType;
    }

    public void setGiftType(GiftType giftType) {
        this.giftType = giftType;
    }

    public float getActualGetMoney() {
        return actualGetMoney;
    }

    public void setActualGetMoney(float actualGetMoney) {
        this.actualGetMoney = actualGetMoney;
    }

//    public CarBrand getCarBrand() {
//        return carBrand;
//    }
//
//    public void setCarBrand(CarBrand carBrand) {
//        this.carBrand = carBrand;
//    }

//    public String getBrand() {
//        return carBrand.getBrand();
//    }
//
//    public void setBrand(String brand) {
//        this.carBrand.setBrand(brand);
//    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getGiftID() {
        return giftID;
    }

    public void setGiftID(int giftID) {
        this.giftID = giftID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return giftType.getType();
    }

    public void setType(String type) {
        this.giftType.setType(type);
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
