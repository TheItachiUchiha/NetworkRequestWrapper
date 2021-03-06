package com.ankit.wrapper.interfaces;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.ankit.wrapper.IParsedResponseListener;
import com.ankit.wrapper.IResponseListener;
import com.ankit.wrapper.MemoryPolicy;
import com.ankit.wrapper.NetworkPolicy;
import com.ankit.wrapper.RetryPolicy;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by ankitagrawal on 1/8/16.
 */

public class Builder {
    public interface IBuildUrl {

        IBuildTag url(@NonNull String val);
    }
    public interface IBuildOptions {
        IBuildOptions build();

        IBuildOptions memoryCache(boolean val);

        IBuildOptions diskCache(boolean val);

        IBuildOptions retryPolicy(@Nullable RetryPolicy val);

        void send(@NonNull Context context);

        IBuildOptions headers(HashMap<String, String> val);

        IBuildOptions asJsonObject(@NonNull IResponseListener<JSONObject,?> val);

        <F> IBuildOptions asClass(@NonNull Class<F> mClass,@NonNull IParsedResponseListener<JSONObject,F> val);

        IBuildOptions asString(@NonNull IResponseListener<String,?> val);

        IBuildOptions params(@Nullable JSONObject val);

        IBuildOptions cacheTime( long time);

        IBuildOptions cancel();

        IBuildOptions logLevel( int level);

        IBuildOptions addHeader(@NonNull String key,@NonNull String value);

        IBuildOptions memoryPolicy(@NonNull MemoryPolicy policy, @NonNull MemoryPolicy... additional);

        IBuildOptions networkPolicy(@NonNull NetworkPolicy policy, @NonNull NetworkPolicy... additional);
    }

    public interface IBuildRequestType {


        IBuildUrl post(@Nullable JSONObject val);

        IBuildUrl get();

        IBuildUrl method(int val);

        void invalidate(Context context,String tag);

        void clearCache(Context context);
    }
    public interface IBuildTag {

        IBuildOptions tag(@NonNull String val);
    }
}
