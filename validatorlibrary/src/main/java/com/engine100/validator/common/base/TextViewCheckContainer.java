package com.engine100.validator.common.base;

import android.widget.TextView;
import com.engine100.validator.check.CheckContainer;

/**
 * TextView输入的校验
 */
public abstract class TextViewCheckContainer extends CheckContainer<TextView> {

	public TextViewCheckContainer(TextView view) {
		super(view, null);
	}

	@Override
	public void setValue(Object value) {
		if (value != null) {
			mView.setText(value.toString());
		}
		mView.setText("");
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> V getValue() {
		return (V) mView.getText().toString();
	}

	public abstract String getErrorMsg();

}
