package project.coursera.android.modernartui;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 *RectAngle.java: This class is used to
 */
public class RectAngle extends View {

    final String className= "RectAngle";
    public RectAngle(Context context) {
        super(context);
    }
    public RectAngle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectAngle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     *This method is responsible fror drawing the five rectanges on the main activity.
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(className, "In onDraw method");
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setColor(Color.parseColor("#00000000"));
        canvas.drawRect(0,0,400,400,paint);
    }
}