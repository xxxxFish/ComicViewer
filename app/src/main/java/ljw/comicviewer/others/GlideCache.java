package ljw.comicviewer.others;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;

/**
 * Created by ljw on 2017-09-06 006.
 */

@GlideModule
public class GlideCache extends AppGlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置图片的显示格式ARGB_8888(指图片大小为32bit) 4.0+ 默认改为PREFER_ARGB_8888   4.0- 为PREFER_RGB_565
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
//        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);
        File appCacheDir = context.getExternalCacheDir();
        File glideCacheDir = new File(appCacheDir,"GlideCache");
        if (!glideCacheDir.exists()) {
            glideCacheDir.mkdirs();
        }
        Log.d("----","GlideCache缓存文件夹:"+glideCacheDir.getAbsolutePath());
        int cacheSize = 200 * 1024 * 1024;
        builder.setDiskCache(new DiskLruCacheFactory(glideCacheDir.getAbsolutePath(),cacheSize));
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {

    }
}
