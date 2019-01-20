package example.com.yuekao_moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.bean.ShouBean;

public class FenLeiAdapter extends RecyclerView.Adapter<FenLeiAdapter.ViewHolder> {
    Context context;
    List<ShouBean.DataBean.FenleiBean> list=new ArrayList<>();

    public FenLeiAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<ShouBean.DataBean.FenleiBean> list){
        this.list=list;
    }
    @NonNull
    @Override
    public FenLeiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.fen_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FenLeiAdapter.ViewHolder holder, int i) {
        holder.name.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getIcon())
                .into(holder.img);
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
            img = itemView.findViewById(R.id.fen_img);
            name = itemView.findViewById(R.id.fen_name);

        }
    }
}
