package com.example.tugasKota.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "kabupaten_table")
@NoArgsConstructor
@AllArgsConstructor
public class KabupatenEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_kabupaten", unique = true, length = 25, nullable = false)
	private String kodeKabupaten;
	
	@Column(name = "nama_provinsi")
	private String namaKabupaten;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "kode_provinsi", referencedColumnName = "kode_provinsi")
	private ProvinsiEntity provinsiEntity;

	public ProvinsiEntity getProvinsiEntity() {
		return provinsiEntity;
	}

	public void setProvinsiEntity(ProvinsiEntity provinsiEntity) {
		this.provinsiEntity = provinsiEntity;
	}

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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


	public KabupatenEntity(Integer id, String kodeKabupaten, String namaKabupaten, Integer status,
			ProvinsiEntity provinsiEntity) {
		super();
		this.id = id;
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.status = status;
		this.provinsiEntity = provinsiEntity;
	}

	public KabupatenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
