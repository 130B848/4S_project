package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Car;
import CarSaleManagerSystem.Bean.CarColor;
import CarSaleManagerSystem.Bean.Garage;
import CarSaleManagerSystem.Bean.StockStatus;
import CarSaleManagerSystem.DAO.CarDAO;
import CarSaleManagerSystem.DAO.ColorDAO;
import CarSaleManagerSystem.DAO.GarageDAO;
import CarSaleManagerSystem.DAO.StockStatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HFQ on 2016/8/7.
 */
@Service
@Transactional
public class CarService {
    @Autowired
    private CarDAO carDAO;

    @Autowired
    private GarageDAO garageDAO;

    @Autowired
    private ColorDAO colorDAO;

    @Autowired
    private StockStatusDAO stockStatusDAO;

    public void createCar(Car car){
        carDAO.createCar(car);
    }

    public List<Car> getAllCars(){
        return carDAO.getAllCars();
    }

    public void removeCar(Car car){
        carDAO.removeCar(car);
    }

    public void updateCar(Car car){
        carDAO.updateCar(car);
    }

    public Car findCarById(String carID){
        return carDAO.findCarById(carID);
    }

    public void createGarage(Garage garage){
        garageDAO.createGarage(garage);
    }

    public List<Garage> getAllGarages(){
        return garageDAO.getAllGarages();
    }

    public void createColor(CarColor carColor){
        colorDAO.createColor(carColor);
    }

    public List<CarColor> getAllColors(){
        return colorDAO.getAllColors();
    }

    public void createStockStatus(StockStatus stockStatus){
        stockStatusDAO.createStockStatus(stockStatus);
    }

    public List<StockStatus> getAllStockStatus(){
        return stockStatusDAO.getAllStockStatus();
    }
}
