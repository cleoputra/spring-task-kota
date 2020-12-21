package com.example.tugasKota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tugasKota.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer>{
	@Query(value = "select * from kabupaten_table where nama_kabupaten = ?", nativeQuery = true)
	List<KabupatenEntity> findByName(String namaKabupaten);
	
	@Query(value = "select nama_kabupaten from kabupaten_table where id = ?", nativeQuery = true)
	String findNameById(Integer id);
	@Query(value = "select kode_kabupaten from kabupaten_table where id = ?", nativeQuery = true)
	String findKodeById(Integer id);

	@Query(value = "select id from kabupaten_table where id = ?", nativeQuery = true)
	Integer findIdById(Integer id);
	
	@Query(value = "select * from kabupaten_table where status = 1", nativeQuery = true)
	List<KabupatenEntity> findActiveId();

	@Query(value = "select * from kabupaten_table where id = ?", nativeQuery = true)
	List<KabupatenEntity> findAllById(Integer id);

	@Query(value = "select * from kabupaten_table where kode_provinsi = ?", nativeQuery = true)
	List<KabupatenEntity> findAllByKodeProvinsi(String kodeProvinsi);
	
	KabupatenEntity findByKodeKabupaten(String kodeKabupaten);
}
