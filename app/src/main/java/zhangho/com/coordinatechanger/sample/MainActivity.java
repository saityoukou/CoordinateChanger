package zhangho.com.coordinatechanger.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import zhangho.com.coordinatechanger.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_main_demo1)
    void clickDemo1(){
        Intent intent = new Intent(this,DemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_main_demo2)
    void clickDemo2(){
        Intent intent = new Intent(this,DemoActivity2.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_main_demo3)
    void clickDemo3(){
        Intent intent = new Intent(this,DemoActivity3.class);
        startActivity(intent);
    }
}
