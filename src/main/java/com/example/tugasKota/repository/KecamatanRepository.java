package com.example.tugasKota.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tugasKota.entity.KecamatanEntity;


@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer>{
	@Query(value = "select * from kecataman_table where nama_kecataman = ?", nativeQuery = true)
	List<KecamatanEntity> findByName(String namaKecataman);
	
	@Query(value = "select nama_kecataman from kecamatan_table where id = ?", nativeQuery = true)
	String findNameById(Integer id);
	@Query(value = "select kode_kecamatan from kecamatan_table where id = ?", nativeQuery = true)
	String findKodeById(Integer id);

	@Query(value = "select id from kecamatan_table where id = ?", nativeQuery = true)
	Integer findIdById(Integer id);
}

