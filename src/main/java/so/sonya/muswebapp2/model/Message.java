package so.sonya.muswebapp2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.model.base.AbstractEntity;
import so.sonya.muswebapp2.model.user.User;

import java.util.Set;

@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@With
@Getter
@Setter
public class Message extends AbstractEntity {
    @ManyToOne
    User author;

    String text;

    @OneToMany
    Set<Like> likes;

    public void addLike(Like like) {
        likes.add(like);
    }

    public void removeLike(Like like) {
        likes.remove(like);
    }

    public Message withLike(Like like) {
        addLike(like);
        return this;
    }
}
