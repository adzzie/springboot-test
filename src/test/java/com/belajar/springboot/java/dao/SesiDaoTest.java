package com.belajar.springboot.java.dao;

import com.belajar.springboot.java.entity.Materi;
import com.belajar.springboot.java.entity.Peserta;
import com.belajar.springboot.java.entity.Sesi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description PesertaDaoTest
 *
 * @author aji gojali
 */
@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //untuk order eksekusi
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"/data/peserta.sql","/data/materi.sql","/data/sesi.sql"}
)
public class SesiDaoTest {

    @Autowired
    private SesiDao sd;

    @Test
    public void testCariByMateri(){
        Materi m = new Materi();
        m.setId("aa6");

        PageRequest page = PageRequest.of(0,5);

        Page<Sesi> hasilQuery = sd.findByMateri(m, page);
        assertEquals(2L,hasilQuery.getTotalElements());

        assertFalse(hasilQuery.getContent().isEmpty());
        Sesi s =hasilQuery.getContent().get(0);
        assertNotNull(s);
        assertEquals("Java Fundamental",s.getMateri().getNama());
    }

    @Test
    public void testCariBerdasarkanTanggalMulaiDanKodeMateri() throws ParseException {
        PageRequest page = PageRequest.of(0,5);
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date sejak = formater.parse("2019-01-01");
        Date sampai = formater.parse("2019-01-03");

        Page<Sesi> hasil = sd.cariBerdasarkanTanggalMulaiDanKodeMateri(sejak, sampai,"JF-002", page);
        assertEquals(1L,hasil.getTotalElements());
        assertFalse(hasil.getContent().isEmpty());

        Sesi s = hasil.getContent().get(0);
        assertEquals("Java Web",s.getMateri().getNama());
    }

}
