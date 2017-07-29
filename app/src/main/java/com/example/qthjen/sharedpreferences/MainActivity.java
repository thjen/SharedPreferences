package com.example.qthjen.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;
    private CheckBox cb;
    private Button btConfirm;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        sharedPreferences = getSharedPreferences("mydata", MODE_PRIVATE); // key là mydata
        /** lấy giá trị shared Priferences **/
        etUser.setText(sharedPreferences.getString("myuser", ""));  // "" và false là giá trị dự bị khi sai ko tích vào check bõ
        etPass.setText(sharedPreferences.getString("mypass", ""));
        cb.setChecked(sharedPreferences.getBoolean("mycheckbox", false));


        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( (etUser.getText().toString()).equals("thjenxxxno6") && (etPass.getText().toString()).equals("thjenit98")) {
                    Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                    // nếu có check
                    if ( cb.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("myuser", etUser.getText().toString());
                        editor.putString("mypass", etPass.getText().toString());
                        editor.putBoolean("mycheckbox", true); // để khi run lại check box đã được tích bằng setBoolean
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("myuser");
                        editor.remove("mypass");
                        editor.remove("mycheckbox");
                        editor.commit();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findView() {

        etUser    = (EditText) findViewById(R.id.etUser);
        etPass    = (EditText) findViewById(R.id.etPass);
        cb        = (CheckBox) findViewById(R.id.cb);
        btConfirm = (Button)   findViewById(R.id.btConfirm);

    }

}
