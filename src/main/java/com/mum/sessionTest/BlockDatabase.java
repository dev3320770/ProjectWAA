package com.mum.sessionTest;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mum.model.Block;
import com.mum.model.Block.BlockBuilder;

public class BlockDatabase {
	
	private List<Block> blocks;
	
	public BlockDatabase() {
		blocks = new ArrayList<>();
		for(int i = 1; i <= 12; ++i) {
			blocks.add(generateBlock(i));
		}
	}
	
	public Block generateBlock(int month) {
		
		Long id = (long)month;
		String blockName = new DateFormatSymbols().getMonths()[month];
		LocalDate startDate = LocalDate.of(2019,month,1);
		LocalDate endDate = LocalDate.of(2019,month,28);
		Block block = new BlockBuilder()
							.withId(id)
							.withName(blockName)
							.withDescription(blockName + " block, 2019")
							.withStartDate(startDate)
							.withEndDate(endDate)
							.withSessions(SessionDatabase.generateSessions(month))
							.build();
		return block;
	}
	
	public List<Block> getAllBlocks() {
		return blocks;
	}
	
	public Block findById(Long id) {
		for(Block block : blocks) {
			if(block.getId() == id) {
				return block;
			}
		}
		return null;
	}
	
}
