package example.com.yuekao_moni.home.model;

public interface IHomeModel {

    void getModelData(String url, IModelCallBack callBack);

    void getLeftData(String url, IModelCallBack callBack);

    void getRightData(String url, IModelCallBack callBack);

    void getCArData(String url, IModelCallBack callBack);

    interface IModelCallBack {
        void success(Object data);

        void onFailed();
    }
}
