package com.healthlife.util;

import java.util.List;

import com.healthlife.R;
import com.healthlife.entity.GlobalVariables;
import com.healthlife.entity.Sports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SportsAdapter extends ArrayAdapter<Sports> {
	
	private int pushUpId,sitUpId,walkId,jogId;
	
	private int resourceId;
	
	public SportsAdapter(Context context, int resource, List<Sports> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		resourceId=resource;
	}
	
	public View getView(int position,View convertView,ViewGroup parent){
		Sports sports = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView  sportsImage = (ImageView)view.findViewById(R.id.image_sports_type);
		TextView textDate = (TextView)view.findViewById(R.id.text_list_date);
		TextView textNum = (TextView)view.findViewById(R.id.text_list_num);
		TextView textDuration = (TextView)view.findViewById(R.id.text_list_num1);
				
		switch(sports.getType()){
		
		case GlobalVariables.SPORTS_TYPE_JOG:
			sportsImage.setImageResource(R.drawable.jog_logo_black);
			textNum.setText(String.format("%.2f",sports.getDistance()/1000) + " KM");
			textDuration.setText(sports.getDuration());
			break;
		case GlobalVariables.SPORTS_TYPE_PUSHUP:
			sportsImage.setImageResource(R.drawable.pushup_logo);
			textNum.setText(String.valueOf(sports.getNum()) + " ��");
			textDuration.setText(sports.getDuration());
			break;
		case GlobalVariables.SPORTS_TYPE_SITUP:
			sportsImage.setImageResource(R.drawable.situp_logo);
			textNum.setText(String.valueOf(sports.getNum()) + " ��");
			textDuration.setText(sports.getDuration());
			break;
		case GlobalVariables.SPORTS_TYPE_WALK:
			//sportsImage.setImageResource(walkId);
			textNum.setText(String.valueOf(sports.getNum()));
			break;
		default:
		
		}
		textDate.setText(sports.getDate());		
		return view;		
	}

}
