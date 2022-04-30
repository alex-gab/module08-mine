package com.spring.professional.exam.tutorial.module08.question03.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GuestSharableDataService {

    private final GuestRegistrationService guestRegistrationService;

    public GuestSharableDataService(GuestRegistrationService guestRegistrationService) {
        this.guestRegistrationService = guestRegistrationService;
    }

    public String getGuestSharableData() {
        return guestRegistrationService.listGuests().stream()
                .map(guest -> guest.getFirstName() + " " + guest.getLastName())
                .collect(Collectors.joining(", "));
    }
}
