/**
 * Copyright © 2013/2014, Veljko Zivkovic
 * All rights reserved.
 *
 * No portion of this file may be reproduced in any form, or by any means, without the prior written
 * consent of the author.
 */
package com.tirion.db.sql.exec.operator.physical.groupby;

import com.tirion.db.sql.exec.operator.physical.SingleSourcePhysicalOperator;

/**
 * @author Veljko Zivkovic, Copyright (C) All Rights Reserved
 */
public abstract class GroupByOperator extends SingleSourcePhysicalOperator {

	@Override
	public final Kind getKind() {
		return Kind.GROUP_BY;
	}
}
