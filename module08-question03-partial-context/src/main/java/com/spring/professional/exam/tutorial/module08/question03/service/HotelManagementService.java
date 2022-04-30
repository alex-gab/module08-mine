package com.spring.professional.exam.tutorial.module08.question03.service;

import com.spring.professional.exam.tutorial.module08.question03.ds.Room;
import com.spring.professional.exam.tutorial.module08.question03.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HotelManagementService {

    private final RoomRepository roomRepository;

    public HotelManagementService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void registerRoom(Room room) {
        roomRepository.save(room);
    }

    public Set<Room> listRooms() {
        return roomRepository.findAll();
    }
}
