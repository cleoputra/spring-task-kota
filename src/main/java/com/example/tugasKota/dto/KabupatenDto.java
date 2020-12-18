package com.example.tugasKota.dto;

public class KabupatenDto {
	private String kodeKabupaten;
	private String namaKabupaten;
	private Integer provId;
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
	public Integer getProvId() {
		return provId;
	}
	public void setProvId(Integer provId) {
		this.provId = provId;
	}
	public KabupatenDto(String kodeKabupaten, String namaKabupaten, Integer provId) {
		super();
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.provId = provId;
	}
	public KabupatenDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
