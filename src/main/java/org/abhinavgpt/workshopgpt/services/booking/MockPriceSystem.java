package org.abhinavgpt.workshopgpt.services.booking;

import java.util.function.Function;

public class MockPriceSystem implements Function<MockPriceSystem.Request, MockPriceSystem.Response> {

    public record Request() {};
    public record Response(double price) {};

    @Override
    public Response apply(Request request) {
        return new Response(69.73);
    }
}
