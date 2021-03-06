/**
 * Copyright © 2013/2014, Veljko Zivkovic
 * All rights reserved.
 *
 * No portion of this file may be reproduced in any form, or by any means, without the prior written
 * consent of the author.
 */
package com.tirion.db.store.builder.stats.model.range;

import java.text.DecimalFormat;
import com.tirion.common.type.Type;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class was autogenerated. Do not edit manually.
 */
public final class IntegerRange implements Range {

	@JsonProperty
	private final int low;
	@JsonProperty
	private final int high;

	public IntegerRange(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	
	/**
	 * Returns true if given range is subset of this range.
	 */
	public boolean contains(int lowValue, int highValue) {
		return low < lowValue && highValue < high;
	}
	
	/**
	 * Number of values between low and high.
	 * Exact value.
	 */
	public int getDiff() {
		return 			    (getHigh() - getLow() - 1);
	}

	public int getLow() {
		return low;
	}

	public int getHigh() {
		return high;
	}
	
	@Override
	public Type getType() {
		return Type.INT;
	}

	@Override
	public long sizeInBytes() {
		return 4 + 4;
	}

	@Override
	public String toString() {
				return getLow() + ".." + getHigh();
			}
}

