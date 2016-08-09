package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.Gift;
import CarSaleManagerSystem.Bean.Insurance;
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


    /*
    * Gift controller
    * */
    @RequestMapping(value = "/createGift", method = RequestMethod.GET)
    public ModelAndView createGiftPage(){
        ModelAndView modelAndView = new ModelAndView("Sales/giftCreate");
        modelAndView.addObject("gift", new Gift());
        return modelAndView;
    }

    @RequestMapping(value = "/createGift", method = RequestMethod.POST)
    public ModelAndView createGift(@ModelAttribute Gift gift){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sales/giftList");
        System.out.println(gift.getGiftID() + "name");

        System.out.println(gift.getName() + "name");
        System.out.println(gift.getType() + "name");
        System.out.println(gift.getCost() + "name");
        System.out.println(gift.getDefault_price() + "price");
        giftService.createGift(gift);
        return modelAndView;
    }

    @RequestMapping(value = "/listGift", method = RequestMethod.GET)
    public ModelAndView listGift(){
        ModelAndView modelAndView = new ModelAndView("Sales/giftList");
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

    @RequestMapping(value = "/delete/{giftID}", method = RequestMethod.GET)
    public ModelAndView removeGift(@PathVariable int giftID){
        ModelAndView modelAndView = new ModelAndView("redirect: /Sales/giftList");
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
        ModelAndView modelAndView = new ModelAndView("Sales/insuranceCreate");
        modelAndView.addObject("insurance", new Insurance());
        return modelAndView;
    }

    @RequestMapping(value = "/createInsurance", method = RequestMethod.POST)
    public ModelAndView createInsurance(@ModelAttribute Insurance insurance){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sales/insuranceList");
        insuranceService.createInsurance(insurance);
        return modelAndView;
    }

    @RequestMapping(value = "/listInsurance", method = RequestMethod.GET)
    public ModelAndView listInsurance(){
        ModelAndView modelAndView = new ModelAndView("Sales/insuranceList");
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

    @RequestMapping(value = "/delete/{insuranceID}", method = RequestMethod.GET)
    public ModelAndView removeInsurance(@PathVariable int insuranceID){
        ModelAndView modelAndView = new ModelAndView("redirect: /Sales/insuranceList");
        Insurance insurance = insuranceService.findInsuranceById(insuranceID);
        insuranceService.removeInsurance(insurance);
        return modelAndView;
    }

}
