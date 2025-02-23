package dev.skonan.store.game;

import dev.skonan.store.category.Category;
import dev.skonan.store.comment.Comment;
import dev.skonan.store.common.BaseEntity;
import dev.skonan.store.wishlist.Wishlist;
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
@Table(name = "games")
public class Game extends BaseEntity {
    private String title;

    @Enumerated(EnumType.STRING)
    private SupportedPlatforms supportedPlatforms;

    private String coverPicture;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "game")
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "game_wishlist",
            joinColumns = {
                    @JoinColumn(name = "game_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "wishlist_id")
            }
    )
    private List<Wishlist> wishlists;

    public void addWishlist(Wishlist wishlist) {
        this.wishlists.add(wishlist);
        wishlist.getGames().add(this);
    }

    public void removeWishlist(Wishlist wishlist) {
        this.wishlists.remove(wishlist);
        wishlist.getGames().remove(this);
    }

}
