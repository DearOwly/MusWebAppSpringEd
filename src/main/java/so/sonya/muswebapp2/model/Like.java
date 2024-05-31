package so.sonya.muswebapp2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "likes")
public class Like extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    User followed;
}
