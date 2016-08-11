package CarSaleManagerSystem.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFQ on 2016/8/5.
 */
public class Order {
    private String orderID;
    private Customer customer;
    private User salesman;
    private Car car;
    private Set<Gift> giftSet = new HashSet<>();
    private Set<Insurance> insuranceSet = new HashSet<>();
    private Set<AdditionalProduct> additionalProductSet = new HashSet<>();
    private float salePrice;
    private float actualGetMoney;
    private Date date;
    private String finish_status; // is finished?
    private String remark;

    public Set<AdditionalProduct> getAdditionalProductSet() {
        return additionalProductSet;
    }

    public void setAdditionalProductSet(Set<AdditionalProduct> additionalProductSet) {
        this.additionalProductSet = additionalProductSet;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getSalesman() {
        return salesman;
    }

    public void setSalesman(User salesman) {
        this.salesman = salesman;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Gift> getGiftSet() {
        return giftSet;
    }

    public void setGiftSet(Set<Gift> giftSet) {
        this.giftSet = giftSet;
    }

    public Set<Insurance> getInsuranceSet() {
        return insuranceSet;
    }

    public void setInsuranceSet(Set<Insurance> insuranceSet) {
        this.insuranceSet = insuranceSet;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFinish_status() {
        return finish_status;
    }

    public void setFinish_status(String finish_status) {
        this.finish_status = finish_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public float getActualGetMoney() {
        return actualGetMoney;
    }

    public void setActualGetMoney(float actualGetMoney) {
        this.actualGetMoney = actualGetMoney;
    }
}
