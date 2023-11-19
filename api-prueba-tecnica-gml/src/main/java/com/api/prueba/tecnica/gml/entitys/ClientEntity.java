package com.api.prueba.tecnica.gml.entitys;

import java.util.Date;

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
	private Long phone;
	private Date dataAdded;

}
