package ru.hukola.beprog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hukola.beprog.model.Lesson;

/**
 * @author Babin Nikolay
 */
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
