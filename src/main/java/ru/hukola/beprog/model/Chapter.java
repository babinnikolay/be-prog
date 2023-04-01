package ru.hukola.beprog.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chapter{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String contentPath;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chapter_id")
    private List<Lesson> lessons;
}
