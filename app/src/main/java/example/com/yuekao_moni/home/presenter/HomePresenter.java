package example.com.yuekao_moni.home.presenter;

import example.com.yuekao_moni.api.Api;
import example.com.yuekao_moni.fragment.FirstFragment;
import example.com.yuekao_moni.fragment.FourFragment;
import example.com.yuekao_moni.fragment.SecondFragment;
import example.com.yuekao_moni.home.model.HomeModel;
import example.com.yuekao_moni.home.model.IHomeModel;

public class HomePresenter implements IHomePresenter {
    FirstFragment firstFragment;
    private final HomeModel homeModel;

    public HomePresenter(FirstFragment firstFragment) {
        this.firstFragment = firstFragment;
        homeModel = new HomeModel();
    }

    SecondFragment secondFragment;

    public HomePresenter(SecondFragment secondFragment) {
        this.secondFragment = secondFragment;
        homeModel = new HomeModel();
    }

    FourFragment fourFragment;

    public HomePresenter(FourFragment fourFragment) {
        this.fourFragment = fourFragment;
        homeModel = new HomeModel();
    }

    @Override
    public void getPresenterData() {
        homeModel.getModelData(Api.SHOU, new IHomeModel.IModelCallBack() {
            @Override
            public void success(Object data) {
                firstFragment.getData(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void getLeftpreData() {
        //分类左
        homeModel.getLeftData(Api.LEFT, new IHomeModel.IModelCallBack() {
            @Override
            public void success(Object data) {
                secondFragment.getLeftData(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void getRightpreData(String id) {
        homeModel.getRightData(Api.RIGHT + id, new IHomeModel.IModelCallBack() {
            @Override
            public void success(Object data) {
                secondFragment.getRightData(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void getCarPreData() {
        homeModel.getCArData(Api.CARSHOP, new IHomeModel.IModelCallBack() {
            @Override
            public void success(Object data) {
                fourFragment.getCarData(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }
    //解绑，防止内存泄露
    public  void  onDestory(){
        if (firstFragment!=null){
            firstFragment=null;
        }
    }
}
