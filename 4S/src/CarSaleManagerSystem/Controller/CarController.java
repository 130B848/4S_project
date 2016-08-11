package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by HFQ on 2016/8/7.
 */
@Controller
@RequestMapping(value = "/Car")
public class CarController {
    @Autowired
    private CarService carService;

    private LoginFilter loginFilter = new LoginFilter();

    @RequestMapping(value = "/createStock",method = RequestMethod.GET)
    public ModelAndView createStockPage(){
        ModelAndView modelAndView = new ModelAndView("Car/carStockRegister");
        List<?> garageList = carService.getAllGarages();
        List<?> carBrandList = carService.getAllCarBrands();
        List<?> colorList = carService.getAllColors();
        List<?> statusList = carService.getAllStockStatus();
        List<?> sfxList = carService.getAllCarSFX();
        modelAndView.addObject("garages",garageList);
        modelAndView.addObject("carBrands",carBrandList);
        modelAndView.addObject("colors",colorList);
        modelAndView.addObject("statusList",statusList);
        modelAndView.addObject("sfxList",sfxList);
        modelAndView.addObject("car",new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/createStock",method = RequestMethod.POST)
    public ModelAndView createStock(@ModelAttribute Car car){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/list");
        carService.createCar(car);
        return modelAndView;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView listCar(HttpSession session) {
//        ModelAndView modelAndView = loginFilter.adminLogin(session);
//        if (modelAndView != null)
//            return modelAndView;
        ModelAndView modelAndView = new ModelAndView("Car/carList");
        List<?> carList = carService.getAllCars();
        modelAndView.addObject("cars",carList);
        return modelAndView;
    }

    @RequestMapping(value = "/setCost/{carID}",method = RequestMethod.GET)
    public ModelAndView setCarCostPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Car/carSetPrice");
        Car car = carService.findCarById(carID);
        if(car != null){
            modelAndView.addObject("car",car);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/setCost/{carID}",method = RequestMethod.POST)
    public ModelAndView setCarCostPage(@PathVariable String carID,@ModelAttribute Car car){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/list");
        Car stockCar = carService.findCarById(carID);
        if(stockCar != null){
            stockCar.setCost(car.getCost());
            stockCar.setPrice(car.getPrice());
            stockCar.setDiscount(car.getDiscount());
            carService.updateCar(stockCar);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/createGarage",method = RequestMethod.GET)
    public ModelAndView createGaragePage(){
        ModelAndView modelAndView = new ModelAndView("Car/createGarage");
        modelAndView.addObject("garage",new Garage());
        return modelAndView;
    }

    @RequestMapping(value = "/createGarage",method = RequestMethod.POST)
    public ModelAndView createGarage(@ModelAttribute Garage garage){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createGarage(garage);
        return modelAndView;
    }

    @RequestMapping(value = "/createCarBrand",method = RequestMethod.GET)
    public ModelAndView createCarBrandPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createCarBrand");
        List<Garage> garageList = carService.getAllGarages();
        modelAndView.addObject("carBrand",new CarBrand());
        modelAndView.addObject("garages",garageList);
        return modelAndView;
    }

    @RequestMapping(value = "/createCarBrand",method = RequestMethod.POST)
    public ModelAndView createCarBrand(@ModelAttribute CarBrand carBrand){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createCarBrand(carBrand);
        return modelAndView;
    }

    @RequestMapping(value = "/createColor",method = RequestMethod.GET)
    public ModelAndView createColorPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createColor");
        modelAndView.addObject("color",new CarColor());
        return modelAndView;
    }

    @RequestMapping(value = "/createColor",method = RequestMethod.POST)
    public ModelAndView createColor(@ModelAttribute CarColor carColor){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createColor(carColor);
        return modelAndView;
    }

    @RequestMapping(value = "/createStockStatus",method = RequestMethod.GET)
    public ModelAndView createStockStatusPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createStockStatus");
        modelAndView.addObject("stockStatus",new StockStatus());
        return modelAndView;
    }

    @RequestMapping(value = "/createStockStatus",method = RequestMethod.POST)
    public ModelAndView createStockStatus(@ModelAttribute StockStatus stockStatus){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createStockStatus(stockStatus);
        return modelAndView;
    }

    @RequestMapping(value = "/createSFX",method = RequestMethod.GET)
    public ModelAndView createSFXPage(){
        ModelAndView modelAndView = new ModelAndView("Car/createSFX");
        modelAndView.addObject("SFX",new CarSFX());
        return modelAndView;
    }

    @RequestMapping(value = "/createSFX",method = RequestMethod.POST)
    public ModelAndView createSFX(@ModelAttribute CarSFX carSFX){
        ModelAndView modelAndView = new ModelAndView("redirect:/Car/createStock");
        carService.createCarSFX(carSFX);
        return modelAndView;
    }



}
