package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Block;
import com.mum.repository.BlockRepository;
import com.mum.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService {
	
	@Autowired
	BlockRepository blockRepository;

	@Override
	public Block save(Block block) {
		return blockRepository.save(block);
	}

	@Override
	public List<Block> saveAll(List<Block> blocks) {
		return (List<Block>) blockRepository.saveAll(blocks);
	}

	@Override
	public Block findById(long id) {
		return blockRepository.findById(id).get();
	}

	@Override
	public List<Block> findAll() {
		return (List<Block>) blockRepository.findAll();
	}

	@Override
	public long count() {
		return blockRepository.count();
	}

	@Override
	public boolean existsById(Long id) {
		return blockRepository.existsById(id);
	}

}
