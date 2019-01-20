package example.com.yuekao_moni.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import example.com.yuekao_moni.R;

public class FiveFragment extends Fragment {
    private List<String> list=new ArrayList<>();
    private FlowLayout flow;
    private Button sou;
    private EditText edit_text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.five, container, false);
        sou = view.findViewById(R.id.sou);
        edit_text = view.findViewById(R.id.edit_text);
        flow = view.findViewById(R.id.flow);
        list.add("小米3是一代机王");
        list.add("华为");
        list.add("华为5g");
        list.add("华为");
        list.add("百度ai");
        list.add("小米ai是产业链的一个布局产品");
        list.add("虚拟于现实");
        list.add("小米");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,5,10,5);
        if(flow!=null)
        {
            flow.removeAllViews();
        }
        for(int i=0;i<list.size();i++)
        {
            TextView tv = new TextView(getActivity());
            tv.setPadding(28,10,28,10);
            tv.setText(list.get(i));
            tv.setSingleLine();
            tv.setMaxEms(10);
            tv.setLayoutParams(params);
            flow.addView(tv,params);
        }

        return view;
    }
}
