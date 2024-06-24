package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.model.base.AbstractEntity;
import so.sonya.muswebapp2.model.user.User;

import java.util.Set;

@Entity
@Table(name = "threads")
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@With
@Setter
@Getter
public class Thread extends AbstractEntity {
    @Column(length = 40)
    String title;

    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    User author;

    @OneToMany
    Set<Message> messages;

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public Thread withMessage(Message message) {
        addMessage(message);
        return this;
    }
}
