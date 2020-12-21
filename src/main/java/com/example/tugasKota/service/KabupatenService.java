package com.example.tugasKota.service;
import java.util.List;

import com.example.tugasKota.dto.KabupatenDto;
import com.example.tugasKota.entity.KabupatenEntity;

public interface KabupatenService {
	List<KabupatenEntity> getAllKabupaten();
	KabupatenEntity insertKabupaten(KabupatenDto dto);
	KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto);
	KabupatenEntity deleteKabupaten(Integer id);
}
