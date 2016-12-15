package com.engine100.validator.demo;

import android.widget.EditText;
import com.engine100.validator.check.CheckContainer;
import com.engine100.validator.check.CheckedResult;

public class UserPassCheckContainer extends CheckContainer<EditText> {

	public UserPassCheckContainer(EditText view, Object[] validObjects) {
		super(view, validObjects);
	}

	@Override
	public void setValue(Object value) {
		mView.setText(value.toString());
	}

	@Override
	public <V> V getValue() {
		return (V) mView.getText().toString();

	}

	@Override
	public CheckedResult checkInputValue() {
		CheckedResult result = new CheckedResult();
		String name = getValue();
		if (!name.equals("100")) {
			result.setResult(false, "密码错误");
		} else {
			result.setResult(true);
		}
		return result;
	}

}
