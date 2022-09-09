package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(45)",name = "role_name")
    private String name;

    @Column(columnDefinition = "BIT")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<UserRole> userRoles;

}
