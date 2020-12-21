package com.example.tugasKota.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "provinsi_table")
@NoArgsConstructor
@AllArgsConstructor

public class ProvinsiEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_provinsi", unique = true, length = 25, nullable = false)
	private String kodeProvinsi;
	
	@Column(name = "nama_provinsi")
	private String namaProvinsi;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name="status")
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public String getNamaProvinsi() {
		return namaProvinsi;
	}

	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}

	public ProvinsiEntity(Integer id, String kodeProvinsi, String namaProvinsi, Integer status) {
		super();
		this.id = id;
		this.kodeProvinsi = kodeProvinsi;
		this.namaProvinsi = namaProvinsi;
		this.status = status;
	}

	public ProvinsiEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
