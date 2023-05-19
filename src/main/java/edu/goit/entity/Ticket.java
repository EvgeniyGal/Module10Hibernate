package edu.goit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    private long id;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "client_id")
    private long client_id;
    @Column(name = "from_planet_id")
    private String from_planet_id;
    @Column(name = "to_planet_id")
    private String to_planet_id;

}