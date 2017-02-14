package com.engine100.validator.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.TextView;
import com.engine100.validator.check.CheckedResult;
import com.engine100.validator.common.base.TextViewCheckContainer;

/**
 * 电子邮件校验
 */
public class EmailCheckContainer extends TextViewCheckContainer {

	public EmailCheckContainer(TextView view) {
		super(view);
	}

	private static final String mailPattern = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";

	@Override
	public CheckedResult checkInputValue() {
		String mail = getValue();

		Pattern r = Pattern.compile(mailPattern);
		Matcher m = r.matcher(mail);
		boolean match = m.matches();
		if (match) {
			return CheckedResult.SUCCESS_RESULT;
		} else {
			return new CheckedResult(false, getErrorMsg());
		}

	}

	@Override
	public String getErrorMsg() {
		return "Wrong Email Address";
	}

}
