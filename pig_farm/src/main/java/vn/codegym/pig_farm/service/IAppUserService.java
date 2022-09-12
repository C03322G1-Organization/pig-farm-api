package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.AppUser;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IAppUserService {

    AppUser findByName(String name);

    String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException;
}
