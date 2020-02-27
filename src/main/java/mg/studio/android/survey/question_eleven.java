package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class question_eleven extends AppCompatActivity {
    Button q11_next;
    int count = 0;
    String[] inputArr;
    String q11input;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eleven);
        q11_next = (Button)findViewById(R.id.q11_next);
        q11_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q11_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    count += 1;
                    RadioButton e = (RadioButton) findViewById(id);
                    q11input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q11_next:
                    if(count > 0)
                    {
                        Intent intent = new Intent(question_eleven.this,question_twelve.class);
                        intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],
                                inputArr[2],inputArr[3],inputArr[4],inputArr[5],inputArr[6],
                                inputArr[7],inputArr[8],inputArr[9],q11input});
                        startActivity(intent);
                    }

            }
        }
    };
}
