package com.example.tugasKota.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tugasKota.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer>{
	@Query(value = "select * from provinsi_table where nama_provinsi = ?", nativeQuery = true)
	List<ProvinsiEntity> findByName(String namaProvinsi);
	
	@Query(value = "select nama_provinsi from provinsi_table where id = ?", nativeQuery = true)
	String findNameById(Integer id);
	@Query(value = "select kode_provinsi from provinsi_table where id = ?", nativeQuery = true)
	String findKodeById(Integer id);

	@Query(value = "select id from provinsi_table where id = ?", nativeQuery = true)
	Integer findIdById(Integer id);
	
	@Query(value = "select * from provinsi_table where status = 1", nativeQuery = true)
	List<ProvinsiEntity> findActiveId();

	@Query(value = "select * from provinsi_table where id = ?", nativeQuery = true)
	List<ProvinsiEntity> findAllById(Integer id);
	
	@Query(value = "select * from provinsi_table where kode_provinsi = ?", nativeQuery = true)
	List<ProvinsiEntity> findAllByKodeProvinsi(String kodeProvinsi);
	
	ProvinsiEntity findByKodeProvinsi(String kodeProvinsi);
	
}
