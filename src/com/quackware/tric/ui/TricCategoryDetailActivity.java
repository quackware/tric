package com.quackware.tric.ui;

import com.quackware.tric.MyApplication;
import com.quackware.tric.R;
import com.quackware.tric.stats.Stats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class TricCategoryDetailActivity extends Activity implements OnClickListener{
	
	
	private static final String TAG = "TricCategoryDetailActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tric_category_detail);
		
		String category = getIntent().getExtras().getString("Category");
		
		loadCategory(category);
	}
	
	private void loadCategory(String category)
	{
		LinearLayout ll = (LinearLayout)findViewById(R.id.catdetail_ll);
		for(Stats s : MyApplication.getStats())
		{
			if(s.getType().equals(category))
			{
				Button b = new Button(this);
				b.setText(s.getName());
				b.setTag(s.getName());
				b.setOnClickListener(this);
				ll.addView(b);
			}
		}
	}

	@Override
	public void onClick(View view) {
		String name = (String)view.getTag();
		try
		{
			Intent intent = new Intent(this,TricDetailActivity.class);
			intent.putExtra("tricName", name);
			startActivity(intent);
		}
		catch(Exception ex)
		{
			Log.e(TAG,"Unable to start tric detail activity with name " + name);
			return;
		}
	}

}