package com.engine100.validator.demo;

import android.widget.EditText;
import com.engine100.validator.check.CheckContainer;
import com.engine100.validator.check.CheckedResult;

public class UserNameCheckContainer extends CheckContainer<EditText> {

	public UserNameCheckContainer(EditText view, Object[] validObjects) {
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
		if (!name.equals("zcc")) {
			result.setResult(false, "用户名是zcc");
		}

		else {
			result.setResult(true);
		}
		return result;
	}

	 

}
