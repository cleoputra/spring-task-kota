package com.example.tugasKota.service;
import java.util.List;

import com.example.tugasKota.dto.DesaDto;
import com.example.tugasKota.entity.DesaEntity;

public interface DesaService {
	List<DesaEntity> getAllDesa();
	DesaEntity insertDesa(DesaDto dto);
	DesaEntity updateDesa(Integer id, DesaDto dto);
	DesaEntity deleteDesa(Integer id);
}
