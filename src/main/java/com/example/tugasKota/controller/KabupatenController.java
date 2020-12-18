package com.example.tugasKota.controller;

import java.util.List;
import java.util.ArrayList;

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

import com.example.tugasKota.dto.KabupatenDto;
import com.example.tugasKota.entity.KabupatenEntity;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.repository.KabupatenRepository;
import com.example.tugasKota.repository.ProvinsiRepository;


@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	private	KabupatenRepository kabupatenRepository;
	private	ProvinsiRepository provinsiRepository;
	
	@Autowired
	public KabupatenController(KabupatenRepository kabupatenRepository, ProvinsiRepository provinsiRepository) {
		super();
		this.kabupatenRepository = kabupatenRepository;
		this.provinsiRepository = provinsiRepository;
	}

	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		List<KabupatenEntity> kabupatenEntity = kabupatenRepository.findAll();
		return ResponseEntity.ok(kabupatenEntity);
	}
	

	@PostMapping("/post-kabupaten")
	public ResponseEntity<?> insertKabupaten(@RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = convertToKabupatenEntity(dto);
		kabupatenRepository.save(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity );
	}
	
//	isi kabupaten dari dataprovinsi sudah ada
	@PostMapping("/post-kabupaten-prov")
	public ResponseEntity<?> insertDetail(@RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(dto.getProvId()).get();
		
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		
		kabupatenRepository.save(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	@GetMapping("/get-kab-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		KabupatenDto dto = new KabupatenDto();
		dto.setKodeKabupaten(kabupatenRepository.findKodeById(id));
		dto.setNamaKabupaten(kabupatenRepository.findNameById(id));
		return ResponseEntity.ok(dto);
}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		kabupatenRepository.delete(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();

		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		
		kabupatenRepository.save(kabupatenEntity);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	
	public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		return kabupatenEntity;
	}
	
}
