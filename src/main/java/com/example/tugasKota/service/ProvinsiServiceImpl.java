package com.example.tugasKota.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tugasKota.dto.ProvinsiDto;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.ProvinsiRepository;

public class ProvinsiServiceImpl implements ProvinsiService{
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public List<ProvinsiEntity> getAllProvinsi(){
		return provinsiRepository.findActiveId();
	}
	
	public List<ProvinsiEntity> getById(Integer id) {
		return provinsiRepository.findAllById(id);
	}
	
	public List<ProvinsiEntity> getByKodeProvinsi(String id) {
		return provinsiRepository.findAllByKodeProvinsi(id);
	}
	
	@Override
	public ProvinsiEntity insertProvinsi(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = convertToProvinsi(dto);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}
	
	@Override 
	public ProvinsiEntity updateProvinsi(Integer id, ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}
	
	@Override 
	public ProvinsiEntity deleteProvinsi(Integer id) {
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiEntity.setStatus(0);
		return provinsiEntity;
	}
	
	public ProvinsiEntity convertToProvinsi(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setStatus(1);
		return provinsiEntity;
	}
	
	
}
