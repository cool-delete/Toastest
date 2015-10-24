package lovejazzie.toastest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
    NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this);
    NotificationManager manager;
    //    myThread oen = new myThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        this.manager = manager;

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
        Button Progress = (Button) findViewById(R.id.show_notificationProgress);
        Progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic();
            }
        });
    }


    private void notification() {
        //        notification.icon = R.mipmap.ic_launcher;
        //        Notification notification = new Notification();
        //        notification.tickerText = "注意了，我被扔到狀態欄了";

        notification.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));//兼用包方法
        //        notification.setColor(getResources().getColor(android.R.color.holo_blue_bright));//方法已过时
        notification.setContentTitle("主要标题");
        notification.setSmallIcon(R.mipmap.ic_launcher);

        notification.setContentText("消息主体");
        //        Notification mNofitication = notification.build();节省内存

        manager.notify(1, notification.build());


    }

    private void logic() {
        for (int i = 0; i < 100; i++) {
            notification.setProgress(100, i, false)
                    .setDefaults(0);//dialer

            manager.notify(1, notification.build());

            //            oen.start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Toast.makeText(MainActivity.this, "进度完成", Toast.LENGTH_SHORT).show();
        notification.setContentText("ok")
                .setDefaults(Notification.DEFAULT_ALL)//dialer
                .setProgress(0, 0, false);
        manager.notify(1, notification.build());

    }

    //    class myThread extends Thread {
    //
    //        @Override
    //        public void run() {
    //            try {
    //                sleep(1);
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
    //            }
    //
    //
    //        }
    //    }
}

