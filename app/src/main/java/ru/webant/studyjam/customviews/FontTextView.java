package ru.webant.studyjam.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import ru.webant.studyjam.R;

public class FontTextView extends AppCompatTextView {
    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttributes(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttributes(attrs);

    }

    public void readAttributes(AttributeSet set) {
        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.FontTextView);
        String font = ta.getString(R.styleable.FontTextView_font);
        setCustomFont(font);
        ta.recycle();
    }


    public void setCustomFont(String font) {
        Typeface typeface;
        try {
            typeface = Typeface.createFromAsset(getContext().getAssets(), font);
            setTypeface(typeface);
        } catch (Exception e) {

            Log.e("FontTextView","Failed to set font!");
        }
    }
}
