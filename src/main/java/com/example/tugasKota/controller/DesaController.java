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

import com.example.tugasKota.dto.DesaDto;
import com.example.tugasKota.entity.DesaEntity;
import com.example.tugasKota.entity.KabupatenEntity;
import com.example.tugasKota.entity.KecamatanEntity;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.DesaRepository;
import com.example.tugasKota.repository.KabupatenRepository;
import com.example.tugasKota.repository.KecamatanRepository;
import com.example.tugasKota.repository.ProvinsiRepository;

@RestController
@RequestMapping("/desa")
public class DesaController {
	private DesaRepository desaRepository;
	private KecamatanRepository kecamatanRepository;
	private KabupatenRepository kabupatenRepository;
	private ProvinsiRepository provinsiRepository;

	@Autowired
	public DesaController(DesaRepository desaRepository, KecamatanRepository kecamatanRepository,
			KabupatenRepository kabupatenRepository, ProvinsiRepository provinsiRepository) {
		super();
		this.desaRepository = desaRepository;
		this.kecamatanRepository = kecamatanRepository;
		this.kabupatenRepository = kabupatenRepository;
		this.provinsiRepository = provinsiRepository;
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		List<DesaEntity> desaEntity = desaRepository.findAll();
		return ResponseEntity.ok(desaEntity);
	}
	
	@PostMapping("/post-desa")
	public ResponseEntity<?> insertDesa(@RequestBody DesaDto dto){
		DesaEntity desaEntity = converToDesaEntity(dto);
		desaRepository.save(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	@PostMapping("/post-desa-kec-kab-prov")
	public ResponseEntity<?> insertDetail(@RequestBody DesaDto dto){
		DesaEntity desaEntity = new DesaEntity();
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(dto.getKecId()).get();
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(dto.getKabId()).get();
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(dto.getProvId()).get();
	
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		
		desaRepository.save(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DesaDto dto){
		DesaEntity desaEntity = desaRepository.findById(id).get();
		
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		
		desaRepository.save(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	@GetMapping("/get-desa-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		DesaDto dto = new DesaDto();
		dto.setKodeDesa(desaRepository.findKodeById(id));
		dto.setNamaDesa(desaRepository.findNameById(id));
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		DesaEntity desaEntity = desaRepository.findById(id).get();
		desaRepository.delete(desaEntity);
		return ResponseEntity.ok(desaEntity);
	}
	
	public DesaEntity converToDesaEntity(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		return desaEntity;
	}
	
	
}
