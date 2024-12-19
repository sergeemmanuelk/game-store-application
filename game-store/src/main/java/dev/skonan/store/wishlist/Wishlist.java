package dev.skonan.store.wishlist;

import dev.skonan.store.common.BaseEntity;
import dev.skonan.store.game.Game;
import dev.skonan.store.user.User;
import jakarta.persistence.*;
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
@Table(name = "wishlists")
public class Wishlist extends BaseEntity {
    private String name;

    @OneToOne
    private User user;

    @ManyToMany(mappedBy = "wishlists", fetch = FetchType.EAGER)
    private List<Game> games;
}
