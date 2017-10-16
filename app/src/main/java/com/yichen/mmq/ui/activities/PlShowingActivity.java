package com.yichen.mmq.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseActivity;
import com.yichen.mmq.bean.Room;
import com.yichen.mmq.ui.room.view.IRoomView;
import com.yichen.mmq.ui.room.presenter.RoomPresenter;
import com.yichen.mmq.utils.DecimalUtil;
import com.yichen.mmq.utils.UIUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * This is a demo activity of PLVideoView
 */
public class PlShowingActivity extends BaseActivity<IRoomView, RoomPresenter>
		implements IRoomView {

	private static final String TAG = PlShowingActivity.class.getSimpleName();
	@Bind(R.id.VideoView)
	PLVideoTextureView mVideoView;
	@Bind(R.id.iv_back)
	ImageView ivBack;
	@Bind(R.id.iv_share)
	ImageView ivShare;
	@Bind(R.id.CoverView)
	ImageView coverView;
	@Bind(R.id.LoadingView)
	LinearLayout LoadingView;
	@Bind(R.id.StatInfoTextView)
	TextView mStatInfoTextView;
	@Bind(R.id.tv_title)
	TextView tvTitle;
	@Bind(R.id.tv_viewer)
	TextView tvViewer;
	@Bind(R.id.fl_transparent)
	RelativeLayout flTransparent;
	@Bind(R.id.rl_request)
	RelativeLayout rl_request;


	private Toast mToast = null;
	private int mDisplayAspectRatio = PLVideoTextureView.ASPECT_RATIO_PAVED_PARENT;


	private int uid;
	private Room mRoom;

	private boolean isQuanlity;//是否超清
	@Inject
	RoomPresenter roomPresenter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		isNeedInject = true;
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mToast = null;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mVideoView.stopPlayback();
		mVideoView.releaseSurfactexture();
	}

	@Override
	protected RoomPresenter createPresenter() {
		build.inject(this);
		return roomPresenter;
	}

	@Override
	public void initData() {
		super.initData();
		roomPresenter.getRoom(uid);
	}


	@Override
	public void initListener() {
		super.initListener();
		// Set some listeners

		mVideoView.setLooping(getIntent().getBooleanExtra("loop", true));
		mVideoView.setOnInfoListener(mOnInfoListener);
		mVideoView.setOnCompletionListener(mOnCompletionListener);
		mVideoView.setOnErrorListener(mOnErrorListener);
		mVideoView.setOnPreparedListener(new PLMediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(PLMediaPlayer plMediaPlayer, int i) {
				Log.e(TAG, "onPrepared: ");
				mVideoView.start();
				Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn
						(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
					@Override
					public void call(Long aLong) {
						flTransparent.setVisibility(View.GONE);
					}
				});
			}
		});

	}


	@Override
	public void initBeforeContentView() {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.activity_plshow_video_view;
	}

	private PLMediaPlayer.OnInfoListener mOnInfoListener = new PLMediaPlayer
			.OnInfoListener() {
		@Override
		public boolean onInfo(PLMediaPlayer plMediaPlayer, int what, int extra) {
			// Log.i(TAG, "OnInfo, what = " + what + ", extra = " + extra);
			switch (what) {
				case PLMediaPlayer.MEDIA_INFO_BUFFERING_START:
					break;
				case PLMediaPlayer.MEDIA_INFO_BUFFERING_END:
					break;
				case PLMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
					showToastTips("first video render time: " + extra + "ms");
					break;
				case PLMediaPlayer.MEDIA_INFO_AUDIO_RENDERING_START:
					break;
				case PLMediaPlayer.MEDIA_INFO_VIDEO_FRAME_RENDERING:
					//    Log.i(TAG, "video frame rendering, ts = " + extra);
					break;
				case PLMediaPlayer.MEDIA_INFO_AUDIO_FRAME_RENDERING:
					//  Log.i(TAG, "audio frame rendering, ts = " + extra);
					break;
				case PLMediaPlayer.MEDIA_INFO_VIDEO_GOP_TIME:
					// Log.i(TAG, "Gop Time: " + extra);
					break;
				case PLMediaPlayer.MEDIA_INFO_SWITCHING_SW_DECODE:
					//   Log.i(TAG, "Hardware decoding failure, switching software
					// decoding!");
					break;
				case PLMediaPlayer.MEDIA_INFO_METADATA:
					// Log.i(TAG, mVideoView.getMetadata().toString());
					break;
				case PLMediaPlayer.MEDIA_INFO_VIDEO_BITRATE:
				case PLMediaPlayer.MEDIA_INFO_VIDEO_FPS:
					updateStatInfo();
					break;
				case PLMediaPlayer.MEDIA_INFO_CONNECTED:
					Log.i(TAG, "Connected !");
					break;
				default:
					break;
			}
			return true;
		}
	};

	/*@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		ViewGroup.LayoutParams layoutParams = mVideoView.getLayoutParams();
		if (newConfig.orientation == 2) {
			mDisplayAspectRatio = PLVideoView.ASPECT_RATIO_PAVED_PARENT;
			showToastTips("Paved parent !");
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
			fl_room_bar.setVisibility(View.GONE);
		} else {
			mDisplayAspectRatio = PLVideoView.ASPECT_RATIO_ORIGIN;
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
			fl_room_bar.setVisibility(View.VISIBLE);
			showToastTips("fit parent !");
		}
		mVideoView.setDisplayAspectRatio(mDisplayAspectRatio);
	}*/

	private PLMediaPlayer.OnErrorListener mOnErrorListener = new PLMediaPlayer
			.OnErrorListener() {
		@Override
		public boolean onError(PLMediaPlayer mp, int errorCode) {
			Log.e(TAG, "Error happened, errorCode = " + errorCode);
			switch (errorCode) {
				case PLMediaPlayer.ERROR_CODE_IO_ERROR:
					/**
					 * SDK will do reconnecting automatically
					 */
					Log.e(TAG, "IO Error!");
					return false;
				case PLMediaPlayer.ERROR_CODE_OPEN_FAILED:
					showToastTips("failed to open player !");
					recreate();
					return true;

				case PLMediaPlayer.ERROR_CODE_SEEK_FAILED:
					showToastTips("failed to seek !");
					break;
				default:
					showToastTips("unknown error !");
					break;
			}
			finish();
			return true;
		}
	};

	private PLMediaPlayer.OnCompletionListener mOnCompletionListener = new PLMediaPlayer
			.OnCompletionListener() {
		@Override
		public void onCompletion(PLMediaPlayer plMediaPlayer) {
			Log.i(TAG, "Play Completed !");
			showToastTips("Play Completed !");
			finish();
		}
	};







	private void showToastTips(final String tips) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (mToast != null) {
					mToast.cancel();
				}
				mToast = Toast.makeText(PlShowingActivity.this, tips, Toast
						.LENGTH_SHORT);
				mToast.show();
			}
		});
	}

	private void updateStatInfo() {
		long bitrate = mVideoView.getVideoBitrate() / 1024;
		final String stat = bitrate + "kbps, " + mVideoView.getVideoFps() + "fps";
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				mStatInfoTextView.setText(stat);
			}
		});
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void oncompleted() {
		Log.e(TAG, "oncompleted: ");
	}

	@Override
	public void onError(Throwable e) {
		Log.e(TAG, "onError: ");
	}

	@Override
	public void OnRoomListener(Room room) {
		if (room != null) {
			Log.e(TAG, "OnRoomListener: " + room.toString());
			Glide.with(this).load(room.getThumb()).diskCacheStrategy(DiskCacheStrategy
					.ALL)
					.into(coverView);
			mVideoView.setVideoPath(room.getLive().getWs().getFlv().getValue(isQuanlity)
					.getSrc());

			initListener(room);
		}
	}

	@Override
	public void initView() {
		super.initView();


		uid = getIntent().getIntExtra(Constants.KEY_UID, 00);


		View loadingView = findViewById(R.id.LoadingView);
		loadingView.setVisibility(View.VISIBLE);
		mVideoView.setBufferingIndicator(loadingView);
		View mCoverView = findViewById(R.id.CoverView);
		mVideoView.setCoverView(mCoverView);

		mStatInfoTextView = (TextView) findViewById(R.id.StatInfoTextView);


		AVOptions options = new AVOptions();
		// the unit of timeout is ms
		options.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);
		// 1 -> hw codec enable, 0 -> disable [recommended]
		//设置硬解码还是软解码
		options.setInteger(AVOptions.KEY_MEDIACODEC, AVOptions.MEDIA_CODEC_AUTO);
		mVideoView.setAVOptions(options);
		mVideoView.setDebugLoggingEnabled(true);


	}

	private void initListener(Room room) {
		mVideoView.setDisplayAspectRatio(mDisplayAspectRatio);
		tvTitle.setText(room.getTitle());
		tvViewer.setText(DecimalUtil.getInstance().formatNumber(room.getView() + ""));


	}
	@OnClick({R.id.iv_back, R.id.iv_share, R.id.rl_request})
	public void onViewClicked(final View view) {
		switch (view.getId()) {
			case R.id.iv_back:
				finish();
				break;
			case R.id.iv_share:
				UIUtils.showToast("分享");
				break;
			case R.id.rl_request:
				UIUtils.showToast("fl");
				flTransparent.setVisibility(View.VISIBLE);
				Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn
						(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
					@Override
					public void call(Long aLong) {
						flTransparent.setVisibility(View.GONE);
					}
				});
				break;
		}
	}

}
