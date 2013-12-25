package fri.pp.trivia;

import java.util.List;

import com.example.triviality.*;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends Activity {
	List<Question> quesList;
	int score = 0;
	int qid = 0;
	Question currentQ;
	TextView txtQuestion;
	RadioButton rda, rdb, rdc;
	Button butNext;
	private CountDownTimer countDownTimer;
	private boolean timerHasStarted = false;
	public TextView time;
	private final long startTime = 30 * 1000;
	private final long interval = 1 * 1000;
	String sec;
	int res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		DbHelper db = new DbHelper(this);
		quesList = db.getAllQuestions();
		currentQ = quesList.get(qid);
		txtQuestion = (TextView) findViewById(R.id.textView1);
		rda = (RadioButton) findViewById(R.id.radio0);
		rdb = (RadioButton) findViewById(R.id.radio1);
		rdc = (RadioButton) findViewById(R.id.radio2);
		butNext = (Button) findViewById(R.id.button1);
		setQuestionView();
		time = (TextView) this.findViewById(R.id.timer);
		countDownTimer = new MyCountDownTimer(startTime, interval);
		time.setText(time.getText() + String.valueOf(startTime / 1000));

		if (!timerHasStarted) {
			countDownTimer.start();
			timerHasStarted = true;

		} 

		butNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
				RadioButton answer = (RadioButton) findViewById(grp
						.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
				if (currentQ.getANSWER().equals(answer.getText())) {
					score++;
					Log.d("score", "Your score" + score);
				}
				if (qid < 5) {
					currentQ = quesList.get(qid);
					setQuestionView();
				} else {
					countDownTimer.cancel();
					timerHasStarted = false;
					sec = time.getText() + String.valueOf(startTime / 1000);
					res = Integer.parseInt(sec);
					
					Intent intent = new Intent(QuizActivity.this,
							ResultActivity.class);
					
					Bundle b = new Bundle();
					b.putInt("score", score); 
					b.putInt("res", res);
				
					intent.putExtras(b); 
					startActivity(intent);
					finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}

	private void setQuestionView() {
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		qid++;
	}

	public class MyCountDownTimer extends CountDownTimer {
		public MyCountDownTimer(long startTime, long interval) {
			super(startTime, interval);
		}

		@Override
		public void onFinish() {
			time.setText("Time's up!");
		}

		@Override
		public void onTick(long millisUntilFinished) {
			time.setText("" + millisUntilFinished / 1000);
		}
	}
}
