package com.example.RoomConfigService.service;

import com.example.RoomConfigService.model.Room;
import com.example.RoomConfigService.repository.RoomRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repo;

    public RoomServiceImpl(RoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public Room crear(Room habitacion) {
        return repo.save(habitacion);
    }

    @Override
    public List<Room> listarTodas() {
        return repo.findAll();
    }

    @Override
    public Optional<Room> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}