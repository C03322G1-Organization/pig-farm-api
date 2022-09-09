package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Advertisement;

import java.util.List;
import java.util.Optional;

public interface IAdvertisementService {
    /**
     * Created by :ChungHV
     * Date created : 9/8/2022
     * Function : Post advertisement
     */
    void saveAdvertisement(Advertisement advertisement);
    /**
     * Created by :ChungHV
     * Date created : 9/8/2022
     * Function : Update advertisement
     */
    void updateAdvertisement(Advertisement advertisement);
    /**
     * Created by :ChungHV
     * Date created : 9/8/2022
     * Function : FindById advertisement
     */
    Optional<Advertisement> findById(Integer id);
}
