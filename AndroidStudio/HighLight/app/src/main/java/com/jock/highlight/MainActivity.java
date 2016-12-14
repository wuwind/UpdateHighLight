package com.jock.highlight;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jock.lib.HighLight;

public class MainActivity extends Activity
{

	private HighLight mHightLight;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.id_btn_amazing).post(new Runnable()
		{
			@Override
			public void run()
			{
				showTipMask();
			}
		}

		);

	}

	private void showTipMask()
	{
		mHightLight = new HighLight(MainActivity.this)//
				.anchor(findViewById(R.id.id_container))// 如果是Activity上增加引导层，不需要设置anchor
				.addHighLight(R.id.id_btn_important, R.layout.info_up, new HighLight.OnPosCallback()
				{
					@Override
					public void getPos(float rightMargin, float bottomMargin, RectF rectF, HighLight.MarginInfo marginInfo)
					{
						System.out.println("rectF.right" + rectF.right);
						System.out.println("rectF.width()" + rectF.width());
						System.out.println("rectF.bottom" + rectF.bottom);
						System.out.println("--------------------------------------------------------------------");

						marginInfo.leftMargin = rectF.right - rectF.width() / 2;
						marginInfo.topMargin = rectF.bottom;
					}
				})

				.addHighLight(R.id.id_btn_amazing, R.layout.info_down, new HighLight.OnPosCallback()
				{
					/**
					 * @param rightMargin
					 *            高亮view在anchor中的右边距
					 * @param bottomMargin
					 *            高亮view在anchor中的下边距
					 * @param rectF
					 *            高亮view的l,t,r,b,w,h都有
					 * @param marginInfo
					 *            设置你的布局的位置，一般设置l,t或者r,b
					 */
					@Override
					public void getPos(float rightMargin, float bottomMargin, RectF rectF, HighLight.MarginInfo marginInfo)
					{

						System.out.println("rightMargin" + rightMargin);
						System.out.println("rectF.width()" + rectF.width());
						System.out.println("rectF.height()" + rectF.height());
						System.out.println("bottomMargin" + bottomMargin);
						System.out.println("--------------------------------------------------------------------");
						marginInfo.rightMargin = rightMargin + rectF.width() / 2;
						marginInfo.bottomMargin = bottomMargin + rectF.height();
					}

				});
		// .addHighLight(R.id.id_btn_important_right,
		// R.layout.info_gravity_right_up, new HighLight.OnPosCallback()
		// {
		//
		// @Override
		// public void getPos(float rightMargin, float bottomMargin, RectF
		// rectF, HighLight.MarginInfo marginInfo)
		// {
		//
		// System.out.println("rightMargin" + rightMargin);
		// System.out.println("rectF.top()" + rectF.top);
		// System.out.println("rectF.height()" + rectF.height());
		// System.out.println("bottomMargin" + bottomMargin);
		// System.out.println("--------------------------------------------------------------------");
		// marginInfo.rightMargin = rightMargin;
		// marginInfo.topMargin = rectF.top + rectF.height();
		// }
		// }).addHighLight(R.id.id_btn_whoami, R.layout.info_gravity_left_down,
		// new HighLight.OnPosCallback()
		// {
		//
		// @Override
		// public void getPos(float rightMargin, float bottomMargin, RectF
		// rectF, HighLight.MarginInfo marginInfo)
		// {
		// System.out.println("rectF.width()" + rectF.width());
		// System.out.println("rectF.right" + rectF.right);
		// System.out.println("rectF.height()" + rectF.height());
		// System.out.println("bottomMargin" + bottomMargin);
		// marginInfo.leftMargin = rectF.right - rectF.width() / 2;
		// marginInfo.bottomMargin = bottomMargin + rectF.height();
		// }
		// }).setClickCallback(new HighLight.OnClickCallback()
		// {
		// @Override
		// public void onClick()
		// {
		// Toast.makeText(MainActivity.this, "clicked",
		// Toast.LENGTH_SHORT).show();
		// }
		// });

		mHightLight.show();
	}

	public void remove(View view)
	{
		mHightLight.remove();
	}

	public void add(View view)
	{
		mHightLight.show();
	}

}
