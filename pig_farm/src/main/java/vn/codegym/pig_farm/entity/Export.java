package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by : HoaL
 * Date create : 08/09/2022
 * entity : Export
 */
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

    @Column(columnDefinition = "DATE")
    private LocalDate startDate;

    private Integer amount;

    private Double kilogram;

    private Double price;

    private String typePigs;

    @Column(columnDefinition = "BIT")
    @ColumnDefault("0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "pigsty_id", referencedColumnName = "id")
    private Pigsty pigsty;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
