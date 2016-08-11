package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.DAO.*;
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
    private CarBrandDAO carBrandDAO;

    @Autowired
    private ColorDAO colorDAO;

    @Autowired
    private SFXDAO sfxdao;

    @Autowired
    private CarTypeDAO carTypeDAO;

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

    public void createCarBrand(CarBrand carBrand){
        carBrandDAO.createCarBrand(carBrand);
    }

    public List<CarBrand> getAllCarBrands(){
        return carBrandDAO.getAllCarBrands();
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

    public void createCarSFX(CarSFX carSFX){
        sfxdao.createCarSFX(carSFX);
    }

    public List<CarSFX> getAllCarSFX(){
        return sfxdao.getAllCarSFXs();
    }

    public void createCarType(CarType carType){carTypeDAO.createCarType(carType);}

    public List<CarType> getAllCarType(){return carTypeDAO.getAllCarType();}

    public void removeCarType(CarType carType){carTypeDAO.removeCarType(carType);}

    public void updateCarType(CarType carType){carTypeDAO.updateCarType(carType);}

    public List<CarType> findCarTypeByGarageBrand(String garageBrand){return carTypeDAO.findCarTypeByGarageBrand(garageBrand);}

    public List<CarType> findCarTypeByBrand(String brand){return carTypeDAO.findCarTypeByBrand(brand);}

    public List<CarType> findCarTypeBySFX(String SFX){return carTypeDAO.findCarTypeBySFX(SFX);}

    public List<CarType> findCarTypeByColor(String color){return carTypeDAO.findCarTypeByColor(color);}

}
