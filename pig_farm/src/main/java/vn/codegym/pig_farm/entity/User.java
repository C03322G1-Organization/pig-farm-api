package vn.codegym.pig_farm.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
>>>>>>> origin/employee-LongNT
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(45)")
    private String username;

    @Column(columnDefinition = "VARCHAR(100)")
    private String password;

    @Column(columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate creationDate;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

<<<<<<< HEAD
    @JsonBackReference
=======
    @JsonIgnore
>>>>>>> origin/employee-LongNT
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Employee employee;

<<<<<<< HEAD
    @JsonBackReference
=======
>>>>>>> origin/employee-LongNT
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserRole> userRoles;


}
