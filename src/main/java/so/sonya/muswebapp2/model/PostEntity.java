package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "post")
public class PostEntity extends AbstractEntity{
    String text;
    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity author;
    @OneToMany
    Set<CommentEntity> comments;
    @OneToMany
    Set<LikeEntity> like;
}
