package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "threads")
public class Thread extends AbstractEntity {
    @Column(length = 40)
    String title;

    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    User author;

    @OneToMany
    Set<Message> messages;
}
