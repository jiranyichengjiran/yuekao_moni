package example.com.yuekao_moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.bean.ShopCar;

public class CarShopAdapter extends RecyclerView.Adapter<CarShopAdapter.ViewHolder> {
    Context context;
    private List<ShopCar.DataBean.ListBean> list=new ArrayList<>();

    public CarShopAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<ShopCar.DataBean.ListBean> list)
    {
        this.list=list;
    }
    @NonNull
    @Override
    public CarShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarShopAdapter.ViewHolder holder, int i) {

        holder.name.setText(list.get(i).getTitle());
        holder.price.setText(list.get(i).getPrice() + ".00");
        Glide.with(context)
                .load(list.get(i)
                        .getImages().split("\\|")[0].replace("https", "http"))
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox shop_check;
        private final ImageView img;
        private final TextView name;
        private final TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_check = itemView.findViewById(R.id.shop_check);
            img = itemView.findViewById(R.id.shop_img);
            name = itemView.findViewById(R.id.shop_name);
            price = itemView.findViewById(R.id.shop_price);
        }
    }
}
