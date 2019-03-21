package com.mum.data.init;

import java.time.LocalDate;

import com.mum.model.Block;

public class BlockBuilder {
	private Block block;
	
	public BlockBuilder() {
		block = new Block();
	}
	
	public BlockBuilder withId(Long id) {
		block.setId(id);
		return this;
	}
	
	public BlockBuilder withName(String name) {
		block.setName(name);
		return this;
	}
	

	
	public BlockBuilder withStartDate(LocalDate startDate) {
		block.setStartDate(startDate);
		return this;
	}
	
	public BlockBuilder withEndDate(LocalDate endDate) {
		block.setEndDate(endDate);
		return this;
	}

	public Block build() {
		return block;
	}
}
