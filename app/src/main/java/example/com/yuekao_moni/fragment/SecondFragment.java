package example.com.yuekao_moni.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.adapter.LeftAdapter;
import example.com.yuekao_moni.adapter.RightAdapter;
import example.com.yuekao_moni.bean.LeftBean;
import example.com.yuekao_moni.bean.RightBean;
import example.com.yuekao_moni.home.presenter.HomePresenter;

public class SecondFragment extends Fragment {


    private RecyclerView right;
    private RecyclerView left;
    private HomePresenter presenter;
    private int cid;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second, container, false);
        left = view.findViewById(R.id.left_recycler);
        right = view.findViewById(R.id.right_recycler);
        //初始化presenter
        presenter = new HomePresenter(this);
        presenter.getLeftpreData();
        //管理者
        LinearLayoutManager left_manger = new LinearLayoutManager(getActivity());
        left.setLayoutManager(left_manger);
        LinearLayoutManager right_manger = new GridLayoutManager(getActivity(), 3);
        right.setLayoutManager(right_manger);
        return view;
    }

    public void getLeftData(Object object) {
        LeftBean leftBean = (LeftBean) object;
        List<LeftBean.DataBean> list = leftBean.getData();
        LeftAdapter leftAdapter = new LeftAdapter(getActivity(), list);
        left.setAdapter(leftAdapter);
        leftAdapter.setLeftCallBack(new LeftAdapter.LeftCallBack() {

            @Override
            public void onClick(int position, List<LeftBean.DataBean> list) {
                cid = list.get(position).getCid();
                presenter.getRightpreData(cid + "");
            }
        });
    }

    public void getRightData(Object object) {
        RightBean rightBean = (RightBean) object;
        List<RightBean.DataBean> list = rightBean.getData();
        RightAdapter rightAdapter = new RightAdapter(getActivity(), list);
        right.setAdapter(rightAdapter);
    }

}
