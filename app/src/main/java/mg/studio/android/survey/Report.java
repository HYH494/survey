package mg.studio.android.survey;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Report extends AppCompatActivity {
    String[] inputArr;
    TextView textview;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        inputArr = getIntent().getStringArrayExtra("inputArr");
        textview = (TextView)findViewById(R.id.show_answer);
        textview.setMovementMethod(ScrollingMovementMethod.getInstance());
        String temp = "Q1：" + inputArr[0] + "\nQ2：" + inputArr[1] + "\nQ3：" + inputArr[2] +
                "\nQ4：" + inputArr[3] + "\nQ5："+ inputArr[4] + "\nQ6：" + inputArr[5] +
                "\nQ7：" + inputArr[6] + "\nQ8："+ inputArr[7] + "\nQ9：" + inputArr[8] +
                "\nQ10："+ inputArr[9] + "\nQ11："+ inputArr[10] + "\nQ12：" + inputArr[11];
        textview.setText(temp);

        button = (Button)findViewById(R.id.report);
        button.setOnClickListener(ButtonClick);
    }
    View.OnClickListener ButtonClick = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.report:
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File sdfile = getExternalFilesDir(null);
                        FileOutputStream fout = null;
                        File savedata = new File(sdfile,"report.json");
                        try {
                            fout = new FileOutputStream(savedata,true);
                            for(int i = 0;i < 12;i++){
                                int temp = i+1;
                                String input = "{Question:"+temp+",Answer:'"+inputArr[i]+"'}\n";
                                if(i == 11)
                                    input = input + "\n";
                                fout.write(input.getBytes());
                            }
                            fout.flush();
                            fout.close();
                            Toast.makeText(Report.this,"SAVED SUCCESSFULLY!",Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else
                        Toast.makeText(Report.this,"FAILED TO SAVE!",Toast.LENGTH_SHORT).show();
            }
        }
    };
}
