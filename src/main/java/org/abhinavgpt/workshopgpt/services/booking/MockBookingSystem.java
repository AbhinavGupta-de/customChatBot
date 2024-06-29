package org.abhinavgpt.workshopgpt.services.booking;

import java.util.function.Function;

public class MockBookingSystem implements Function<MockBookingSystem.Request, MockBookingSystem.Response> {
    public record Request(String location) {}
    public record Response(String name) {}

    public Response apply(Request request)
    {
        return new Response("Hotel PhirAnana");
    }

}
