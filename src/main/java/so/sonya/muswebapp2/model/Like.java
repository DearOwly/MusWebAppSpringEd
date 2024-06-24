package so.sonya.muswebapp2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import so.sonya.muswebapp2.model.base.AbstractEntity;
import so.sonya.muswebapp2.model.user.User;

@Entity
@Table(name = "likes")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@With
@Getter
@Setter
public class Like extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
}
