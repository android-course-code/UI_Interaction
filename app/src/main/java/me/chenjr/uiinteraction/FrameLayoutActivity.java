package me.chenjr.uiinteraction;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends AppCompatActivity {
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        final LinearLayout views[] = {
                findViewById(R.id.img_1),
                findViewById(R.id.img_2),
                findViewById(R.id.img_3),
                findViewById(R.id.img_4),
                findViewById(R.id.img_5)
        };

        final TextView tvs[] = {
                findViewById(R.id.img_1_tv),
                findViewById(R.id.img_2_tv),
                findViewById(R.id.img_3_tv),
                findViewById(R.id.img_4_tv),
                findViewById(R.id.img_5_tv),
        };
        final int colors[] = {
                //R.color.color1,
                0xffccb333,
                0xff3399cc,
                0xffcc334d,
                0xffb233cc,
                0xff33ccb2
//                R.color.color2,
//                R.color.color3,
//                R.color.color4,
//                R.color.color5
        };

        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what != 0xffa)
                    return;
                TextView tv;

                for (int i =0;  i <views.length; i++) {
                    views[i].setBackgroundColor(colors[(counter + i) % 5]);

                    Log.d("color~", "" + colors[(counter + i) % 5]);
                    tv = tvs[i];
                    Log.d("TV!!!", "i:" + i + " " + tv);
                    tv.setText("" + ((counter + i) % 5 + 1));
                }
                counter++;

            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0xffa);
            }
        }, 100, 2500);
        Button bt_return = findViewById(R.id.btn_fl_return);
        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
