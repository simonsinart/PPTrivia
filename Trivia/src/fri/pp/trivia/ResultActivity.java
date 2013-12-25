package fri.pp.trivia;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.triviality.*;

public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		// get rating bar object
		RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		// get text view
		TextView t = (TextView) findViewById(R.id.textResult);
		TextView sc = (TextView) findViewById(R.id.textScore);
		// get score
		Bundle b = getIntent().getExtras();
		int score = b.getInt("score");
		// display score
		bar.setRating(score);
		switch (score) {
		case 0: 
			t.setText("0/5 - Ne ravno najbolje! Poskusi ponovno!");
			
		case 1:
			t.setText("1/5 - Ne ravno najbolje! Poskusi ponovno!");
			
			break;
		case 2:
			t.setText("2/5 - Lahko bi bilo boljše! Poskusi ponovno!");
			
			break;
		case 3:
			t.setText("3/5 - Si na dobri poti!");
			
			break;
		case 4:
			t.setText("4/5 - Le še korak ti manjka!");
			
			break;
		case 5:
			t.setText("5/5 - Odlièno! Vseh 5 odgovorov je pravilnih!");
			
			break;
		}
		
		int scoreNumber = score*17*(3000-b.getInt("res"));
		StringBuilder sb = new StringBuilder();
		sb.append("Dosegel si ");
		sb.append(Integer.toString(scoreNumber));
		sb.append(" število toèk! Score number = ");
		sb.append(Integer.toString(b.getInt("res")));
		sc.setText((sb));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
}
