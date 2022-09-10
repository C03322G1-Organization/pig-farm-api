package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


/**
 * Create by: DongLHP
 * Date create: 08/09/2022
 * Function: Create Entity
=======
/**
 * Created by : HoaL
 * Date create : 08/09/2022
 * entity : Export
>>>>>>> export-port-HoaL
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

    private Double price;

    private String typePigs;

    @ColumnDefault("0")
    @Column(columnDefinition = "BIT(1) DEFAULT 0")

    private Boolean isDeleted;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pigsty_id", referencedColumnName = "id")
    private Pigsty pigsty;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
