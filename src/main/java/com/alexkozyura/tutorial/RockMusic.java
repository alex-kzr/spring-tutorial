package com.alexkozyura.tutorial;

import org.springframework.stereotype.Component;

@Component("rockMusic")
public class RockMusic implements Music{
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
