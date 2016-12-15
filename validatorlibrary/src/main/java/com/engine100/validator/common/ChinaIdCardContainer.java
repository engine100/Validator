package com.engine100.validator.common;

import android.widget.TextView;
import com.engine100.validator.check.CheckedResult;
import com.engine100.validator.common.base.TextViewCheckContainer;
import com.engine100.validator.utils.IdcardValidatorCHINA;

/**
 * 中国的居民身份证校验，15位和18位
 * @description</br>
 * 
 * @author ZhuChengCheng
 * @github https://github.com/engine100
 * @time 2016年12月7日 - 上午8:58:52
 */
public class ChinaIdCardContainer extends TextViewCheckContainer {

	public ChinaIdCardContainer(TextView view) {
		super(view);
	}

	@Override
	public CheckedResult checkInputValue() {
		String idcard = getValue();

		IdcardValidatorCHINA valid = new IdcardValidatorCHINA();

		if (!valid.validAll(idcard)) {
			return new CheckedResult(false, getErrorMsg());
		}
		return CheckedResult.SUCCESS_RESULT;

	}

	@Override
	public String getErrorMsg() {
		return "Wrong IdCard";
	}

}
