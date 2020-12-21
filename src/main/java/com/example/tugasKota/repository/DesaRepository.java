package com.example.tugasKota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tugasKota.entity.DesaEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer>{
	@Query(value = "select * from desa_table where nama_desa = ?", nativeQuery = true)
	List<DesaEntity> findByName(String namaDesa);
	
	@Query(value = "select nama_desa from desa_table where id = ?", nativeQuery = true)
	String findNameById(Integer id);
	@Query(value = "select kode_desa from desa_table where id = ?", nativeQuery = true)
	String findKodeById(Integer id);

	@Query(value = "select id from desa_table where id = ?", nativeQuery = true)
	Integer findIdById(Integer id);
	
	@Query(value = "select * from desa_table where status = 1", nativeQuery = true)
	List<DesaEntity> findActiveId();
	
	@Query(value = "select * from desa_table where id = ?", nativeQuery = true)
	List<DesaEntity> findAllById(Integer id);

}
