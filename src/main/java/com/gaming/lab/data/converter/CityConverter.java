package com.gaming.lab.data.converter;

import com.gaming.lab.data.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityConverter implements Converter<String, User.City> {
    @Override
    public User.City convert(String source)
    {
        return User.City.valueOf(source.toUpperCase());
    }
}
