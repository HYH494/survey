package mg.studio.android.survey;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
@SuppressWarnings("ResourceType")

public class Auto_Question extends AppCompatActivity {
    String path;
    RelativeLayout auto_layout = new RelativeLayout(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Automatically create the RelativeLayout to show the questions and options
        auto_layout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        auto_layout.setId(0);
        path = this.getExternalFilesDir(null).getAbsolutePath();
        try {
            auto_layout = auto_create(auto_layout, path);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setContentView(auto_layout);
    }

    //This can be used to automatically create Layout as well as get the problems from the file "sample.json" under assets
    public RelativeLayout auto_create(final RelativeLayout auto_layout, final String path) throws JSONException {
        String get_message = "";
        StringBuilder sb = new StringBuilder();
        AssetManager assets = this.getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(assets.open("sample.json")));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        get_message = sb.toString();

        JSONObject jb_message = new JSONObject(get_message);
        JSONObject survey = jb_message.getJSONObject("survey");
        String id = survey.getString("id");
        String len = survey.getString("len");
        JSONArray questions = survey.getJSONArray("questions");

        //automatically create
        final int que_num = Integer.parseInt(len);
        TextView[] que_contents = new TextView[que_num];
        final RadioGroup que_options[] = new RadioGroup[que_num];
        RelativeLayout.LayoutParams[] que_tParams = new RelativeLayout.LayoutParams[que_num];
        RelativeLayout.LayoutParams[] que_oParams = new RelativeLayout.LayoutParams[que_num];

        //cycle for len times to create layout and buttons
        for (int i = 0; i < que_num; i++) {
            //To get the info of the questions such as the type, question and options
            JSONObject que = questions.getJSONObject(i);
            String que_question = que.getString("question");
            String type = survey.getString("type");
            JSONArray que_option = que.getJSONArray("options");
            String[] que_choose = new String[que_option.length()];

            for (int j = 0; j < que_option.length(); j++)
                que_choose[j] = que_option.getJSONObject(j).getString("" + j + 1);

            //automatically create TextView and setText
            que_contents[i] = new TextView(this);
            int temp = i + 6;
            que_contents[i].setId(temp);
            que_tParams[i] = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            //i = 0, create directly, i > 0, set marginTop = 10
            if (i == 0)
                que_tParams[i].setMargins(dpreset(8), 0, 0, 0);
            else {
                int tempnum = i - 1;
                que_tParams[i].addRule(RelativeLayout.BELOW, que_options[tempnum].getId());
                que_tParams[i].setMargins(dpreset(8), dpreset(10), 0, 0);
            }
            que_contents[i].setLayoutParams(que_tParams[i]);
            que_contents[i].setText(que_question);
            que_contents[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

            //automatically create RadioGroup
            que_options[i] = new RadioGroup(this);
            que_oParams[i] = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            que_oParams[i].addRule(RelativeLayout.BELOW, que_contents[i].getId());
            que_options[i].setLayoutParams(que_oParams[i]);
            int tempnum = i + 60;
            que_options[i].setId(tempnum);
            int opt_num = que_option.length();
            RadioButton[] opt_choose = new RadioButton[opt_num];
            for (int k = 0; k < opt_num; k++) {
                opt_choose[k] = new RadioButton(this);
                int tempnum1 = k + 1;
                opt_choose[k].setId(que_contents[i].getId() + tempnum1);
                opt_choose[k].setText(que_choose[k]);
                que_options[i].addView(opt_choose[k]);
            }

            auto_layout.addView(que_contents[i]);
            auto_layout.addView(que_options[i]);
        }

        //create button and function
        Button Finish = new Button(this);
        Finish.setId(666);
        RelativeLayout.LayoutParams btn_Params;
        btn_Params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        btn_Params.setMargins(0, dpreset(540), 0, 0);
        btn_Params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        Finish.setLayoutParams(btn_Params);
        Finish.setText("FINISH");
        Finish.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int[] que_done = new int[que_num];
                for (int i = 0; i < que_num; i++)
                    que_done[i] = que_options[i].getCheckedRadioButtonId();

                int tempnum2 = 0;
                for (int i = 0; i < que_num; i++) {
                    if (que_done[i] == -1)
                        tempnum2 = 1;
                }

                if (tempnum2 == 1) {
                    Toast ts = Toast.makeText(getBaseContext(), "Please select the answers!", Toast.LENGTH_LONG);
                    ts.show();
                }
                else {
                    RadioButton[] que_answer = new RadioButton[que_num];
                    for (int i = 0; i < que_num; i++)
                        que_answer[i] = (RadioButton) findViewById(que_done[i]);
                    String[] result = new String[que_num];
                    for (int i = 0; i < que_num; i++)
                        result[i] = que_answer[i].getText().toString();

                    File savedata = new File(path, "result.json");
                    FileOutputStream fout = null;
                    try {
                        fout = new FileOutputStream(savedata, true);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        String Json = "{";
                        for (int i = 1; i < result.length + 1; i++) {
                            if (i < result.length)
                                Json = Json + "\"question" + i + "\":" + "\"" + result[i - 1] + "\"" + ",";
                            if (i == result.length)
                                Json = Json + "\"question" + i + "\":" + "\"" + result[i - 1] + "\"" + "}\n";
                        }
                        fout.write(Json.getBytes());
                        fout.flush();
                        fout.close();
                        Toast.makeText(getBaseContext(), "Save successfully!", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        auto_layout.addView(Finish);
        return auto_layout;
    }

    public int dpreset(float dpValue) {
            return (int) (dpValue * this.getResources().getDisplayMetrics().density + 0.5f);
    }
}