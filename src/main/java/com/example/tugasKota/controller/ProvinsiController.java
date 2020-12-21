package com.example.tugasKota.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.tugasKota.dto.StatusMessageDto;
import com.example.tugasKota.entity.ProvinsiEntity;
import com.example.tugasKota.service.ProvinsiServiceImpl;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {
	@Autowired
	private ProvinsiServiceImpl provinsiService;
	
	@GetMapping("/get-all")	
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(provinsiService.getAllProvinsi());
	}
	
	@GetMapping("/get-prov-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(provinsiService.getById(id));
	}
	
	@GetMapping("/get-by-provcode/{kodeProvinsi}")
	public ResponseEntity<?> getByKodeProvinsi(@PathVariable String kodeProvinsi) {
		return ResponseEntity.ok(provinsiService.getByKodeProvinsi(kodeProvinsi));
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> insertProvinsi(@RequestBody ProvinsiDto dto){
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaProvinsi().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Input Nama Provinsi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Ditambah!");
			result.setData(provinsiService.insertProvinsi(dto));
			return ResponseEntity.ok(result);
		}
}
	
	@PostMapping("/post-list")
	public ResponseEntity<?> insertList(@RequestBody List<ProvinsiDto> dto) {
		for (ProvinsiDto provinsi : dto) {
			provinsiService.insertProvinsi(provinsi);
		}
		return ResponseEntity.ok(dto);
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProvinsiDto dto) {
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaProvinsi().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Diperbarui!");
			result.setData(provinsiService.updateProvinsi(id, dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Dihapus!");
		result.setData(provinsiService.deleteProvinsi(id));
		return ResponseEntity.ok(result);
	}
}
