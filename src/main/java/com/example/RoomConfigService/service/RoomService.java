package com.example.RoomConfigService.service;

import com.example.RoomConfigService.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room crear(Room room);
    
    List<Room> listarTodas();
    Optional<Room> buscarPorId(Long id);
    void eliminar(Long id);
}
