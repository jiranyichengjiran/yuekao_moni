package example.com.yuekao_moni.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.adapter.FenLeiAdapter;
import example.com.yuekao_moni.adapter.MiaoAdapter;
import example.com.yuekao_moni.adapter.TuiAdapter;
import example.com.yuekao_moni.bean.ShouBean;
import example.com.yuekao_moni.home.presenter.HomePresenter;

public class FirstFragment extends Fragment {

    private XBanner xbanner;

    private RecyclerView recycler;
    private RecyclerView miao;
    private TextView jd_miao;
    private RecyclerView recycler_tui;
    private HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first, container, false);
        xbanner = view.findViewById(R.id.xbanner);
        recycler = view.findViewById(R.id.recycler_fen);
        miao = view.findViewById(R.id.recycler_miao);
        jd_miao = view.findViewById(R.id.jd_maio);
        recycler_tui = view.findViewById(R.id.recycler_tui);
        //初始化presenter
        presenter = new HomePresenter(this);
        presenter.getPresenterData();
        //管理者
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 5);
        recycler.setLayoutManager(manager);
        //秒杀
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        miao.setLayoutManager(layoutManager);
        //推荐
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_tui.setLayoutManager(linearLayoutManager);
        return view;
    }

    public void getData(final Object obj) {
        ShouBean shouBean = (ShouBean) obj;
        //xbanner
        List<ShouBean.DataBean.BannerBean> banner = shouBean.getData().getBanner();
        final ArrayList<String> image = new ArrayList<>();
        for (int i = 0; i < banner.size(); i++) {
            image.add(banner.get(i).getIcon());
        }
        xbanner.setData(image, null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(image.get(position)).into((ImageView) view);

            }
        });
        xbanner.setPageTransformer(Transformer.Default);
        xbanner.setPageChangeDuration(1000);
        //分类
        List<ShouBean.DataBean.FenleiBean> fenlei = shouBean.getData().getFenlei();
        FenLeiAdapter fenLeiAdapter = new FenLeiAdapter(getActivity());
        fenLeiAdapter.setList(fenlei);
        recycler.setAdapter(fenLeiAdapter);
        //秒杀
        List<ShouBean.DataBean.MiaoshaBean.ListBean> miaosha = shouBean.getData().getMiaosha().getList();
        jd_miao.setText(shouBean.getData().getMiaosha().getName());
        miao.setAdapter(new MiaoAdapter(getActivity(), miaosha));
        //推荐
        List<ShouBean.DataBean.TuijianBean.ListBeanX> list = shouBean.getData().getTuijian().getList();
        recycler_tui.setAdapter(new TuiAdapter(getActivity(), list));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestory();
        }

    }
}
