package org.example.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResourceLink extends LinearLayout {
    private static final String TAG = "ResourceLink";
    private int attrIcon = 0;
    private String attrText = "";
    private ImageView linkIcon;
    private TextView linkText;

    public ResourceLink(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_resource_link, this);
        linkIcon = findViewById(R.id.linkIcon);
        linkText = findViewById(R.id.linkText);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.ResourceLink, 0, 0);
        try {
            attrIcon = typedArray.getResourceId(R.styleable.ResourceLink_linkIcon, 0);
            attrText = typedArray.getString(R.styleable.ResourceLink_linkText);
            linkIcon.setImageResource(attrIcon);
            linkText.setText(attrText);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        } finally {
            typedArray.recycle();
        }

    }
}
