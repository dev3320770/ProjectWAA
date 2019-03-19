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
		// TODO Auto-generated method stub
		return blockRepository.save(block);
	}

	@Override
	public List<Block> saveAll(List<Block> blocks) {
		// TODO Auto-generated method stub
		return (List<Block>) blockRepository.saveAll(blocks);
	}

	@Override
	public Block findById(long id) {
		// TODO Auto-generated method stub
		return blockRepository.findById(id).get();
	}

	@Override
	public List<Block> findAll() {
		// TODO Auto-generated method stub
		return (List<Block>) blockRepository.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return blockRepository.count();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return blockRepository.existsById(id);
	}

}
