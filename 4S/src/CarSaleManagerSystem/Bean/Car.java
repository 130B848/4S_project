package CarSaleManagerSystem.Bean;

import java.util.Date;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Car {
    private String carID;
//    private String brand;
    private String sfx;
    private CarColor carColor = new CarColor();
    private float cost;
//    private String status; // on the way
    private Date purchasedTime;
    private float price;
    private String normal;
    private Garage garage = new Garage();
    private StockStatus stockStatus = new StockStatus();

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return garage.getBrand();
    }

    public void setBrand(String brand) {
        this.garage.setBrand(brand);// = brand;
    }

    public String getSfx() {
        return sfx;
    }

    public void setSfx(String sfx) {
        this.sfx = sfx;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public String getColor(){
        return carColor.getColor();
    }

    public void setColor(String color){
        this.carColor.setColor(color);
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getPurchasedTime() {
        return purchasedTime;
    }

    public void setPurchasedTime(Date purchasedTime) {
        this.purchasedTime = purchasedTime;
    }

    public String getStatus() {
        return stockStatus.getState();
    }

    public void setStatus(String status) {
        this.stockStatus.setState(status);//status = status;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }
}
