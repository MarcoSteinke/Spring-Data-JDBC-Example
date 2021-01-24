package de.hhu.propra.webserver.persistence.dto;

import lombok.*;

import javax.persistence.*;

// Spring Data JDBC benötigt immer einen DefaultConstructor
// Aus diesem Grund sollte die Klasse definitiv mit @NoArgsConstructor annotiert sein!
// Außerdem ist es auschlaggebend, dass die Felder des DTO nicht final und nicht private sind.

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
