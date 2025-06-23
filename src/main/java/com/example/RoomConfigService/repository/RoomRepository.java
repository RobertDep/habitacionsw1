package com.example.RoomConfigService.repository;

import com.example.RoomConfigService.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // si luego quieres búsquedas más específicas, aquí las añades
}