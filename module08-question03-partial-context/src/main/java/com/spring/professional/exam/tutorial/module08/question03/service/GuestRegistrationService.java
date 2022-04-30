package com.spring.professional.exam.tutorial.module08.question03.service;

import com.spring.professional.exam.tutorial.module08.question03.ds.Guest;
import com.spring.professional.exam.tutorial.module08.question03.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestRegistrationService {

    private final GuestRepository guestRepository;

    public GuestRegistrationService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest registerGuest(Guest guest) {
        if (guest.getId() != null)
            throw new IllegalArgumentException(String.format("Guest [%s] already has ID assigned", guest));

        return guestRepository.save(guest);
    }

    public List<Guest> listGuests() {
        return guestRepository.findAll();
    }
}
