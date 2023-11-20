package com.api.prueba.tecnica.gml.entitys;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClientEntity {
	
	private String sharedKey;
	private String businessId;
	private String email;
	private String phone;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private Date dataAdded;

}
