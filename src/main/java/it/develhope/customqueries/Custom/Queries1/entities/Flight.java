package it.develhope.customqueries.Custom.Queries1.entities;

import it.develhope.customqueries.Custom.Queries1.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String fromAirport;
    @Column(nullable = false)
    private String toAirport;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

}
