package com.ddmeng.picassosample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

public class PicassoSampleActivity extends AppCompatActivity {
    private ToggleButton showHide;
    private FrameLayout sampleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.picasso_sample_activity);
        sampleContent = (FrameLayout) findViewById(R.id.sample_content);

        final ListView activityList = (ListView) findViewById(R.id.activity_list);
        final PicassoSampleAdapter adapter = new PicassoSampleAdapter(this);
        activityList.setAdapter(adapter);
        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                adapter.getItem(position).launch(PicassoSampleActivity.this);
            }
        });

        showHide = (ToggleButton) findViewById(R.id.faux_action_bar_control);
        showHide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                activityList.setVisibility(checked ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Picasso.with(this).cancelTag(this);
    }

    @Override
    public void onBackPressed() {
        if (showHide.isChecked()) {
            showHide.setChecked(false);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        getLayoutInflater().inflate(layoutResID, sampleContent);
    }

    @Override
    public void setContentView(View view) {
        sampleContent.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        sampleContent.addView(view, params);
    }
}
