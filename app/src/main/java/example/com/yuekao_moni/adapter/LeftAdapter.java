package example.com.yuekao_moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.com.yuekao_moni.R;
import example.com.yuekao_moni.bean.LeftBean;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    Context context;
    List<LeftBean.DataBean> list;

    public LeftAdapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.left, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.ViewHolder holder, final int i) {
        holder.text.setText(list.get(i).getName());
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftCallBack.onClick(i,list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.left_text);
        }
    }
    private LeftCallBack leftCallBack;
    public void setLeftCallBack(LeftCallBack leftCallBack){
        this.leftCallBack=leftCallBack;
    }
    //定义接口回调
    public interface LeftCallBack{
        void onClick(int position, List<LeftBean.DataBean> list);
    }
}
