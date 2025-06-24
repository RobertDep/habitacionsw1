package com.example.RoomConfigService.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double ancho;
    private Double largo;
    private Double alto;
    private Integer puertas;
    private Integer ventanas;
    private String materialPared;
    private String colorPiso;

  @Column(nullable = true)
  private Long userId;

  @Column(nullable = true)
  private String username;
}
