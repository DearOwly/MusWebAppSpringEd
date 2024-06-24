package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.model.base.AbstractEntity;
import so.sonya.muswebapp2.model.user.User;

import java.util.Set;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@With
@Getter
@Setter
public class Comment extends AbstractEntity {
    String text;

    @ManyToOne(fetch = FetchType.LAZY)
    User author;

    @OneToMany
    Set<Like> likes;

    public void addLike(Like like) {
        likes.add(like);
    }

    public void removeLike(Like like) {
        likes.remove(like);
    }

    public Comment withLike(Like like) {
        addLike(like);
        return this;
    }
}
