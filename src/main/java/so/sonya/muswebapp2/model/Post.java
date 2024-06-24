package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.model.base.AbstractEntity;
import so.sonya.muswebapp2.model.user.User;

import java.util.Set;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@With
@Getter
@Setter
public class Post extends AbstractEntity {
    String text;

    @ManyToOne(fetch = FetchType.LAZY)
    User author;

    @OneToMany
    Set<Comment> comments;

    @OneToMany
    Set<Like> likes;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public Post withComment(Comment comment) {
        addComment(comment);
        return this;
    }

    public void addLike(Like like) {
        likes.add(like);
    }

    public void removeLike(Like like) {
        likes.remove(like);
    }

    public Post withLike(Like like) {
        addLike(like);
        return this;
    }
}
