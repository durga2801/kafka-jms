package com.durgendra.kafka;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDetail implements Serializable{
	
	private String detailId;
	private Long joinId;

}
