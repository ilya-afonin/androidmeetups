package org.example.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResourceLink extends LinearLayout {
    private static final String TAG = "ResourceLink";
    private int icon;
    private String label;
    private ImageView linkIcon;
    private TextView linkLabel;

    /**
     * ResourceLink constructor
     *
     * @param context
     * @param attrs
     */
    public ResourceLink(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // Inflate view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_resource_link, this);
        // Get views
        linkIcon = findViewById(R.id.resource_link_icon);
        linkLabel = findViewById(R.id.resource_link_text);
        // Get view properties from layout
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.ResourceLink, 0, 0);
        try {
            icon = typedArray.getResourceId(R.styleable.ResourceLink_linkIcon, R.drawable.ic_link_black_24dp);
            label = typedArray.getString(R.styleable.ResourceLink_linkText);
            linkIcon.setImageResource(icon);
            linkLabel.setText(label);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * Icon setter
     *
     * @param resource icon resource id
     */
    public void setIcon(int resource) {
        linkIcon.setImageResource(resource);
    }

    /**
     * Label setter
     *
     * @param label label text
     */
    public void setLinkLabel(String label) {
        linkLabel.setText(label);
    }

    /**
     * Label getter
     *
     * @return value of link label
     */
    public String getLinkLabel() {
        return label;
    }

    /**
     * Icon getter
     *
     * @return current icon value
     */
    public int getIcon() {
        return icon;
    }
}
