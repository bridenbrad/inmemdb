/**
 * Copyright © 2013/2014, Veljko Zivkovic
 * All rights reserved.
 *
 * No portion of this file may be reproduced in any form, or by any means, without the prior written
 * consent of the author.
 */
package com.tirion.db.sql.exec.operator.physical.scan.filter.array;

import java.util.Set;

import com.tirion.db.sql.exec.operator.physical.scan.rowid.sink.RowIdSink;

/**
 * This class was autogenerated. Do not edit manually.
 * 
 * @author Veljko Zivkovic, Copyright (C) All Rights Reserved
 */
public abstract class IntegerArrayFilter extends AbstractArrayFilter {

	protected final int[] array;
	
	public IntegerArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array) {
		super(rowIdSink, startRowId);
		this.array = array;
	}
	
	public static final class IntegerBetweenArrayFilter extends IntegerArrayFilter {

		private final int low;
		private final int high;
		
		public IntegerBetweenArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int low, int high) {
			super(rowIdSink, startRowId, array);
			this.low = low;
			this.high = high;
		}

		@Override
		public void apply() {
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(low <= array[i] && array[i] <= high) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static final class IntegerInArrayFilter extends IntegerArrayFilter {

		private final Set<Integer> set;

		public IntegerInArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, Set<Integer> set) {
			super(rowIdSink, startRowId, array);
			this.set = set;
		}

		@Override
		public void apply() {	
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(set.contains(array[i])) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static abstract class SimpleIntegerArrayFilter extends IntegerArrayFilter {
		
		protected final int value;

		public SimpleIntegerArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array);
			this.value = value;
		}
	}
	
	public static final class IntegerEqArrayFilter extends SimpleIntegerArrayFilter {

		public IntegerEqArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array, value);
		}

		@Override
		public void apply() {
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(array[i] == value) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static final class IntegerNeqArrayFilter extends SimpleIntegerArrayFilter {

		public IntegerNeqArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array, value);
		}

		@Override
		public void apply() {
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(array[i] != value) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static final class IntegerLtArrayFilter extends SimpleIntegerArrayFilter {

		public IntegerLtArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array, value);
		}

		@Override
		public void apply() {
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(array[i] < value) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static final class IntegerLtEqArrayFilter extends SimpleIntegerArrayFilter {

		public IntegerLtEqArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array, value);
		}

		@Override
		public void apply() {
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(array[i] <= value) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static final class IntegerGtArrayFilter extends SimpleIntegerArrayFilter {

		public IntegerGtArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array, value);
		}

		@Override
		public void apply() {			
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(array[i] > value) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
	
	public static final class IntegerGtEqArrayFilter extends SimpleIntegerArrayFilter {

		public IntegerGtEqArrayFilter(RowIdSink rowIdSink, long startRowId, int[] array, int value) {
			super(rowIdSink, startRowId, array, value);
		}

		@Override
		public void apply() {
			long rowId = getStartRowId();
			for (int i = 0; i < array.length; i++) {
				if(array[i] >= value) {
					getRowIdSink().onRowId(rowId);
				}
				++rowId;
			}
		}
	}
}
