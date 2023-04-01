package ru.hukola.beprog.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Babin Nikolay
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String contentPath;
    @ManyToOne
    private Chapter chapter;
}
