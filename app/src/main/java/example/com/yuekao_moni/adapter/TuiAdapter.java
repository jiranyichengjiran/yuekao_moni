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
import example.com.yuekao_moni.bean.ShouBean;

public class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.ViewHolder> {
    Context context;
    List<ShouBean.DataBean.TuijianBean.ListBeanX> list;

    public TuiAdapter(Context context, List<ShouBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TuiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.tui, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TuiAdapter.ViewHolder holder, int i) {
        Glide.with(context).load(list.get(i).getImages().split("\\|")[0]).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.tui_img);
        }
    }
}
