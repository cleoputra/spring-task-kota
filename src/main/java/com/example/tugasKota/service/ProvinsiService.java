package com.example.tugasKota.service;
import java.util.List;

import com.example.tugasKota.dto.ProvinsiDto;
import com.example.tugasKota.entity.ProvinsiEntity;

public interface ProvinsiService {
	List<ProvinsiEntity> getAllProvinsi(); 
	ProvinsiEntity insertProvinsi(ProvinsiDto dto);
	ProvinsiEntity updateProvinsi(Integer id, ProvinsiDto dto);
	ProvinsiEntity deleteProvinsi(Integer id);
	
}
