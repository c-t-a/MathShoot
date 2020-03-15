package com.example.mathshoot;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeLayoutandImageViews {
    private RelativeLayout relativeLayout;
    private TextView textView;

    public RelativeLayoutandImageViews(RelativeLayout relativeLayout, TextView textView) {
        this.relativeLayout = relativeLayout;
        this.textView = textView;
    }

    public RelativeLayout getRelativeLayout() {
        return relativeLayout;
    }

    public TextView getTextView() {
        return textView;
    }
}
