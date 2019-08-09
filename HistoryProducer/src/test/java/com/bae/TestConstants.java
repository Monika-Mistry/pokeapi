package com.bae;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bae.domain.History;

public class TestConstants {

	public static final Timestamp MOCK_TIME = new Timestamp(System.currentTimeMillis());
	public static final History MOCK_HISTORY = new History(1L, "1", "John", "ditto", MOCK_TIME);
	public static final ResponseEntity<History> MOCK_HISTORY_RESPONSE = new ResponseEntity(MOCK_HISTORY, HttpStatus.OK);
	public static final String MOCK_GETHISTORY_URL = "http://localhost:8083/";

}
