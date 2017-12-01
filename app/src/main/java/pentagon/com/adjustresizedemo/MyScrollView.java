package pentagon.com.adjustresizedemo;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by dengjun on 2017/12/1.
 * TODO
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Rect mTempRect = new Rect();
    //仿照 fullScroll方法，去除掉改变焦点的代码
    public void myFullScroll(int direction){
        boolean down = direction == View.FOCUS_DOWN;
        int height = getHeight();

        mTempRect.top = 0;
        mTempRect.bottom = height;

        if (down) {
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(count - 1);
                mTempRect.bottom = view.getBottom() + getPaddingBottom();
                mTempRect.top = mTempRect.bottom - height;
            }
        }

        height = getHeight();
        int containerTop = getScrollY();
        int containerBottom = containerTop + height;
        boolean up = direction == View.FOCUS_UP;

        if ( mTempRect.top >= containerTop && mTempRect.bottom <= containerBottom) {
        }else{
            int delta = up ? (mTempRect.top - containerTop) : (mTempRect.bottom - containerBottom);
            Log.i("wokao","delta="+delta);
            smoothScrollBy(0, delta);
        }
    }

}
