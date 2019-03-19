package com.mum.service;

import java.util.List;

import com.mum.model.Block;

public interface BlockService {
	
	Block save(Block block);
	List<Block> saveAll(List<Block> blocks);
	Block findById(long id);
	List<Block> findAll();
	long count();
	boolean existsById(Long id); 

}
