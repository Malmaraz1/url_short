package com.example.url_short.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.url_short.record.UrlShort;

@Repository
public interface UrlShortRepository extends CrudRepository<UrlShort, String>{

}
