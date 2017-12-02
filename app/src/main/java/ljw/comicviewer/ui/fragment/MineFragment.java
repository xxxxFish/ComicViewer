package ljw.comicviewer.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ljw.comicviewer.R;
import ljw.comicviewer.ui.HomeActivity;
import ljw.comicviewer.ui.SettingsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {
    private static String TAG = MineFragment.class.getSimpleName()+"----";
    private Context context;
    @BindView(R.id.layout_my_setting)
    RelativeLayout btn_setting;
    @BindView(R.id.title)
    TextView nav_title;
    @BindView(R.id.nav_btn_search)
    ImageView nav_btn_search;

    public MineFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        context = getActivity();
        ButterKnife.bind(this,view);
        initView();
        initListener();
        return view;
    }

    @Override
    public void initView() {
        //隐藏搜索按钮
        nav_btn_search.setVisibility(View.GONE);
        if(getActivity() instanceof HomeActivity)
            ((HomeActivity) getActivity()).setTitle(nav_title,R.string.txt_mine);
    }

    @Override
    public void initLoad() {

    }

    private void initListener(){
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SettingsActivity.class);
                startActivity(intent);
            }
        });
        btn_setting.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

    }

}
