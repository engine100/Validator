package com.engine100.validator.check;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import com.engine100.validator.input.InputView;

/**
 * 校验工具
 */
public class CheckContainerManager {
	private List<InputView> mInputViews;
	private Handler mHandler;

	public CheckContainerManager() {
		mInputViews = new ArrayList<InputView>();
		mHandler = new Handler();

	}

	public void addContainer(InputView input) {
		mInputViews.add(input);
	}

	public void removeContainer(InputView input) {
		mInputViews.remove(input);
	}

	public void clearContainer() {
		mInputViews.clear();
	}

	/**
	 * 同步校验
	 */
	public CheckedResult checkValuesSync() {

		if (mInputViews == null || mInputViews.size() == 0) {
			return CheckedResult.SUCCESS_RESULT;
		}
		for (int i = 0; i < mInputViews.size(); i++) {
			CheckedResult result = mInputViews.get(i).checkInputValue();
			if (result != null && result.Failed()) {
				return result;
			}
		}
		return CheckedResult.SUCCESS_RESULT;
	}

	@Deprecated
	public CheckedResult checkValues() {
		return checkValuesSync();
	}

	public interface CheckListener {
		public void validResult(CheckedResult result);
	}

	/**
	 * 异步校验
	 */
	public void checkValues(final CheckListener callBack) {
		if (callBack == null) {
			return;
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				CheckedResult result = checkValuesSync();
				handleResultUI(callBack, result);
			}
		}).start();
	}

	private void handleResultUI(final CheckListener callBack, final CheckedResult result) {
		mHandler.post(new Runnable() {
			public void run() {
				callBack.validResult(result);
			}
		});
	}

}
