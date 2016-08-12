package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.CarService;
import CarSaleManagerSystem.Service.GiftService;
import CarSaleManagerSystem.Service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Controller
@RequestMapping(value = "/Sale")
public class SaleController {
    @Autowired
    private GiftService giftService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private CarService carService;

    /*
    * Gift controller
    * */
    @RequestMapping(value = "/createGift", method = RequestMethod.GET)
    public ModelAndView createGiftPage(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftCreate");
        List<CarBrand> carBrandList = carService.getAllCarBrands();
        List<GiftType> giftTypeList = giftService.getAllGiftTypes();
        modelAndView.addObject("gift", new Gift());
        modelAndView.addObject("carBrands",carBrandList);
        modelAndView.addObject("types",giftTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/createGift", method = RequestMethod.POST)
    public ModelAndView createGift(@ModelAttribute Gift gift){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listGift");
        giftService.createGift(gift);
        return modelAndView;
    }

    @RequestMapping(value = "/listGift", method = RequestMethod.GET)
    public ModelAndView listGift(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftList");
        List<?> giftList = giftService.getAllGifts();
        modelAndView.addObject("gifts", giftList);
        return modelAndView;
    }

    @RequestMapping(value = "/editGift",method = RequestMethod.GET)
    public ModelAndView editGiftPage(){

        // TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/editGift/{giftID}", method = RequestMethod.POST)
    public ModelAndView editGift(@ModelAttribute Gift gift){

        //// TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/deleteGift/{giftID}", method = RequestMethod.GET)
    public ModelAndView removeGift(@PathVariable int giftID){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listGift");
        Gift gift = giftService.findGiftById(giftID);
        giftService.removeGift(gift);
        return modelAndView;
    }

    /*
    * insurance controller
    *
    */
    @RequestMapping(value = "/createInsurance", method = RequestMethod.GET)
    public ModelAndView createInsurancePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/insuranceCreate");
        List<InsuranceType> insuranceTypeList = insuranceService.getAllInsuranceType();
        modelAndView.addObject("insurance", new Insurance());
        modelAndView.addObject("types",insuranceTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/createInsurance", method = RequestMethod.POST)
    public ModelAndView createInsurance(@ModelAttribute Insurance insurance){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listInsurance");
        insuranceService.createInsurance(insurance);
        return modelAndView;
    }

    @RequestMapping(value = "/listInsurance", method = RequestMethod.GET)
    public ModelAndView listInsurance(){
        ModelAndView modelAndView = new ModelAndView("Sale/insuranceList");
        List<?> insuranceList = insuranceService.getAllInsurance();
        modelAndView.addObject("insurances", insuranceList);
        return modelAndView;
    }

    @RequestMapping(value = "/editInsurance",method = RequestMethod.GET)
    public ModelAndView editInsurancePage(){

        // TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/editInsurance/{insuranceID}", method = RequestMethod.POST)
    public ModelAndView editInsurance(@ModelAttribute Insurance insurance){

        //// TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/deleteInsurance/{insuranceID}", method = RequestMethod.GET)
    public ModelAndView removeInsurance(@PathVariable int insuranceID){
        ModelAndView modelAndView = new ModelAndView("redirect: /Sale/insuranceList");
        Insurance insurance = insuranceService.findInsuranceById(insuranceID);
        insuranceService.removeInsurance(insurance);
        return modelAndView;
    }

    @RequestMapping(value = "/createGiftType",method = RequestMethod.GET)
    public ModelAndView createGiftTypePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/createGiftType");
        modelAndView.addObject("giftType",new GiftType());
        return modelAndView;
    }

    @RequestMapping(value = "/createGiftType",method = RequestMethod.POST)
    public ModelAndView createSFX(@ModelAttribute GiftType giftType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/createGift");
        giftService.createGiftType(giftType);
        return modelAndView;
    }

    @RequestMapping(value = "/listGiftType", method = RequestMethod.GET)
    public ModelAndView listGiftType(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftTypeList");
        List<?> giftTypeList = giftService.getAllGiftTypes();
        modelAndView.addObject("giftTypes", giftTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/createInsuranceType",method = RequestMethod.GET)
    public ModelAndView createInsuranceTypePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/createInsuranceType");
        modelAndView.addObject("insuranceType",new InsuranceType());
        return modelAndView;
    }

    @RequestMapping(value = "/createInsuranceType",method = RequestMethod.POST)
    public ModelAndView createInsuranceType(@ModelAttribute InsuranceType insuranceType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/createInsurance");
        insuranceService.createInsuranceType(insuranceType);
        return modelAndView;
    }

    @RequestMapping(value = "/listInsuranceType", method = RequestMethod.GET)
    public ModelAndView listInsuranceType(){
        ModelAndView modelAndView = new ModelAndView("Sale/insuranceTypeList");
        List<?> insuranceTypes = insuranceService.getAllInsuranceType();
        modelAndView.addObject("insuranceTypes",insuranceTypes);
        return modelAndView;
    }

}
