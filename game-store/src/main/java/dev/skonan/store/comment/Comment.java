package dev.skonan.store.comment;

import dev.skonan.store.common.BaseEntity;
import dev.skonan.store.game.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private String content;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
