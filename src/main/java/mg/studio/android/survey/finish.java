package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class finish extends AppCompatActivity {
    String[] inputArr;
    Button finishbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_survey);
        finishbtn = (Button) findViewById(R.id.finish);
        finishbtn.setOnClickListener(ButtonClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
    }
    View.OnClickListener ButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.finish:
                    Intent intent = new Intent(finish.this, report.class);
                    intent.putExtra("inputArr", inputArr);
                    startActivity(intent);
            }
        }
    };
}
