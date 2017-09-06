package cn.com.kind.dzxxmoa.ui.activity;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;

/**
 * 错误页
 * @author ling_cx
 * @date 2017/8/10.
 */
public class ErrorActivity extends BaseActivity {
	@BindView(R.id.customactivityoncrash_error_activity_image)
	ImageView mCustomactivityoncrashErrorActivityImage;
	@BindView(R.id.customactivityoncrash_error_activity_restart_button)
	Button mCustomactivityoncrashErrorActivityRestartButton;
	@BindView(R.id.customactivityoncrash_error_activity_more_info_button)
	Button mCustomactivityoncrashErrorActivityMoreInfoButton;
	@BindView(R.id.customactivityoncrash_error_activity_tell_us_button)
	Button mCustomactivityoncrashErrorActivityTellUsButton;

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_error;
	}

	@Override
	protected void initViews() {
		getToolBar().setDisplayHomeAsUpEnabled(false)
		.setTitle("An unexpected error occurred!");
	}

	@Override
	protected void initData() {
		//获取配置信息
		final CaocConfig config = CustomActivityOnCrash.getConfigFromIntent(getIntent());
		if (config.isShowRestartButton() && config.getRestartActivityClass()!=null) {
			mCustomactivityoncrashErrorActivityRestartButton.setText(R.string.customactivityoncrash_error_activity_restart_app);
			mCustomactivityoncrashErrorActivityRestartButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					CustomActivityOnCrash.restartApplication(ErrorActivity.this, config);
				}
			});
		} else {
			mCustomactivityoncrashErrorActivityRestartButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					CustomActivityOnCrash.closeApplication(ErrorActivity.this, config);
				}
			});
		}

		if (config.isShowErrorDetails()) {
			mCustomactivityoncrashErrorActivityMoreInfoButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					AlertDialog dialog = new AlertDialog.Builder(ErrorActivity.this)
							.setTitle(R.string.customactivityoncrash_error_activity_error_details_title)
							.setMessage(CustomActivityOnCrash.getAllErrorDetailsFromIntent(ErrorActivity.this, getIntent()))
							.setPositiveButton(R.string.customactivityoncrash_error_activity_error_details_close, null)
							.setNeutralButton(R.string.customactivityoncrash_error_activity_error_details_copy,
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialog, int which) {
											copyErrorToClipboard();
											Toast.makeText(ErrorActivity.this, R.string.customactivityoncrash_error_activity_error_details_copied, Toast.LENGTH_SHORT).show();
										}
									})
							.show();
					TextView textView = (TextView) dialog.findViewById(android.R.id.message);
					textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.customactivityoncrash_error_activity_error_details_text_size));
				}
			});
		} else {
			mCustomactivityoncrashErrorActivityMoreInfoButton.setVisibility(View.GONE);
		}

		Integer defaultErrorActivityDrawableId = config.getErrorDrawable();
		ImageView errorImageView = ((ImageView) findViewById(R.id.customactivityoncrash_error_activity_image));

		if (defaultErrorActivityDrawableId != null) {
			errorImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), defaultErrorActivityDrawableId, getTheme()));
		}
	}

	@Override
	protected void initInject() {

	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[0];
	}

	@Override
	protected String getOperateType() {
		return null;
	}

	/**
	 * 将错误信息复制到剪贴板
	 */
	private void copyErrorToClipboard() {
		String errorInformation = CustomActivityOnCrash.getAllErrorDetailsFromIntent(ErrorActivity.this, getIntent());

		ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		ClipData clip = ClipData.newPlainText(getString(R.string.customactivityoncrash_error_activity_error_details_clipboard_label), errorInformation);
		clipboard.setPrimaryClip(clip);
	}

}
