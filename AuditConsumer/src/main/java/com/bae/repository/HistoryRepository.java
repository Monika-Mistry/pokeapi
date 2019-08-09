package com.bae.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bae.domain.SentHistory;

public interface HistoryRepository extends MongoRepository<SentHistory, Long>{

}
