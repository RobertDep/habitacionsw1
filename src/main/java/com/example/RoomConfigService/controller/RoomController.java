package com.example.RoomConfigService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import com.example.RoomConfigService.model.Room;
import com.example.RoomConfigService.service.RoomService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Room> crear(
      @RequestBody Room room,
      @AuthenticationPrincipal Jwt jwt        // <--- aquí tienes el token ya decodificado
  ) {
    Long userId = Long.valueOf(jwt.getClaim("userId"));      // claim que emitió Auth-Service
    String username = jwt.getSubject();                      // típicamente el sub
    room.setUserId(userId);
    room.setUsername(username);
    Room saved = service.crear(room);
    return ResponseEntity
      .created(URI.create("/api/habitaciones/" + saved.getId()))
      .body(saved);
  }
    @GetMapping
    public List<Room> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> ver(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
