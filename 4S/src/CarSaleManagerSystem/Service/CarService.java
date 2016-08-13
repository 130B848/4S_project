package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        if(carExist(car.getCarID())){
            return;
        }
        if(carDAO.findCarById(car.getCarID()) != null){
            car.setValid("Y");
            carDAO.updateCar(car);
            return;
        }
        car.setValid("Y");
        carDAO.createCar(car);
    }

    public List<Car> getAllCars(){
        return carDAO.getAllCars();
    }

    public void removeCar(Car car){
        if(carExist(car.getCarID())){
            car.setValid("N");
            carDAO.updateCar(car);
        }
//        carDAO.removeCar(car);
    }

    public void updateCar(Car car){
        carDAO.updateCar(car);
    }

    public Car findCarById(String carID){
//        Car car = carDAO.findCarById(carID);
        if(carExist(carID))
            return carDAO.findCarById(carID);
        return null;
    }

    public boolean carExist(String carID) {
        Car car = carDAO.findCarById(carID);
        if(car == null || car.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public void createGarage(Garage garage){
        if(garageExist(garage.getBrand())){
            return;
        }
        if(garageDAO.findGarageByBrand(garage.getBrand()) != null){
            garage.setValid("Y");
            garageDAO.updateGarage(garage);
            return;
        }
        garage.setValid("Y");
        garageDAO.createGarage(garage);
    }

    public List<Garage> getAllGarages(){
        return garageDAO.getAllGarages();
    }

    public void createCarBrand(CarBrand carBrand){
        if(brandExist(carBrand.getGarage(),carBrand.getBrand())){
            return;
        }
        List<CarBrand> carBrandList = getCarBrandsByGarage(carBrand.getGarage());
        if(carBrandList != null){
            for(int i = 0;i < carBrandList.size();i++){
                if(carBrandList.get(i).equals(carBrand)){
                    carBrand.setValid("Y");
                    carBrandDAO.updateCarBrand(carBrand);
                    return;
                }
            }
        }
        carBrand.setValid("Y");
        carBrandDAO.createCarBrand(carBrand);
    }

    public List<CarBrand> getAllCarBrands(){
        return carBrandDAO.getAllCarBrands();
    }

    public void createColor(CarColor carColor){
        if(colorExist(carColor.getColor())){
            return;
        }
        if(colorDAO.getColorByID(carColor.getColor())!=null){
            carColor.setValid("Y");
            colorDAO.updateColor(carColor);
            return;
        }
        carColor.setValid("Y");
        colorDAO.createColor(carColor);
    }

    public List<CarColor> getAllColors(){
        return colorDAO.getAllColors();
    }

    public void createStockStatus(StockStatus stockStatus){
        if(stockStatusExist(stockStatus.getState())){
            return;
        }
        if(stockStatusDAO.getStockStatusByID(stockStatus.getState()) != null){
            stockStatus.setValid("Y");
            stockStatusDAO.updateStockStatus(stockStatus);
            return;
        }
        stockStatus.setValid("Y");
        stockStatusDAO.createStockStatus(stockStatus);
    }

    public List<StockStatus> getAllStockStatus(){
        return stockStatusDAO.getAllStockStatus();
    }

    public void createCarSFX(CarSFX carSFX){
        if(sfxExist(carSFX.getSfx())){
            return;
        }
        if(sfxdao.findCarSFXById(carSFX.getSfx()) != null){
            carSFX.setValid("Y");
            sfxdao.updateCarSFX(carSFX);
            return;
        }
        carSFX.setValid("Y");
        sfxdao.createCarSFX(carSFX);
    }

    public List<CarSFX> getAllCarSFX(){
        return sfxdao.getAllCarSFXs();
    }

    public void createCarType(CarType carType){
        CarTypeID carTypeID = new CarTypeID(carType.getGarage(),carType.getBrand(),carType.getCarSfx(),carType.getCarColor());
        if(carTypeExist(carTypeID)){
            return;
        }
        if(getCarTypeByID(carTypeID) != null){
            carType.setValid("Y");
            carTypeDAO.updateCarType(carType);
            return;
        }
        carType.setValid("Y");
        carTypeDAO.createCarType(carType);
    }

    public List<CarType> getAllCarType(){return carTypeDAO.getAllCarType();}

    public void removeCarType(CarType carType){
        CarTypeID carTypeID = new CarTypeID(carType.getGarage(),carType.getBrand(),carType.getCarSfx(),carType.getCarColor());
        if(carTypeExist(carTypeID)){
            carType.setValid("N");
            carTypeDAO.updateCarType(carType);
        }
//        carTypeDAO.removeCarType(carType);
    }

    public void updateCarType(CarType carType){carTypeDAO.updateCarType(carType);}

    public List<CarType> findCarTypeByGarageBrand(String garageBrand){return carTypeDAO.findCarTypeByGarageBrand(garageBrand);}

    public List<CarType> findCarTypeByBrand(String brand){return carTypeDAO.findCarTypeByBrand(brand);}

    public List<CarType> findCarTypeBySFX(String SFX){return carTypeDAO.findCarTypeBySFX(SFX);}

    public List<CarType> findCarTypeByColor(String color){return carTypeDAO.findCarTypeByColor(color);}

    public List<CarType> GarageBrandFilter(List<CarType> carTypeList,String garage){
        if(garage == null){
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if(carTypeList == null){
            return null;
        }
        for(int i = 0;i < carTypeList.size();i++){
            if(carTypeList.get(i).getGarage().equals(garage)){
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public List<CarType> BrandFilter(List<CarType> carTypeList,String carBrand){
        if(carBrand == null){
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if(carTypeList == null){
            return null;
        }
        for(int i = 0;i < carTypeList.size();i++){
            if(carTypeList.get(i).getBrand().equals(carBrand)){
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public List<CarType> SFXFilter(List<CarType> carTypeList,String sfx){
        if(sfx == null){
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if(carTypeList == null){
            return null;
        }
        for(int i = 0;i < carTypeList.size();i++){
            if(carTypeList.get(i).getCarSfx().equals(sfx)){
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public List<CarType> ColorFilter(List<CarType> carTypeList,String carColor){
        if(carColor == null){
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if(carTypeList == null){
            return null;
        }
        for(int i = 0;i < carTypeList.size();i++){
            if(carTypeList.get(i).getCarColor().equals(carColor)){
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public CarType getCarTypeByID(CarTypeID carTypeID) {
        List<CarType> carTypeList = getAllCarType();
        carTypeList = GarageBrandFilter(carTypeList,carTypeID.getGarage());
        carTypeList = BrandFilter(carTypeList,carTypeID.getBrand());
        carTypeList = ColorFilter(carTypeList,carTypeID.getColor());
        carTypeList = SFXFilter(carTypeList,carTypeID.getSfx());
        if(carTypeList == null || carTypeList.size() == 0){
            return null;
        }
        return carTypeList.get(0);
    }

    public List<Car> CarGarageBrandFilter(List<Car> cars,String garage){
        if(garage == null){
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if(cars == null){
            return null;
        }
        for(int i = 0;i < cars.size();i++){
            if(cars.get(i).getGarage().equals(garage)){
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> CarBrandFilter(List<Car> cars,String brand){
        if(brand == null){
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if(cars == null){
            return null;
        }
        for(int i = 0;i < cars.size();i++){
            if(cars.get(i).getBrand().equals(brand)){
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> CarColorFilter(List<Car> cars,String color){
        if(color == null){
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if(cars == null){
            return null;
        }
        for(int i = 0;i < cars.size();i++){
            if(cars.get(i).getColor().equals(color)){
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> CarSFXFilter(List<Car> cars,String SFX){
        if(SFX == null){
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if(cars == null){
            return null;
        }
        for(int i = 0;i < cars.size();i++){
            if(cars.get(i).getSfx().equals(SFX)){
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> findCarByCarType(CarTypeID carTypeID){
        List<Car> result = getAllCars();
        result = CarGarageBrandFilter(result,carTypeID.getGarage());
        result = CarBrandFilter(result,carTypeID.getBrand());
        result = CarColorFilter(result,carTypeID.getColor());
        result = CarSFXFilter(result,carTypeID.getSfx());
        if(result != null && result.size() > 0){
            return result;
        }
        return null;
    }

    public int getCarAge(String carID){
        Car car = findCarById(carID);
        if(car == null){
            return -1;
        }
        Date purchaseDay = car.getPurchasedTime();
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();

        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            purchaseDay=sdf.parse(sdf.format(purchaseDay));
            today = sdf.parse(sdf.format(new Date()));
        }
        catch (ParseException e){
            e.printStackTrace();
            return -1;
        }
        calendar.setTime(purchaseDay);
        long time1 = calendar.getTimeInMillis();
        calendar.setTime(today);
        long time2 = calendar.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public Map<Car,Integer> getCarAgeList(){
        List<Car> cars = getAllCars();
        if(cars == null){
            return null;
        }
        Map<Car,Integer> result = new HashMap<>();
        int age;
        for(int i = 0;i < cars.size();i++){
            age = getCarAge(cars.get(i).getCarID());
            result.put(cars.get(i),age);
        }
        return result;
    }

    public Map<Car,Integer> getCarAgeListByCarType(CarTypeID carTypeID){
        List<Car> cars = findCarByCarType(carTypeID);
        if(cars == null){
            return null;
        }
        Map<Car,Integer> result = new HashMap<>();
        int age;
        for(int i = 0;i < cars.size();i++){
            age = getCarAge(cars.get(i).getCarID());
            result.put(cars.get(i),age);
        }
        return result;
    }

    public List<CarBrand> getCarBrandsByGarage(String garage){
        List<CarBrand> carBrandList = getAllCarBrands();
        List<CarBrand> result = new ArrayList<>();
        if(garage == null){
            return carBrandList;
        }
        if(carBrandList == null || carBrandList.size() == 0){
            return null;
        }
        for(int i = 0;i < carBrandList.size();i++){
            if(carBrandList.get(i).getGarage().equals(garage)){
                result.add(carBrandList.get(i));
            }
        }
        return result;
    }

    public boolean garageExist(String brand){
        Garage garage = garageDAO.findGarageByBrand(brand);
        if(garage == null || garage.getValid().equals('N')){
            return false;
        }
        return true;
    }

    public boolean brandExist(String garage,String brand){
        if(!garageExist(garage)){
            return false;
        }
        List<CarBrand> carBrandList = getCarBrandsByGarage(garage);
        if(carBrandList == null){
            return false;
        }
        for(int i = 0;i < carBrandList.size();i++){
            if(carBrandList.get(i).getBrand().equals(brand) && carBrandList.get(i).getValid().equals("Y")){
                return true;
            }
        }
        return false;
    }

    public boolean colorExist(String color){
        CarColor carColor = colorDAO.getColorByID(color);
        if(carColor == null || carColor.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean sfxExist(String sfx){
        CarSFX carSFX = sfxdao.findCarSFXById(sfx);
        if(carSFX == null || carSFX.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean carTypeExist(CarTypeID carTypeID){
        CarType carType = getCarTypeByID(carTypeID);
        if(carType == null || carType.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean stockStatusExist(String stock){
        StockStatus stockStatus = stockStatusDAO.getStockStatusByID(stock);
        if(stockStatus == null || stockStatus.getValid().equals("N")){
            return false;
        }
        return true;
    }
}
