package dev.skonan.store.game;

import dev.skonan.store.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public void something(String categoryId) {
        Category category = new Category();

        var games = gameRepository.findAllByCategoryId(categoryId);
    }
}
