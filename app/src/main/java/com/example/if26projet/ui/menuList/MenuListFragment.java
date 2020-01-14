package com.example.if26projet.ui.menuList;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.if26projet.R;

import java.util.List;

public class MenuListFragment extends Fragment {

    private MenuListViewModel mViewModel;
    private ListView listView;
    private TextView mFragment2_tv;
    private List<String> mStrings;

    public static MenuListFragment newInstance() {
        return new MenuListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        listView = (ListView)rootView.findViewById(R.id.list);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MenuListViewModel.class);


        mFragment2_tv = (TextView) getActivity().findViewById(R.id.fragment2);//获取其它fragment中的控件引用的唯一方法!!!
        listView = (ListView) getView().findViewById(R.id.list);//获取自己视图里的控件引用,方法二

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mStrings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = mStrings.get(position);
                mFragment2_tv.setText(str);
            }
        });
    }

}
