package tw.org.iii.lab24;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ball;
    private ObjectAnimator animator1, animator2, animator3, animator4, animator5;
    private View container;
    private int h, w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball = (ImageView)findViewById(R.id.img);
        container = findViewById(R.id.view);
    }
    private void animatorSet() {
        animator1 = ObjectAnimator.ofFloat(ball, "x", 0, w);
        animator2 = ObjectAnimator.ofFloat(ball, "y", 0, h);
        animator3 = ObjectAnimator.ofFloat(ball,"alpha", 0f,1f);
        animator4 = ObjectAnimator.ofFloat(ball,"rotationX", 0f,360f,0f,360f);
        animator5 = ObjectAnimator.ofFloat(ball,"rotationY", 0f,360f,0f,360f);
    }
    public void test1(View v) {
        animator1.setDuration(2*1000);
        animator1.setRepeatCount(0);
        animator1.start();
    }
    public void test2(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(animator1,animator2);
        set.setDuration(3*1000);
        set.start();
    }
    public void test3(View v) {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1,animator2);
        set.setDuration(3*1000);
        set.start();
    }
    public void test4(View v) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("brad", "onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v("brad", "onResume()");
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.v("brad", "onWindowFocusChanged()");
        Log.v("brad", container.getWidth() + "x" + container.getHeight());
        h = container.getHeight() - ball.getHeight();
        w = container.getWidth() - ball.getWidth();
        animatorSet();
    }
}