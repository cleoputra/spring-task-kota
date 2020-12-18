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
@Table(name = "kabupaten_table")
public class KabupatenEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_kabupaten", unique = true, length = 25, nullable = false)
	private String kodeKabupaten;
	
	@Column(name = "nama_provinsi", unique = true, length = 25, nullable = false)
	private String namaKabupaten;
	
	@ManyToOne
	@JoinColumn(name = "prov_id")
	private ProvinsiEntity provinsiEntity;

	public ProvinsiEntity getProvinsiEntity() {
		return provinsiEntity;
	}

	public void setProvinsiEntity(ProvinsiEntity provinsiEntity) {
		this.provinsiEntity = provinsiEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeKabupaten() {
		return kodeKabupaten;
	}

	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}

	public String getNamaKabupaten() {
		return namaKabupaten;
	}

	public void setNamaKabupaten(String namaKabupaten) {
		this.namaKabupaten = namaKabupaten;
	}

	public KabupatenEntity(Integer id, String kodeKabupaten, String namaKabupaten, ProvinsiEntity provinsiEntity) {
		super();
		this.id = id;
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.provinsiEntity = provinsiEntity;
	}

	public KabupatenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
