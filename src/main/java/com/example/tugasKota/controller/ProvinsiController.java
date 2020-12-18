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

import com.example.tugasKota.dto.ProvinsiDto;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.ProvinsiRepository;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@GetMapping("/get-all")	
	public ResponseEntity<?> getAll(){
		List<ProvinsiEntity> provinsiEntity = provinsiRepository.findAll();
		return ResponseEntity.ok(provinsiEntity);
	}
	
	@GetMapping("/get-prov-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		ProvinsiDto dto = new ProvinsiDto();
		dto.setNamaProvinsi(provinsiRepository.findNameById(id));
		dto.setKodeProvinsi(provinsiRepository.findKodeById(id));
		return ResponseEntity.ok(dto);
	}
	
	
	@PostMapping("/post-provinsi")
	public ResponseEntity<?> insertProvinsi(@RequestBody ProvinsiDto dto){
	ProvinsiEntity provinsiEntity = convertToProvinsiEntity(dto);
	provinsiRepository.save(provinsiEntity);
	return ResponseEntity.ok(provinsiEntity);
}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiRepository.delete(provinsiEntity);
		return ResponseEntity.ok(provinsiEntity);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProvinsiDto dto){
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());		
		
		provinsiRepository.save(provinsiEntity);
		return ResponseEntity.ok(provinsiEntity);
	}
	
	public ProvinsiEntity convertToProvinsiEntity(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		return provinsiEntity;
	}
}
