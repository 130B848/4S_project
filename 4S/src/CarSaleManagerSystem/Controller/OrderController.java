package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Service.BudgetService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by googo on 16/8/10.
 */

@Controller
@RequestMapping(value = "/Order")
public class OrderController {
    @Autowired
    private BudgetService budgetService;


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView createOrderPage(){
        ModelAndView modelAndView = new ModelAndView("Order/showOrder");
       // modelAndView.addObject("order", new Order());
        return modelAndView;
    }

    @RequestMapping(value = "/list/{carID}", method = RequestMethod.POST)
    @ResponseBody
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
}
