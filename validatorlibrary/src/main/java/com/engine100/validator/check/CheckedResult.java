package com.engine100.validator.check;

/**
 * 校验结果
 */
public class CheckedResult {

	public static final CheckedResult SUCCESS_RESULT = new CheckedResult(true, "CHECKSUCCESS!");
	public static final CheckedResult FAILED_RESULT = new CheckedResult(false, "CHECKFAILED!");

	private boolean success;
	private String msg;

	public CheckedResult() {
		success = true;
		msg = "";
	}

	public boolean Success() {
		return success;
	}

	public boolean Failed() {
		return !success;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public CheckedResult(boolean s, String msg) {
		this.success = s;
		this.msg = msg;
	}

	public CheckedResult setResult(boolean success) {
		this.success = success;
		return this;
	}

	public CheckedResult setResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
		return this;
	}

	public CheckedResult setResultFailed(String msg) {
		this.success = false;
		this.msg = msg;

		return this;

	}

	public CheckedResult setResultSuccess(String msg) {
		this.success = true;

		this.msg = msg;
		return this;
	}

}
