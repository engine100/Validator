
package com.engine100.validator.common;

import android.widget.TextView;
import com.engine100.validator.check.CheckContainer;
import com.engine100.validator.check.CheckedResult;


/**
 * 之多填一个
 */
public class AtMostOneInputCheckContainer extends CheckContainer<TextView> {

	private TextView[] mTextViews;


	public AtMostOneInputCheckContainer(TextView... textViews) {
		super(null, null);
		mTextViews = textViews;
	}


	@Override
	public void setValue(Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <V> V getValue() {
		throw new UnsupportedOperationException();
	}


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
