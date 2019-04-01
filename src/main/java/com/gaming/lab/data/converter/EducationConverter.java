package com.gaming.lab.data.converter;

import com.gaming.lab.data.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EducationConverter implements Converter<String, User.Education> {
    @Override
    public User.Education convert(String source) {
        return User.Education.valueOf(source.toUpperCase());
    }
}
