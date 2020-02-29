package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_six extends AppCompatActivity {
    Button q6_next;
    EditText editText;
    String[] inputArr;
    String q6input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
        q6_next = (Button)findViewById(R.id.q6_next);
        q6_next.setOnClickListener(ButtonClick);
        editText = (EditText)findViewById(R.id.q6_edittext);
        inputArr = getIntent().getStringArrayExtra("inputArr");
    }
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q6_next:
                    if(editText.length()!=0)
                    {
                        q6input = editText.getText().toString();
                        //editText.setText(inputArr[2]);
                        Intent intent = new Intent(Question_six.this,Question_seven.class);
                        intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],
                                inputArr[2],inputArr[3],inputArr[4],q6input});
                        startActivity(intent);
                    }

            }
        }
    };
}
