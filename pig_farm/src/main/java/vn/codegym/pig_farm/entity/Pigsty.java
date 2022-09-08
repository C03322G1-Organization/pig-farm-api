package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "pigsty")
    @JsonIgnore
    private List<Food> foods;

    @OneToMany(mappedBy = "pigsty")
    @JsonIgnore
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "pigsty")
    @JsonIgnore
    private List<Pig> pigs;

    @OneToMany(mappedBy = "pigsty")
    @JsonIgnore
    private List<Export> exports;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;
}
