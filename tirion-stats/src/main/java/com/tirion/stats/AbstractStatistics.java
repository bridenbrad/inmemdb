/**
 * Copyright © 2013/2014, Veljko Zivkovic
 * All rights reserved.
 *
 * No portion of this file may be reproduced in any form, or by any means, without the prior written
 * consent of the author.
 */
package com.tirion.stats;

/**
 * @author Veljko Zivkovic, Copyright (C) All Rights Reserved
 */
public abstract class AbstractStatistics implements Statistics {

	private final Kind kind;
	
	public AbstractStatistics(Kind kind) {
		super();
		this.kind = kind;
	}

	@Override
	public final Kind getKind() {
		return kind;
	}
}