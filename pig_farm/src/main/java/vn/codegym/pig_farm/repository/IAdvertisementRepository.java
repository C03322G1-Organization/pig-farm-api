package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Advertisement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
public interface IAdvertisementRepository extends JpaRepository<Advertisement,Integer> {
    @Query(value = "select * from advertisement where is_deleted = 0",nativeQuery = true)
    List<Advertisement> findAllAdvertisement();

    /**
     * Created by : ChungHV
     * Date created : 9/8/2022
     * Function: Post advertisement
     * @param image
     * @param submittedDate
     * @param timeExistence
     * @param title
     * @param placement
     */

    @Modifying
    @Query(value ="insert into advertisement(image,submitted_date,time_existence,title,placement_id)" +
            "values (:image,:submittedDate,:timeExistence,:title,:placement)",nativeQuery = true)
    void saveAdvertisement(@Param("image") String image,
                           @Param("submittedDate") LocalDate submittedDate,
                           @Param("timeExistence") String timeExistence,
                           @Param("title") String title,
                           @Param("placement") Integer placement);

    /**
     * Created by :ChungHV
     * Date created : 9/8/2022
     * Function : Update advertisement
     * @param image
     * @param submittedDate
     * @param timeExistence
     * @param title
     * @param placement
     * @param id
     */
    @Modifying
    @Query( value = "update advertisement set image =:image, submitted_date =:submittedDate, time_existence =:timeExistence," +
            "title =:title, placement_id =:placement where id =:id", nativeQuery = true)
    void updateAdvertisement(@Param("image") String image,
                             @Param("submittedDate") LocalDate submittedDate,
                             @Param("timeExistence") String timeExistence,
                             @Param("title") String title,
                             @Param("placement") Integer placement,
                             @Param("id") Integer id);

    /**
     * Created by :ChungHV
     * Date created : 9/8/2022
     * Function : FindById advertisement
     * @param id
     * @return : Optional<Advertisement>
     */
    @Query(value = "select * from advertisement where id =:id",nativeQuery = true)
    Optional<Advertisement> findById(@Param("id") Integer id);

}
