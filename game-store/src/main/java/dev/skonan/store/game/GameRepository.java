package dev.skonan.store.game;

import dev.skonan.store.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, String> {
    // find all games by category (v1)
    List<Game> findAllByCategory(Category category);

    // find all games by category (v1)
    List<Game> findAllByCategoryId(String categoryId);

    // find all the games where the name equals 'Action'
    List<Game> findAllByCategoryName(String categoryName);

    @Query("""
            SELECT g FROM Game g
            INNER JOIN Category c ON g.category.id = c.id
            WHERE c.name LIKE :categoryName
            """)
    List<Game> findAllByCategory(@Param("categoryName") String categoryName);
}
