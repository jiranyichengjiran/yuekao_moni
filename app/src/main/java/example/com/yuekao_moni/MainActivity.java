package example.com.yuekao_moni;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hjm.bottomtabbar.BottomTabBar;

import example.com.yuekao_moni.fragment.FirstFragment;
import example.com.yuekao_moni.fragment.FiveFragment;
import example.com.yuekao_moni.fragment.FourFragment;
import example.com.yuekao_moni.fragment.SecondFragment;
import example.com.yuekao_moni.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom = findViewById(R.id.bottom_bar);
        bottom.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setTabPadding(4,6,10)
                .setFontSize(10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.shou_ye,FirstFragment.class)
                .addTabItem("分类",R.drawable.fen,SecondFragment.class)
                .addTabItem("MI觅",R.drawable.mi,ThirdFragment.class)
                .addTabItem("购物车",R.drawable.shop_car,FourFragment.class)
                .addTabItem("我的",R.drawable.my,FiveFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
