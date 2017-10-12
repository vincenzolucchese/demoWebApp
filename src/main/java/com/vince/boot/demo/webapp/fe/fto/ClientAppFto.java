package com.vince.boot.demo.webapp.fe.fto;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;

public class ClientAppFto extends BaseFto {

	private static final long serialVersionUID = 1L;

	private String name;
	private String piva;
	private String address;
	private String zipcode;
	private String notes;
	private String phone;
	private String email;

	public ClientAppFto() {
	}

	public ClientAppFto(Long id) {
		super.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPiva() {
		return this.piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static ClientAppFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		ClientAppFto fto = new ClientAppFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static ClientAppDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		ClientAppDto dto = new ClientAppDto();
		BeanUtils.copyProperties(fto, dto);
		
//		if(fto.getFileDocuments()!=null) {
//			dto.setFileDocuments(new ArrayList<BlobStoreDto>());
//			dto.getFileDocuments().add(new BlobStoreDto());
//			for (BlobStoreFto eachFto : fto.getFileDocuments()) {
//				dto.getFileDocuments().add(BlobStoreFto.createDtoFromFto(eachFto));			
//			}			
//		}
		return dto;
	}

}
