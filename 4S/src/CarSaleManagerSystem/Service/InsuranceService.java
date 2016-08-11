package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.Insurance;
import CarSaleManagerSystem.Bean.InsuranceType;
import CarSaleManagerSystem.DAO.InsuranceDAO;
import CarSaleManagerSystem.DAO.InsuranceTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HFQ on 2016/8/9.
 */
@Service
@Transactional
public class InsuranceService {
    @Autowired
    private InsuranceDAO insuranceDAO;

    @Autowired
    private InsuranceTypeDAO insuranceTypeDAO;

    public void createInsurance(Insurance insurance){insuranceDAO.createInsurance(insurance);}

    public List<Insurance> getAllInsurance(){return insuranceDAO.getAllInsurances();}

    public void removeInsurance(Insurance insurance){insuranceDAO.removeInsurance(insurance);}

    public void updateInsurance(Insurance insurance){insuranceDAO.updateInsurance(insurance);}

    public Insurance findInsuranceById(int insuranceID){return insuranceDAO.findInsuranceById(insuranceID);}

    public void createInsuranceType(InsuranceType insuranceType){
        insuranceTypeDAO.createInsuranceType(insuranceType);
    }

    public List<InsuranceType> getAllInsuranceType(){
        return insuranceTypeDAO.getAllInsuranceTypes();
    }
}
