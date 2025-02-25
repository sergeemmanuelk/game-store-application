package dev.skonan.store.category;

import dev.skonan.store.common.BaseEntity;
import dev.skonan.store.game.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Game> games;
}
