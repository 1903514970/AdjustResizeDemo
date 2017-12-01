package pentagon.com.adjustresizedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    MyScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (MyScrollView) findViewById(R.id.scrollView);
        findViewById(R.id.rootView).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //直接用 fullScroll方法，焦点跳转到最后一个EditText
                scrollView.myFullScroll(ScrollView.FOCUS_DOWN);

            }
        });

    }



}
