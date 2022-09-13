package vn.codegym.pig_farm.dto.projection;

import java.time.LocalDate;

/**
 * Create by HaiTV
 * Date : 08/09/2022
 */
public interface INotificationDto {
    Integer getId();

    String getTitle();
    String getContent();

    LocalDate getSubmittedDate();

    String getImage();

}
