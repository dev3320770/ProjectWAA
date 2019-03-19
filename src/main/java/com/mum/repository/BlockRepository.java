package com.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Block;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {

}
