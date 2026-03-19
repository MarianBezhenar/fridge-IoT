package com.marian.demo_gtakb;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rilevazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rilevazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rilevazione")
    private Integer idRilevazione;

    @Column(nullable = false)
    private double temperatura;

    @Column(nullable = false)
    private double umidita;

    @Column(name = "porta_aperta", nullable = false)
    private boolean portaAperta;

    @Column(name = "timestame", updatable = false, insertable = false)
    private LocalDateTime timestame;

}
