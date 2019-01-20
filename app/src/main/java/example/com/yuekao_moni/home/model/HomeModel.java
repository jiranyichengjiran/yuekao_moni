package example.com.yuekao_moni.home.model;

import example.com.yuekao_moni.bean.LeftBean;
import example.com.yuekao_moni.bean.RightBean;
import example.com.yuekao_moni.bean.ShopCar;
import example.com.yuekao_moni.bean.ShouBean;
import example.com.yuekao_moni.netwok.OkHttp;

public class HomeModel implements IHomeModel {
    @Override
    public void getModelData(String url, final IHomeModel.IModelCallBack callBack) {

        OkHttp.getInstance().doGet(url, ShouBean.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBack.success(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }

    //分类左
    @Override
    public void getLeftData(String url, final IModelCallBack callBack) {
        OkHttp.getInstance().doGet(url, LeftBean.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBack.success(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }
    //分类右
    @Override
    public void getRightData(String url, final IModelCallBack callBack) {
        OkHttp.getInstance().doGet(url, RightBean.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBack.success(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }

    @Override
    public void getCArData(String url, final IModelCallBack callBack) {
        OkHttp.getInstance().doGet(url, ShopCar.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBack.success(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }
}
