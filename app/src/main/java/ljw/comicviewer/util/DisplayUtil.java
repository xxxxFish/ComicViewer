package ljw.comicviewer.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 界面工具类
 */

public class DisplayUtil {
    private static String TAG = "DisplayUtil----";

    public static float pxToDp(Context context,float px){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return px/dm.density;
    }

    public static float dpToPx(Context context,float dp){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dp*dm.density;
    }

    public static float getScreenWidthPX(Context context){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        //屏幕宽度算法:"屏幕宽度（像素）/屏幕密度"
        return  dm.widthPixels;//屏幕宽度(dp)
    }

    public static float getScreenWidthDP(Context context){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        //屏幕宽度算法:"屏幕宽度（像素）/屏幕密度"
        return  dm.widthPixels/dm.density;//屏幕宽度(dp)
    }

    //根据屏幕大小获取网格列数
    public static int getGridNumColumns(Context context,int itemWidth){
        float screenWidth = getScreenWidthDP(context);
        int columns = Math.round(screenWidth/itemWidth);
        Log.d(TAG, context.getClass().getSimpleName()+"(getGridNumColumns): 屏幕宽度(DP):"+screenWidth+",屏幕列数:"+columns);
        return columns;
    }

    public static int getStatusBarHeight(Context context){
        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        Log.e(TAG, "getStatusBarHeight状态栏高度:" + statusBarHeight);
        return statusBarHeight;
    }

    //隐藏虚拟键盘
    public static void hideKeyboard(View v)
    {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService( Context.INPUT_METHOD_SERVICE );
        if ( imm.isActive() ) {
            imm.hideSoftInputFromWindow( v.getApplicationWindowToken() , 0 );
        }
    }

    //显示虚拟键盘
    public static void showKeyboard(View v)
    {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService( Context.INPUT_METHOD_SERVICE );
        if ( imm.isActive() ) {
            imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static int getAttrColor(Context context,int id){
        TypedValue typedValue = new  TypedValue();
        context.getTheme().resolveAttribute(id, typedValue, true);
        final int color = typedValue.data;
        return color;
    }

    // 文件大小信息
    private static final String[] sizeSuffixes = { "B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB" };
    /**
     * 转换文件大小bytes到可以读格式。
     *
     * @param bytes  文件大小
     * @return
     */
    public static String bytesToHumanReadable(long bytes) {
        double result = bytes;
        int attachedsuff = 0;
        while (result > 1024 && attachedsuff < sizeSuffixes.length) {
            result /= 1024.;
            attachedsuff++;
        }
        result = ((int) (result * 100)) / 100.0;
        return result + " " + sizeSuffixes[attachedsuff];
    }
}
