package org.example.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ResourceInput extends LinearLayout {
    private static final String TAG = "ResourceInput";
    private int icon;
    private String hint;
    private ImageView linkIcon;
    private EditText linkEdit;

    /**
     * ResourceInput constructor
     *
     * @param context
     * @param attrs
     */
    public ResourceInput(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // Inflate view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_resource_input, this);
        // Get views
        linkIcon = findViewById(R.id.resource_input_icon);
        linkEdit = findViewById(R.id.resource_input_edit);
        // Get view properties from layout
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.ResourceInput, 0, 0);
        try {
            icon = typedArray.getResourceId(R.styleable.ResourceInput_linkIcon, R.drawable.ic_link_black_24dp);
            hint = typedArray.getString(R.styleable.ResourceInput_linkText);
            linkIcon.setImageResource(icon);
            linkEdit.setHint(hint);
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
    public void setLinkIcon(int resource) {
        linkIcon.setImageResource(resource);
    }

    /**
     * Icon getter
     *
     * @return current icon value
     */
    public int getLinkIcon() {
        return icon;
    }

    /**
     * Placeholder setter
     *
     * @param hint hint text
     */
    public void setLinkPlaceholder(String hint) {
        linkEdit.setHint(this.hint);
    }

    /**
     * Placeholder getter
     *
     * @return value of edit hint
     */
    public String getLinkPlaceholder() {
        return hint;
    }

}
