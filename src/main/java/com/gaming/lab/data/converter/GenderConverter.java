package com.gaming.lab.data.converter;

import com.gaming.lab.data.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenderConverter implements Converter<String, User.Gender> {
    @Override
    public User.Gender convert(String source) {
        return User.Gender.valueOf(source.toUpperCase());
    }
}
