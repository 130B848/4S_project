package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.form.LabelTag;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/**
 * Created by googo on 16/8/10.
 */

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;
    @Autowired
    private GiftService giftService;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(value = "/detail/{carID}", method = RequestMethod.GET)
    public ModelAndView orderDetailPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Order/orderDetail");
        Car car = carService.findCarById(carID);
        Order order = orderService.findOrderByCar(carID);
        //Customer customer = order.getCustomer();
        List<Gift> giftSet = giftService.findGiftByOrderId(order.getOrderID());
        List<Insurance> insurances = null;

        modelAndView.addObject("car", car);
        modelAndView.addObject("order", order);
        modelAndView.addObject("gifts", giftSet);
        modelAndView.addObject("insurances", insurances);
        //modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @RequestMapping(value = "/detail/{carID}", method = RequestMethod.POST)
    public void listOrder(@PathVariable String carID, HttpServletResponse response){
        JSONObject orderInfo = budgetService.getOrderInfo(carID);

        PrintWriter printWriter;
        try {
            printWriter = response.getWriter();
            printWriter.write(orderInfo.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addCarToOrder/{carID}",method = RequestMethod.GET)
    public ModelAndView addCarToOrderPage(@PathVariable String carID){
        ModelAndView modelAndView = new ModelAndView("Order/addCarToOrderPage");
        Car car = carService.findCarById(carID);
        modelAndView.addObject("car",car);
        return modelAndView;
    }

    @RequestMapping(value = "/addCarToOrder",method = RequestMethod.POST)
    public ModelAndView addCarToOrder(){
        ModelAndView modelAndView = new ModelAndView("Order/addCarToOrderPage");

        return modelAndView;
    }



}
