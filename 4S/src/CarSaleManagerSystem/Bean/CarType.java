package CarSaleManagerSystem.Bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/11.
 */
public class CarType implements Serializable{


//    private CarBrand carBrand = new CarBrand();
    private CarColor carColor = new CarColor();
    private CarSFX carSfx = new CarSFX();
    private Garage garage = new Garage();

    private String brand;
//    private String color;
//    private String sfx;
//    private String garage;

    private int plan;
    private int stock;
    private int order;
    private float price;
    private float cost;
    private float discount;

//    private Set<Car> carSet = new HashSet<>();
//    private Set<Gift> giftSet = new HashSet<>();


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSfx() {
        return carSfx.getSfx();
    }

    public void setSfx(String carSfx) {
        this.carSfx.setSfx(carSfx);
    }

    public String getColor(){
        return carColor.getColor();
    }

    public void setColor(String color){
        this.carColor.setColor(color);
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public CarSFX getCarSfx() {
        return carSfx;
    }

    public void setCarSfx(CarSFX carSfx) {
        this.carSfx = carSfx;
    }

//    public Set<Gift> getGiftSet() {
//        return giftSet;
//    }
//
//    public void setGiftSet(Set<Gift> giftSet) {
//        this.giftSet = giftSet;
//    }

    public String getGarageBrand(){
        return garage.getBrand();
    }

    public void setGarageBrand(String brand){
        this.garage.setBrand(brand);
    }


    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

//    public Set<Car> getCarSet() {
//        return carSet;
//    }

//    public void setCarSet(Set<Car> carSet) {
//        this.carSet = carSet;
//    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarType)) return false;

        CarType carType = (CarType) o;

        if (!carColor.equals(carType.carColor)) return false;
        if (!carSfx.equals(carType.carSfx)) return false;
        if (!garage.equals(carType.garage)) return false;
        return brand.equals(carType.brand);

    }

    @Override
    public int hashCode() {
        int result = carColor.hashCode();
        result = 31 * result + carSfx.hashCode();
        result = 31 * result + garage.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }
}
