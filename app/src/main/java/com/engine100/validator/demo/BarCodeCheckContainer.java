package com.engine100.validator.demo;

import android.widget.EditText;
import android.widget.TextView;
import com.engine100.validator.check.CheckContainer;
import com.engine100.validator.check.CheckedResult;

public class BarCodeCheckContainer extends CheckContainer<TextView> {

	public BarCodeCheckContainer(EditText view, Object[] validObjects) {
		super(view, validObjects);
	}

	@Override
	public void setValue(Object value) {
		mView.setText(value.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> V getValue() {
		return (V) mView.getText().toString();

	}

	@Override
	public CheckedResult checkInputValue() {
		CheckedResult result = new CheckedResult(false, "错误");
		String barcode = getValue();
		if (!barcode.contains("123")) {
			return result.setResultFailed("条码要有123");
		} else {
			result.setResult(true, "校验成功");
		}
		return result;
	}

}
