package com.example.resume.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.example.resume.R;

public class ExpandingTextView extends AppCompatTextView implements View.OnClickListener {

    private boolean expanded;
    private int collapsedMaxLines;
    private OnClickListener delegateClickListener;

    public ExpandingTextView(Context context) {
        this(context, null);
    }

    public ExpandingTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandingTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a =
            context.obtainStyledAttributes(attrs, R.styleable.ExpandingTextView, 0, defStyleAttr);
        collapsedMaxLines = a.getInt(R.styleable.ExpandingTextView_collapsedMaxLines, 2);
        a.recycle();

        if(expanded) {
            expand();
        }
        else {
            collapse();
        }

        super.setOnClickListener(this);
    }

    public void expand() {
        setMaxLines(Integer.MAX_VALUE);
        expanded = true;
    }

    public void collapse() {
        setMaxLines(collapsedMaxLines);
        expanded = false;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        delegateClickListener = l;
    }

    @Override
    public void onClick(View v) {
        if(expanded) {
            collapse();
        } else {
            expand();
        }

        if (delegateClickListener != null) {
            delegateClickListener.onClick(v);
        }
    }
}
