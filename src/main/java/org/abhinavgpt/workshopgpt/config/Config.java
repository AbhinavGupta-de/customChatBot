package org.abhinavgpt.workshopgpt.config;

import org.abhinavgpt.workshopgpt.services.booking.MockBookingSystem;
import org.abhinavgpt.workshopgpt.services.booking.MockPriceSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    @Description("book hotel")
    public Function<MockBookingSystem.Request, MockBookingSystem.Response> hotelFunction() {
        return new MockBookingSystem();
    }

    @Bean
    @Description("price")
    public Function<MockPriceSystem.Request, MockPriceSystem.Response> hotelPrice() {
        return new MockPriceSystem();
    }
}
