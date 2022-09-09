package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(columnDefinition = "varchar(100)")
    private String creator;

    @Column(columnDefinition = "BIT")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "pigsty")
    private List<Food> foods;

    @OneToMany(mappedBy = "pigsty")
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "pigsty")
    private List<Pig> pigs;

    @OneToMany(mappedBy = "pigsty")
    private List<Export> exports;


}
