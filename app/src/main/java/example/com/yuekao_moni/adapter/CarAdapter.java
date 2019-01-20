package example.com.yuekao_moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.bean.ShopCar;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    Context context;
    List<ShopCar.DataBean> list;

    public CarAdapter(Context context, List<ShopCar.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.car, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int i) {
        holder.car_name.setText(list.get(i).getSellerName());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        holder.shop.setLayoutManager(manager);
        List<ShopCar.DataBean.ListBean> beans = this.list.get(i).getList();
        CarShopAdapter carShopAdapter = new CarShopAdapter(context );
        carShopAdapter.setList(beans);
        holder.shop.setAdapter(carShopAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final CheckBox check_car;
        private final TextView car_name;
        private final RecyclerView shop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            check_car = itemView.findViewById(R.id.check_car);
            car_name = itemView.findViewById(R.id.car_name);
            shop = itemView.findViewById(R.id.shop_item);
        }
    }
}
