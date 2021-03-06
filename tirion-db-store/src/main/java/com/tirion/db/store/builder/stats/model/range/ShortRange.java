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
public final class ShortRange implements Range {

	@JsonProperty
	private final short low;
	@JsonProperty
	private final short high;

	public ShortRange(short low, short high) {
		super();
		this.low = low;
		this.high = high;
	}
	
	/**
	 * Returns true if given range is subset of this range.
	 */
	public boolean contains(short lowValue, short highValue) {
		return low < lowValue && highValue < high;
	}
	
	/**
	 * Number of values between low and high.
	 * Exact value.
	 */
	public short getDiff() {
		return 			    (short)  (getHigh() - getLow() - 1);
	}

	public short getLow() {
		return low;
	}

	public short getHigh() {
		return high;
	}
	
	@Override
	public Type getType() {
		return Type.SHORT;
	}

	@Override
	public long sizeInBytes() {
		return 2 + 2;
	}

	@Override
	public String toString() {
				return getLow() + ".." + getHigh();
			}
}

