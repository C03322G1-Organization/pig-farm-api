package vn.codegym.pig_farm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Export {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "VARCHAR(50)")
    private String codeExport;

    @Column(columnDefinition = "VARCHAR(50)")
    private String company;

    private Double price;

    @ColumnDefault("0")
    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;


    @Column(columnDefinition = "DATE")
    private LocalDate startDate;

    private Integer amount;

    private Double kilogram;

    private Double totalMoney;


    @Column(columnDefinition = "BIT(1) default 0")
    private int typePigs;

    @ManyToOne
    @JoinColumn(name = "pigsty_id", referencedColumnName = "id")
    private Pigsty pigsty;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
