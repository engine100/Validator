package com.engine100.validator.input;


import com.engine100.validator.check.CheckedResult;

/**
 * 用来输入的控件
 */
public interface InputView {

	void setValue(Object value);

	<V> V getValue();

	CheckedResult checkInputValue();

}
