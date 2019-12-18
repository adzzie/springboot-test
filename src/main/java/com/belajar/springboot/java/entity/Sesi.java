package com.belajar.springboot.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description Sesi
 *
 * @author aji gojali
 */
@Entity
public class Sesi {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Temporal(TemporalType.DATE)
    private Date mulai;

    @Temporal(TemporalType.DATE)
    private Date sampai;

    @ManyToOne
    @JoinColumn(name = "id_materi") @NotNull
    private Materi materi;

    @ManyToMany
    @JoinTable(
            name = "peserta_pelatihan",
            joinColumns = @JoinColumn(name = "id_sesi"),
            inverseJoinColumns = @JoinColumn(name = "id_peserta")
    )
    private List<Peserta> daftarPeserta = new ArrayList<>();
}
