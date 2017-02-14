package com.engine100.validator.check;


import com.engine100.validator.input.InputView;

/**
 * 把输入控件包装起来，用来做校验
 */
public abstract class CheckContainer<T> implements InputView {

	protected T mView;
	protected Object[] mValidObjects;

	public CheckContainer(T view, Object[] validObjects) {
		mView = view;
		mValidObjects = validObjects;
	}

	// public CheckContainer(T view) {
	// mView = view;
	// }

	public void setObjects(Object[] validObjects) {
		mValidObjects = validObjects;
	}

	@SuppressWarnings("unchecked")
	protected <Target> Target parseObject(Object o) {
		return (Target) o;
	}

}
