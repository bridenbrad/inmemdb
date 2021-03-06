/**
 * Copyright © 2013/2014, Veljko Zivkovic
 * All rights reserved.
 *
 * No portion of this file may be reproduced in any form, or by any means, without the prior written
 * consent of the author.
 */
package com.tirion.db.store.builder.parser;

import com.tirion.common.sequence.Spec;
import com.tirion.common.sequence.array.Array;
import com.tirion.common.sequence.array.NativeArray;
import com.tirion.common.type.Type;
import com.tirion.pool.Pool;

/**
 * @author Veljko Zivkovic, Copyright (C) All Rights Reserved
 */
public final class StringParser extends AbstractParser {

	private final Pool pool;
	
	public StringParser(String nullValue, Pool pool) {
		super(nullValue);
		this.pool = pool;
	}

	@Override
	public Array parse(String[][] splits, int startRow, int endRow, int columnIndex) {
		final int rowCount = endRow - startRow;
		
		final boolean[] nulls = super.getNulls(splits, startRow, endRow, columnIndex);
		
		long[] result = new long[rowCount];
		int index = 0;
		if(nulls == null) {
			for (int i = startRow; i < endRow; i++) {
				result[index++] = pool.getToken(splits[i][columnIndex]);
			}	
		} else {
			for (int i = startRow; i < endRow; i++) {
				if(!nulls[i]) {					
					result[index++] = pool.getToken(splits[i][columnIndex]);
				}
			}
		}
		return new NativeArray(new Spec(Type.LONG, result.length, false, getBitmap(nulls)), result);
	}
}
