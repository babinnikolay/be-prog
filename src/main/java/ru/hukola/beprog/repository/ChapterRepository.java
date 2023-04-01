package ru.hukola.beprog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hukola.beprog.model.Chapter;

/**
 * @author Babin Nikolay
 */
@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    
}
