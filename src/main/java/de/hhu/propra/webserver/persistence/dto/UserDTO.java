package de.hhu.propra.webserver.persistence.dto;

import lombok.*;

// It is allowed to use the wildcard import for persistence annotations.
import javax.persistence.*;

// Spring Data JDBC always requires the DTO's to have default constructors.
// Thus all DTO's have to be annotated with @DefaultConstructor.
// It is also very important for the DTO's fields to be non-final and non-private.

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserDTO {

    @Column(name = "username")
    @Id
    String username;

    String password;

    String salt;
}
