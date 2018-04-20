package me.chenjr.uiinteraction;

import android.view.View;
import android.widget.Button;

/**
 * Created by chenjr on 18-4-20.
 */

public class ClassAndButton {

    private Button btn;
    private Class cls;

    public ClassAndButton(View viewById, Class<?> cls) {
        this.btn = (Button) viewById;
        this.cls = cls;
    }

    public Button getBtn() {
        return btn;
    }

    public Class getCls() {
        return cls;
    }


}
