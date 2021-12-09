package com.baidu.paddle.lite.demo.yolo_detection;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.paddle.lite.demo.yolo_detection.R;
import org.w3c.dom.Text;


public class PoseButton extends ConstraintLayout {
    private String TAG = this.getClass().getSimpleName();
    private Context context;

    private ImageView pbImageView;
    private TextView pbNameView;
    private RelativeLayout pbRelativeLayout;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public PoseButton(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public PoseButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public PoseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.pose_button, this, true);
        pbRelativeLayout = findViewById(R.id.pb_layout);
        //pbImageView = findViewById(R.id.pb_image);
        pbNameView = findViewById(R.id.pb_name);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.pose_button);
        int pbImageId = typedArray.getResourceId(R.styleable.pose_button_pose_image, 0);
        setPoseImage(pbImageId);
        String pbNameId = typedArray.getString(R.styleable.pose_button_pose_name);
        setPoseName(pbNameId);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setPoseImage(int pbImageId) {
        RoundedBitmapDrawable newPbImageViewDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(),pbImageId));
        newPbImageViewDrawable.setCornerRadius(16);

        pbRelativeLayout.setBackground(newPbImageViewDrawable);
        pbRelativeLayout.setBackgroundResource(pbImageId);

    }
    public void setPoseName(String pbName) {
        pbNameView.setText(pbName);
    }
}
