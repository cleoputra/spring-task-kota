package com.example.tugasKota.controller;


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

import com.example.tugasKota.dto.DesaDto;
import com.example.tugasKota.dto.StatusMessageDto;
import com.example.tugasKota.entity.DesaEntity;
import com.example.tugasKota.service.DesaServiceImpl;

@RestController
@RequestMapping("/desa")
public class DesaController {
	@Autowired
	private DesaServiceImpl desaService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(desaService.getAllDesa());
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getById(Integer id) {
		return ResponseEntity.ok(desaService.getById(id));
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> insert(@RequestBody DesaDto dto) {
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		
		if (dto.getNamaDesa().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Ditambah!");
			result.setData(desaService.insertDesa(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DesaDto dto) {
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		
		if (dto.getNamaDesa().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Ditambah!");
			result.setData(desaService.updateDesa(id, dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Dihapus!");
		result.setData(desaService.deleteDesa(id));
		return ResponseEntity.ok(result);
	}	
}
