package com.mum.service;

import java.util.List;

import com.mum.model.Block;
import com.mum.model.Session;

public interface DataGeneratorService{
	public void initializeBlocksAndSessions();
	public Block generateBlock(int month);
	public List<Session> generateSessions(Block block);
}
