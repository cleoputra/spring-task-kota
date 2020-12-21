package com.example.tugasKota.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tugasKota.dto.KecamatanDto;
import com.example.tugasKota.entity.KabupatenEntity;
import com.example.tugasKota.entity.KecamatanEntity;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.KabupatenRepository;
import com.example.tugasKota.repository.KecamatanRepository;
import com.example.tugasKota.repository.ProvinsiRepository;

public class KecamatanServiceImpl implements KecamatanService{
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public List<KecamatanEntity> getAllKecamatan() {
		return kecamatanRepository.findActiveId();
	}

	public List<KecamatanEntity> getById(Integer id) {
		return kecamatanRepository.findAllById(id);
	}
	
	@Override
	public KecamatanEntity insertKecamatan(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = convertToKecamatan(dto);
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
		
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
	}
	
	@Override
	public KecamatanEntity deleteKecamatan(Integer id) {
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		kecamatanEntity.setStatus(0);
		return kecamatanEntity;
	}
	
	
	@Override
	public KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());


		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
		
	}

	public KecamatanEntity convertToKecamatan(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setStatus(1);
		return kecamatanEntity;
	}
}
