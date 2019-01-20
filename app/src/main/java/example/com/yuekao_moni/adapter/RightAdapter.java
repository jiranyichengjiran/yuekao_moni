package example.com.yuekao_moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.bean.LeftBean;
import example.com.yuekao_moni.bean.RightBean;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    Context context;
    List<RightBean.DataBean> list;

    public RightAdapter(Context context, List<RightBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.right, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.ViewHolder holder, int i) {
        for (int j = 0; j < list.get(i).getList().size(); j++) {
            holder.name.setText(list.get(i).getName());
            Glide.with(context).load(list.get(i).getList().get(j).getIcon()).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView img;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.right_img);
            name = itemView.findViewById(R.id.right_name);
        }
    }

}
