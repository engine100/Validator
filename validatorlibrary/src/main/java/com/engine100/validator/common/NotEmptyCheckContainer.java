package com.engine100.validator.common;

import android.widget.TextView;
import com.engine100.validator.check.CheckedResult;
import com.engine100.validator.common.base.TextViewCheckContainer;

/**
 * 非空校验
 * @description</br>
 * @author ZhuChengCheng
 * @github https://github.com/engine100
 * @time 2016年12月7日 - 上午8:59:37 
 */
public class NotEmptyCheckContainer extends TextViewCheckContainer {

	public NotEmptyCheckContainer(TextView view) {
		super(view);
	}

	@Override
	public CheckedResult checkInputValue() {
		String text = getValue();
		text = text.trim();
		if (text.length() > 0) {
			return CheckedResult.SUCCESS_RESULT;
		}

		else {
			return new CheckedResult(false, getErrorMsg());
		}

	}

	@Override
	public String getErrorMsg() {
		return "The Inputs Can not be empty";
	}

}
