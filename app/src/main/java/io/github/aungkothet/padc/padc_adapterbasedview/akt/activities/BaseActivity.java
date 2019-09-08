package io.github.aungkothet.padc.padc_adapterbasedview.akt.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.R;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models.EventModel;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.data.models.EventModelImpl;

public abstract class BaseActivity extends AppCompatActivity {

    protected EventModel mEventModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventModel = EventModelImpl.getObjInstance();
    }

    protected void showSnack(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(),message,Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getResources().getString(R.string.lbl_ok), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();

    }
}
