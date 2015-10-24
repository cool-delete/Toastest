package lovejazzie.toastest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mToastShort;
    Button mToastLong;
    Button mToastCenter;
    Button mToastPic;
    Button btnNofitication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToastShort = (Button) findViewById(R.id.show_ToastShort);
        mToastShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "显示一个短", Toast.LENGTH_SHORT).show();
            }
        });
        mToastLong = (Button) findViewById(R.id.show_ToastLong);
        mToastLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "长toast", Toast.LENGTH_LONG).show();
            }
        });
        mToastCenter = (Button) findViewById(R.id.show_ToastCenter);
        mToastCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToastCenter1 = Toast.makeText(MainActivity.this, "centerToast", Toast.LENGTH_LONG);
                mToastCenter1.setGravity(Gravity.CENTER, 0, 0);
                mToastCenter1.show();
            }
        });

        mToastPic = (Button) findViewById(R.id.showPicToast);
        mToastPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView pic = new ImageView(MainActivity.this);
                pic.setImageResource(R.mipmap.ic_launcher);
                Toast picToast = Toast.makeText(MainActivity.this, "abc", Toast.LENGTH_LONG);
                picToast.setView(pic);
                picToast.show();
            }
        });
        btnNofitication = (Button) findViewById(R.id.btnNotification);
        btnNofitication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.notification();
            }
        });
    }


    private void notification() {
        //        notification.icon = R.mipmap.ic_launcher;
        //        Notification notification = new Notification();
        //        notification.tickerText = "注意了，我被扔到狀態欄了";
        NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this);
        notification.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        notification.setContentTitle("主要标题");
        notification.setSmallIcon(R.mipmap.ic_launcher);

        notification.setContentText("消息主体");
        Notification mNofitication = notification.build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, mNofitication);


    }
}
