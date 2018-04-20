package me.chenjr.uiinteraction;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassAndButton CoB[] = {
                new ClassAndButton(findViewById(R.id.btn_main_uc1),LinerLayout_activity.class),
                new ClassAndButton(findViewById(R.id.btn_main_uc2),RelativeLayout_activity.class),
                new ClassAndButton(findViewById(R.id.btn_main_uc3),FrameLayoutActivity.class),
                new ClassAndButton(findViewById(R.id.btn_main_uc2),RelativeLayout_activity.class),
                new ClassAndButton(findViewById(R.id.btn_main_uc2),RelativeLayout_activity.class),
        };

        final Context context = this;

        for (final ClassAndButton cob : CoB){
            cob.getBtn().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(context,cob.getCls()));
                }
            });
        }



    }
}

