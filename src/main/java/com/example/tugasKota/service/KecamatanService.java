package com.example.tugasKota.service;
import java.util.List;

import com.example.tugasKota.dto.KecamatanDto;
import com.example.tugasKota.entity.KecamatanEntity;
public interface KecamatanService {
	List<KecamatanEntity> getAllKecamatan();
	KecamatanEntity insertKecamatan(KecamatanDto dto);
	KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto);
	KecamatanEntity deleteKecamatan(Integer id);
}
