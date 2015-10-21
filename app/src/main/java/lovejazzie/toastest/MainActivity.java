package lovejazzie.toastest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mToastshort;
    Button mToastlong;
    Button mToastcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToastshort = (Button) findViewById(R.id.show_toastshort);
        mToastshort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "显示一个短", Toast.LENGTH_SHORT).show();
            }
        });
        mToastlong = (Button) findViewById(R.id.show_toastlong);
        mToastlong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "长toast", Toast.LENGTH_LONG).show();
            }
        });
        mToastcenter= (Button) findViewById(R.id.show_toastcenter);
        mToastcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mtoastcenter=Toast.makeText(MainActivity.this,"centerToast",Toast.LENGTH_LONG);
                mtoastcenter.setGravity(Gravity.CENTER,0,0);
                mtoastcenter.show();
            }
        });
    }


}
