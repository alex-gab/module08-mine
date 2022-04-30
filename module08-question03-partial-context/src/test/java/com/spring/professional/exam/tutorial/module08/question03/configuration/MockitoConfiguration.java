package com.spring.professional.exam.tutorial.module08.question03.configuration;

import com.spring.professional.exam.tutorial.module08.question03.service.GuestRegistrationService;
import com.spring.professional.exam.tutorial.module08.question03.service.GuestSharableDataService;
import com.spring.professional.exam.tutorial.module08.question03.service.HotelManagementService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockitoConfiguration {
    @Bean
    public GuestRegistrationService guestRegistrationService() {
        return Mockito.mock(GuestRegistrationService.class);
    }

    @Bean
    public HotelManagementService hotelManagementService() {
        return Mockito.mock(HotelManagementService.class);
    }

    @Bean
    public GuestSharableDataService guestSharableDataService() {
        return Mockito.mock(GuestSharableDataService.class);
    }
}
