package com.example.tugasKota.dto;

public class DesaDto {
	private String kodeDesa;
	private String namaDesa;
	private Integer provId;
	private Integer kabId;
	private Integer kecId;
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
	public Integer getKecId() {
		return kecId;
	}
	public void setKecId(Integer kecId) {
		this.kecId = kecId;
	}
	public DesaDto(String kodeDesa, String namaDesa, Integer provId, Integer kabId, Integer kecId) {
		super();
		this.kodeDesa = kodeDesa;
		this.namaDesa = namaDesa;
		this.provId = provId;
		this.kabId = kabId;
		this.kecId = kecId;
	}
	public DesaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
