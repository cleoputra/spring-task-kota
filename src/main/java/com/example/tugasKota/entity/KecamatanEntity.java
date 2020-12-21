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
@Table(name = "kecamatan_table")
@NoArgsConstructor
@AllArgsConstructor
public class KecamatanEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_kecamatan", unique = true, length = 25, nullable = false)
	private String kodeKecamatan;
	
	@Column(name = "nama_kecamatan")
	private String namaKecamatan;
	
	@Column(name = "status")
	private Integer status;


	@ManyToOne
	@JoinColumn(name = "kode_provinsi", referencedColumnName = "kode_provinsi")
	private ProvinsiEntity provinsiEntity;
	
	@ManyToOne
	@JoinColumn(name = "kode_kabupaten", referencedColumnName = "kode_kabupaten")
	private KabupatenEntity kabupatenEntity;
	
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
	public String getKodeKecamatan() {
		return kodeKecamatan;
	}
	public void setKodeKecamatan(String kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}
	public String getNamaKecamatan() {
		return namaKecamatan;
	}
	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
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
	
	public KecamatanEntity(Integer id, String kodeKecamatan, String namaKecamatan, Integer status,
			ProvinsiEntity provinsiEntity, KabupatenEntity kabupatenEntity) {
		super();
		this.id = id;
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.status = status;
		this.provinsiEntity = provinsiEntity;
		this.kabupatenEntity = kabupatenEntity;
	}
	public KecamatanEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
