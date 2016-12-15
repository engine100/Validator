package com.engine100.validator.input;


import com.engine100.validator.check.CheckedResult;

/**
 * 用来输入的控件
 * @description</br>
 * 
 * @author ZhuChengCheng
 * @github https://github.com/engine100
 * @time 2016年12月4日 - 上午5:39:19
 */
public interface InputView {

	void setValue(Object value);

	<V> V getValue();

	CheckedResult checkInputValue();

}
