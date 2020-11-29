package de.hhu.propra.webserver.services;

import de.hhu.propra.webserver.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class PasswordService {

    public static String hash(String password, String salt) {
        byte[] bytes = DigestUtils.sha1(password + salt);
        String result = "";

        for(byte sha1Byte : bytes) {
            result += "" + (sha1Byte & 0xFF);
        }

        return result;
    }

    public static boolean isValid(String password, User user) {
        return hash(password, user.getSalt()).equals(user.getPassword());
    }
}
