package com.ddmeng.picassosample;


import android.os.Bundle;
import android.widget.GridView;

/**
 * This sample is coming from:
 * https://github.com/square/picasso/tree/master/picasso-sample
 */
public class SampleGridViewActivity extends PicassoSampleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_gridview_activity);

        GridView gv = (GridView) findViewById(R.id.grid_view);
        gv.setAdapter(new SampleGridViewAdapter(this));
        gv.setOnScrollListener(new SampleScrollListener(this));
    }
}
