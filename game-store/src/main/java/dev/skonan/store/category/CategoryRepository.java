package dev.skonan.store.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

    // JPQL syntax
    @Query("""
            SELECT c FROM Category c
            WHERE c.name LIKE lower(:name)
            ORDER BY c.name ASC
            """)
    List<Category> findAllByName(@Param("name") String categoryName);
}
