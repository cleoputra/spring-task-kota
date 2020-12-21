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

import com.example.tugasKota.dto.KabupatenDto;
import com.example.tugasKota.dto.StatusMessageDto;
import com.example.tugasKota.entity.KabupatenEntity;
import com.example.tugasKota.service.KabupatenServiceImpl;


@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	@Autowired
	private KabupatenServiceImpl kabupatenService;

	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(kabupatenService.getAllKabupaten());
	}
	

	@PostMapping("/post")
	public ResponseEntity<?> insertKabupaten(@RequestBody KabupatenDto dto){
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Ditambah!");
			result.setData(kabupatenService.insertKabupaten(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@PostMapping("/post-list")
	public ResponseEntity<?> insertList(@RequestBody List<KabupatenDto> dto) {
		for (KabupatenDto kabupaten : dto) {
			kabupatenService.insertKabupaten(kabupaten);
		}
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/get-kab-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(kabupatenService.getById(id));
}
	
	@GetMapping("/get-by-provcode/{kodeProvinsi}")
	public ResponseEntity<?> getByKodeProvinsi(@PathVariable String kodeProvinsi) {
		return ResponseEntity.ok(kabupatenService.getByKodeProvinsi(kodeProvinsi));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Dihapus!");
		result.setData(kabupatenService.deleteKabupaten(id));
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KabupatenDto dto){
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Diperbarui!");
			result.setData(kabupatenService.updateKabupaten(id, dto));
			return ResponseEntity.ok(result);
		}
	}
	
	
	public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		return kabupatenEntity;
	}
	
}
