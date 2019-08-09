package com.bae;

import org.springframework.http.ResponseEntity;

import com.bae.domain.History;

public class Constants {
	
	public static final History MOCK_HISTORY = new History();
	public static final ResponseEntity<History> MOCK_HISTORY_RESPONSE = new ResponseEntity(,HttpStatus.OK);

}
