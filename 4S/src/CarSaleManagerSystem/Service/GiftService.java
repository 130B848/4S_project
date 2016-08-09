package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Gift;
import CarSaleManagerSystem.DAO.GiftDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Service
@Transactional
public class GiftService {
    @Autowired
    private GiftDAO giftDAO;

    public void createGift(Gift gift){giftDAO.createGift(gift);}

    public List<Gift> getAllGifts(){return giftDAO.getAllGifts();}

    public void removeGift(Gift gift){giftDAO.removeGift(gift);}

    public void updateGift(Gift gift){giftDAO.updateGift(gift);}

    public Gift findGiftById(int giftID){return  giftDAO.findGiftById(giftID);}
}