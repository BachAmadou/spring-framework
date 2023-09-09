package com.dev.repository;

import org.springframework.stereotype.Component;

@Component
public class RegularHours implements HourlyRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
