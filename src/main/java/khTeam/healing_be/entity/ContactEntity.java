package khTeam.healing_be.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "contact")
@Data
@Entity
public class ContactEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;
}
