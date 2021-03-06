package com.example.customlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Main extends ListActivity{
	String[] list = {"ipsum", "laurum", "etgort", "youturt", "semilale", "tortouse",
			"germone", "alchemisery","nupperror", "surrondstores", "sandstrom", "peat", 
			"sorn", "tabola", "stibula", "tyrannus", "softpore", "loonytonn", "swiff",
			"shak", "tacke"};
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new MyAdapter(this, R.layout.row, list));
		
	}
	
	class MyAdapter extends ArrayAdapter{
	
		private Context context;
		
		ArrayList<State> states = new ArrayList<State>();

		public MyAdapter(Context context, int resource, String[] objects) {
			super(context, resource, objects);
			this.context = context;
			
			
			for(String item : list){
				State state = new State();
				state.text = item;
				state.textSize = 20;
				state.textColor = Color.BLACK;
				states.add(state);
			}
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView label;
			//reuse converView if you can to speed up scrolling on listview
			if(convertView == null){
				//inflate the listview
				LayoutInflater inflator = ((Activity)context).getLayoutInflater();
				convertView = inflator.inflate(R.layout.row, parent, false);
				convertView.setTag(R.id.textView1, convertView.findViewById(R.id.textView1));
				
			}
			
			label = (TextView) convertView.getTag(R.id.textView1);
			label.setText(states.get(position).text);
			label.setTextColor(states.get(position).textColor);
			label.setTextSize(states.get(position).textSize);
			
			if(states.get(position).text.contains("s")){
				label.setTextColor(Color.GREEN);
				states.get(position).textColor = Color.GREEN;
			}
			
			
			return convertView;
		}
				

	}
	
	class State{
		float textSize;
		int textColor;
		String text;
		
	}

}
