package com.example.tugasKota.dto;

public class KecamatanDto {
	private String kodeKecamatan;
	private String namaKecamatan;
	private Integer provId;
	private Integer kabId;
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
	public Integer getProvId() {
		return provId;
	}
	public void setProvId(Integer provId) {
		this.provId = provId;
	}
	public Integer getKabId() {
		return kabId;
	}
	public void setKabId(Integer kabId) {
		this.kabId = kabId;
	}
	public KecamatanDto(String kodeKecamatan, String namaKecamatan, Integer provId, Integer kabId) {
		super();
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.provId = provId;
		this.kabId = kabId;
	}
	public KecamatanDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
