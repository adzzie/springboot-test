package com.belajar.springboot.java.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Description Materi
 *
 * @author aji gojali
 */
@Entity
public class Materi {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull @Column(unique = true, length = 10)
    private String kode;

    @NotNull
    private String nama;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "materi"
    )
    private List<Sesi> daftarSesi = new ArrayList<>();


}
