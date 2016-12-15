package com.engine100.validator.demo.module;

import android.widget.TextView;
import com.engine100.validator.check.CheckContainer;
import com.engine100.validator.check.CheckedResult;

public class LoginCheckContainer extends CheckContainer<Void> {

	public LoginCheckContainer(Void view, Object[] validObjects) {
		super(view, validObjects);
	}

	@Override
	public void setValue(Object value) {

	}

	@Override
	public <V> V getValue() {
		return null;
	}

	@Override
	public CheckedResult checkInputValue() {
		TextView nameTV = parseObject(mValidObjects[0]);
		TextView passTV = parseObject(mValidObjects[1]);
		CheckedResult result = new CheckedResult();
		String name = nameTV.getText().toString();
		String pass = passTV.getText().toString();
		if (!name.equals("zcc")) {
			result.setResult(false, "用户名错误");
		}

		else if (!pass.equals("100")) {
			result.setResult(false, "密码错误");
		}

		else {
			result.setResult(true);
		}

		return result;
	}

}
