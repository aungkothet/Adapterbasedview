package io.github.aungkothet.padc.padc_adapterbasedview.akt.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.github.aungkothet.padc.padc_adapterbasedview.akt.R;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.adapters.EventDetailImageAdapter;
import io.github.aungkothet.padc.padc_adapterbasedview.akt.views.items.EventDetailImageViewItem;

public class NewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ViewPager vpEventDetailImages = findViewById(R.id.vpEventDetailImages);
        EventDetailImageAdapter adapter = new EventDetailImageAdapter();
        vpEventDetailImages.setAdapter(adapter);
    }

}
