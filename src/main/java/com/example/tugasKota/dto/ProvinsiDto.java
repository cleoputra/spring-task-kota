package com.example.tugasKota.dto;


public class ProvinsiDto {
	private String kodeProvinsi;
	private String namaProvinsi;
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
	public ProvinsiDto(String kodeProvinsi, String namaProvinsi) {
		super();
		this.kodeProvinsi = kodeProvinsi;
		this.namaProvinsi = namaProvinsi;
	}
	public ProvinsiDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
