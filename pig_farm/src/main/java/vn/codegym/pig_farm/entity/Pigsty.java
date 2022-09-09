package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pigsty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(30)")
    private String code;

    @Column(columnDefinition = "DATE")
    private LocalDate creationDate;

    @Column(columnDefinition = "DATE")
    private LocalDate buildDate;

    private Integer maxNumber;

    @Column(columnDefinition = "BIT")
    private Boolean isDeleted;

//    @JsonBackReference
    @OneToMany(mappedBy = "pigsty")
    private List<Food> foods;

    @JsonBackReference
    @OneToMany(mappedBy = "pigsty")
    private List<Vaccination> vaccinations;

//    @JsonBackReference
    @OneToMany(mappedBy = "pigsty")
    private List<Pig> pigs;

//    @JsonBackReference
    @OneToMany(mappedBy = "pigsty")
    private List<Export> exports;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
