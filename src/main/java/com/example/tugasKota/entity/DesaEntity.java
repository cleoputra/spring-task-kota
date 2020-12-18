package com.example.tugasKota.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "desa_table")
public class DesaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "kode_desa", unique = true, length = 25, nullable = false)
	private String kodeDesa;
	
	@Column(name = "nama_desa", unique = true, length = 25, nullable = false)
	private String namaDesa;
	
	@ManyToOne
	@JoinColumn(name = "prov_id")
	private ProvinsiEntity provinsiEntity;
	@ManyToOne
	@JoinColumn(name = "kab_id")
	private KabupatenEntity kabupatenEntity;
	@ManyToOne
	@JoinColumn(name = "kec_id")
	private KecamatanEntity kecamatanEntity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKodeDesa() {
		return kodeDesa;
	}
	public void setKodeDesa(String kodeDesa) {
		this.kodeDesa = kodeDesa;
	}
	public String getNamaDesa() {
		return namaDesa;
	}
	public void setNamaDesa(String namaDesa) {
		this.namaDesa = namaDesa;
	}
	public ProvinsiEntity getProvinsiEntity() {
		return provinsiEntity;
	}
	public void setProvinsiEntity(ProvinsiEntity provinsiEntity) {
		this.provinsiEntity = provinsiEntity;
	}
	public KabupatenEntity getKabupatenEntity() {
		return kabupatenEntity;
	}
	public void setKabupatenEntity(KabupatenEntity kabupatenEntity) {
		this.kabupatenEntity = kabupatenEntity;
	}
	public KecamatanEntity getKecamatanEntity() {
		return kecamatanEntity;
	}
	public void setKecamatanEntity(KecamatanEntity kecamatanEntity) {
		this.kecamatanEntity = kecamatanEntity;
	}
	public DesaEntity(Integer id, String kodeDesa, String namaDesa, ProvinsiEntity provinsiEntity,
			KabupatenEntity kabupatenEntity, KecamatanEntity kecamatanEntity) {
		super();
		this.id = id;
		this.kodeDesa = kodeDesa;
		this.namaDesa = namaDesa;
		this.provinsiEntity = provinsiEntity;
		this.kabupatenEntity = kabupatenEntity;
		this.kecamatanEntity = kecamatanEntity;
	}
	public DesaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
