package com.example.tugasKota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tugasKota.dto.KecamatanDto;
import com.example.tugasKota.entity.KabupatenEntity;
import com.example.tugasKota.entity.KecamatanEntity;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.KabupatenRepository;
import com.example.tugasKota.repository.KecamatanRepository;
import com.example.tugasKota.repository.ProvinsiRepository;


@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	private KecamatanRepository kecamatanRepository;
	private KabupatenRepository kabupatenRepository;
	private ProvinsiRepository provinsiRepository;
	@Autowired
	public KecamatanController(KecamatanRepository kecamatanRepository, KabupatenRepository kabupatenRepository,
			ProvinsiRepository provinsiRepository) {
		super();
		this.kecamatanRepository = kecamatanRepository;
		this.kabupatenRepository = kabupatenRepository;
		this.provinsiRepository = provinsiRepository;
	}
		
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		List<KecamatanEntity> kecamatanEntity = kecamatanRepository.findAll();
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	@PostMapping("/post-kecamatan")
	public ResponseEntity<?> insertKecamatan(@RequestBody KecamatanDto dto){
		KecamatanEntity kecamatanEntity = converToKecamatanEntity(dto);
		kecamatanRepository.save(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	@PostMapping("/post-kecamatan-kab-prov")
	public ResponseEntity<?> insertDetail(@RequestBody KecamatanDto dto){
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(dto.getKabId()).get();
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(dto.getProvId()).get();
	
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		
		kecamatanRepository.save(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KecamatanDto dto){
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		
		kecamatanRepository.save(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
	}
	
	@GetMapping("/get-kec-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		KecamatanDto dto = new KecamatanDto();
		dto.setKodeKecamatan(kecamatanRepository.findKodeById(id));
		dto.setNamaKecamatan(kecamatanRepository.findNameById(id));
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		kecamatanRepository.delete(kecamatanEntity);
		return ResponseEntity.ok(kecamatanEntity);
	}

	
	
	public KecamatanEntity converToKecamatanEntity(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		return kecamatanEntity;
	}
}
