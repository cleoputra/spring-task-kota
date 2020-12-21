package com.example.tugasKota.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tugasKota.dto.DesaDto;
import com.example.tugasKota.entity.DesaEntity;
import com.example.tugasKota.entity.KabupatenEntity;
import com.example.tugasKota.entity.KecamatanEntity;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.DesaRepository;
import com.example.tugasKota.repository.KabupatenRepository;
import com.example.tugasKota.repository.KecamatanRepository;
import com.example.tugasKota.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImpl implements DesaService{
	@Autowired
	private DesaRepository desaRepository;
	
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;

	@Override
	public List<DesaEntity> getAllDesa() {
		return desaRepository.findActiveId();
	}
	
	public List<DesaEntity> getById(Integer id) {
		return desaRepository.findAllById(id);
	}
	
	
	@Override
	public DesaEntity insertDesa(DesaDto dto) {
		DesaEntity desaEntity = convertToDesa(dto);
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanEntity.getKabupatenEntity().getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
		
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}
	
	@Override
	public DesaEntity deleteDesa(Integer id) {
		DesaEntity desaEntity = desaRepository.findById(id).get();
		desaEntity.setStatus(0);
		return desaEntity;
	}
	
	@Override
	public DesaEntity updateDesa(Integer id, DesaDto dto) {
		DesaEntity desaEntity = desaRepository.findById(id).get();
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanEntity.getKabupatenEntity().getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
				
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	public DesaEntity convertToDesa(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setStatus(1);
		return desaEntity;
	}

}


