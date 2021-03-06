package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Gift;
import CarSaleManagerSystem.Bean.GiftType;
import CarSaleManagerSystem.DAO.GiftDAO;
import CarSaleManagerSystem.DAO.GiftTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Service
@Transactional
public class GiftService {
    @Autowired
    private GiftDAO giftDAO;

    @Autowired
    private GiftTypeDAO giftTypeDAO;

    public void createGift(Gift gift){
        if(giftExist(gift.getGiftID())){
            return;
        }
        if(giftDAO.findGiftById(gift.getGiftID()) != null){
            gift.setValid("Y");
            giftDAO.updateGift(gift);
            return;
        }
        gift.setValid("Y");
        giftDAO.createGift(gift);
    }

    public List<Gift> getAllGifts(){
        return giftDAO.getAllGifts();
    }

    public void removeGift(Gift gift){
        if(giftExist(gift.getGiftID())){
            gift.setValid("N");
            giftDAO.updateGift(gift);
        }
//        giftDAO.removeGift(gift);
    }

    public void updateGift(Gift gift){giftDAO.updateGift(gift);}

    public Gift findGiftById(int giftID){return  giftDAO.findGiftById(giftID);}

    public void createGiftType(GiftType giftType){
        if(giftTypeExist(giftType.getType())){
            return;
        }
        if(giftTypeDAO.findGiftTypeById(giftType.getType()) != null){
            giftType.setValid("Y");
            giftTypeDAO.updateGiftType(giftType);
            return;
        }
        giftType.setValid("Y");
        giftTypeDAO.createGiftType(giftType);
    }

    public GiftType findGiftTypeById(String type){
        return giftTypeDAO.findGiftTypeById(type);
    }

    public List<GiftType> getAllGiftTypes(){
        return giftTypeDAO.getAllGiftTypes();
    }

    public List<Gift> findGiftByOrderId(String orderId){
        List<Gift> gifts = getAllGifts();
        if(gifts == null){
            return null;
        }
        List<Gift> result = new ArrayList<>();
        if(orderId == null){
            return gifts;
        }
        for(int i = 0;i < gifts.size();i++){
            if(gifts.get(i).getOrderID().equals(orderId)){
                result.add(gifts.get(i));
            }
        }
        return result;
    }

    public boolean giftExist(int giftID){
        Gift gift = giftDAO.findGiftById(giftID);
        if(gift == null){
            return false;
        }
        if(gift.getValid().equals("N")){
            return false;
        }
        return true;
    }

    public boolean giftTypeExist(String giftTypeId){
        GiftType giftType = giftTypeDAO.findGiftTypeById(giftTypeId);
        if(giftType == null){
            return false;
        }
        if(giftType.getValid().equals("N")){
            return false;
        }
        return true;
    }
}