package com.mum.data.init;

import java.util.List;

import com.mum.model.Block;
import com.mum.model.Session;

public interface DataGeneratorService{
	public void initializeBlocksAndSessions();
	public Block generateBlock(int month);
	public void generateSessions(Block block);
}
