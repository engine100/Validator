
package com.engine100.validator.common;

import android.widget.TextView;
import com.engine100.validator.check.CheckContainer;
import com.engine100.validator.check.CheckedResult;

/**
 * 最多填一个
 * @description</br>
 * 
 * @author ZhuChengCheng
 * @github https://github.com/engine100
 * @time 2016年12月7日 - 上午9:00:27
 */
public class AtMostOneInputCheckContainer extends CheckContainer<TextView> {

	private TextView[] mTextViews;

	/**
	 *
	 * @param view
	 * @param validObjects
	 */
	public AtMostOneInputCheckContainer(TextView... textViews) {
		super(null, null);
		mTextViews = textViews;
	}

	/**
	 * 
	 * @see com.engine100.validator.input.InputView#setValue(Object)
	 * @param value
	 */
	@Override
	public void setValue(Object value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see com.engine100.validator.input.InputView#getValue()
	 * @return
	 */
	@Override
	public <V> V getValue() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see com.engine100.validator.input.InputView#checkInputValue()
	 * @return
	 */
	@Override
	public CheckedResult checkInputValue() {
		if (mTextViews == null || mTextViews.length == 0) {
			return CheckedResult.SUCCESS_RESULT;
		}
		String frontContent = null;
		for (int i = 0; i < mTextViews.length; i++) {
			String content = mTextViews[i].getText().toString().trim();

			if (content.length() > 0) {
				if (frontContent != null) {
					return new CheckedResult(false, getErrorMsg());
				}
				frontContent = content;
			}
		}
		return CheckedResult.SUCCESS_RESULT;
	}

	public String getErrorMsg() {
		return "Only one textview can be inputted";
	}

}
