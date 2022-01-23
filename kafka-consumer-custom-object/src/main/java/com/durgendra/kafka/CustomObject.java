package com.durgendra.kafka;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class CustomObject implements Serializable{
	
	private Long id;
	private String code;
	private String name;
	private String contact;
	private Date dob;
	private UUID uuid;
	private CustomDetail detail;

}
