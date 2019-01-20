package example.com.yuekao_moni.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.adapter.CarAdapter;
import example.com.yuekao_moni.bean.ShopCar;
import example.com.yuekao_moni.home.presenter.HomePresenter;

public class FourFragment extends Fragment {


    private RecyclerView car_shop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four, container, false);
        car_shop = view.findViewById(R.id.car_shop);
        //初始化presenter
        HomePresenter presenter = new HomePresenter(this);
        presenter.getCarPreData();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        car_shop.setLayoutManager(manager);
        return view;
    }

    public void getCarData(Object object) {
        ShopCar shopCar=(ShopCar)object;
        List<ShopCar.DataBean> list = shopCar.getData();
        list.remove(0);
        CarAdapter carAdapter = new CarAdapter(getActivity(), list);
        car_shop.setAdapter(carAdapter);
    }
}
