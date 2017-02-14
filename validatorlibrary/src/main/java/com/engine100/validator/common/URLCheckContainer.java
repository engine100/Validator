package com.engine100.validator.common;

import java.net.MalformedURLException;
import java.net.URL;
import android.widget.TextView;
import com.engine100.validator.check.CheckedResult;
import com.engine100.validator.common.base.TextViewCheckContainer;

/**
 * URL 校验
 */
public class URLCheckContainer extends TextViewCheckContainer {

	public URLCheckContainer(TextView view) {
		super(view);
	}

	@Override
	public CheckedResult checkInputValue() {
		String urlString = getValue();

		try {
			new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return new CheckedResult(false, getErrorMsg());
		}
		return CheckedResult.SUCCESS_RESULT;

	}

	@Override
	public String getErrorMsg() {
		return "Wrong URL";
	}

}
