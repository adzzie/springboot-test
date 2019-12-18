package com.belajar.springboot.java.dao;

import com.belajar.springboot.java.entity.Peserta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Description PesertaDao
 *
 * @author aji gojali
 */
public interface PesertaDao extends CrudRepository<Peserta, String>, PagingAndSortingRepository<Peserta, String> {

}
