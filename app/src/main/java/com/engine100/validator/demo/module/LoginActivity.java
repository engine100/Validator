package com.engine100.validator.demo.module;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.engine100.validator.check.CheckContainerManager;
import com.engine100.validator.check.CheckedResult;
import com.engine100.validator.common.ChinaIdCardContainer;
import com.engine100.validator.demo.R;

public class LoginActivity extends Activity {

	private CheckContainerManager mCheckManager;
	private EditText mUserName;
	private EditText mUserPass;
	private EditText mBar;
	private Button mLoginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCheckManager = new CheckContainerManager();
		mUserName = $(R.id.user_name);
		mUserPass = $(R.id.user_pass);
		mLoginButton = $(R.id.btn_login);
		mBar = $(R.id.bar);
		//mCheckManager.addContainer(new UserNameCheckContainer(mUserName, null));
		//mCheckManager.addContainer(new UserPassCheckContainer(mUserPass, null));
		//mCheckManager.addContainer(new EmailCheckContainer(mBar));
		mCheckManager.addContainer(new ChinaIdCardContainer(mBar) {
			public String getErrorMsg() {
				return "身份证不对";
			}
		});
		//mCheckManager.addContainer(new BarCodeCheckContainer(mBar, null));
		//mCheckManager.addContainer(new LoginCheckContainer(null, new Object[] { mUserName, mUserPass }));

		mLoginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// CheckedResult result = mCheckManager.checkValues();
				// if (!result.Success()) {
				// Toast.makeText(getBaseContext(), result.getMsg(),
				// Toast.LENGTH_SHORT).show();
				// return;
				// }
				//
				// Toast.makeText(getBaseContext(), "成功",
				// Toast.LENGTH_SHORT).show();

				mCheckManager.checkValues(new CheckContainerManager.CheckListener() {
					@Override
					public void validResult(CheckedResult result) {
						if (!result.Success()) {
							Toast.makeText(getBaseContext(), result.getMsg(), Toast.LENGTH_SHORT).show();
							return;
						}
					}
				});
			}
		});
	}

	@SuppressWarnings("unchecked")
	protected <T> T $(int id) {
		return (T) findViewById(id);
	}

}
