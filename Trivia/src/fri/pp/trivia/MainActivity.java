package fri.pp.trivia;

import com.example.triviality.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
	}
	
	public void startGame(View view){
		Intent intent = new Intent(view.getContext(), QuizActivity.class);
		this.startActivity(intent);
		
	}
	
	//intent za top10 - ko bo top 10 izdelan
	/**
	public void startTop10(View view){
		Intent intent = new Intent(view.getContext(), QuizActivity.class);
		this.startActivity(intent);
		
	}**/
	
	public void startInfo(View view){
		Intent intent = new Intent(view.getContext(), Info.class);
		this.startActivity(intent);
		
	}
	
}
