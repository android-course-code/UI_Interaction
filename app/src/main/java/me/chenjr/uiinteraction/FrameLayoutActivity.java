package me.chenjr.uiinteraction;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends AppCompatActivity {
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        final  ImageView views[] = {
                findViewById(R.id.img_1),
                findViewById(R.id.img_2),
                findViewById(R.id.img_3),
                findViewById(R.id.img_4),
                findViewById(R.id.img_5)
        };

        final  int imgs[] ={
                R.drawable.calpe_1,
                R.drawable.calpe_2,
                R.drawable.calpe_3,
                R.drawable.calpe_4,
                R.drawable.calpe_5,
        };

        @SuppressLint("HandlerLeak")
        final Handler handler =new Handler(){
            @Override
            public void handleMessage(Message msg){
                if (msg.what != 0xffa)
                    return;
                ImageView im;
                for (int i =0;i<imgs.length;i++){
                    views[(counter+i)%5].setImageResource(imgs[i]);
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
        },100,2500);



    }
}
