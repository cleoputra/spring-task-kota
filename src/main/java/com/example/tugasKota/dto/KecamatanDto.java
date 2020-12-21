package com.example.tugasKota.dto;

public class KecamatanDto {
	private String kodeKecamatan;
	private String namaKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
	
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
	
	public KecamatanDto(String kodeKecamatan, String namaKecamatan, String kodeKabupaten, String kodeProvinsi) {
		super();
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.kodeKabupaten = kodeKabupaten;
		this.kodeProvinsi = kodeProvinsi;
	}
	public String getKodeKabupaten() {
		return kodeKabupaten;
	}
	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}
	public String getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	public KecamatanDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
