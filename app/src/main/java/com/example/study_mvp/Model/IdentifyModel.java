package com.example.study_mvp.Model;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Handler;
import android.os.Message;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.example.study_mvp.Bean.MyPicture;
import com.example.study_mvp.Presenter.onIdentifyListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class IdentifyModel implements IIdentifyModel {
    private String APP_ID = "17670498";
    private String API_KEY = "HeRRSgi5FLfF73m7FoGAyX3e";
    private String SECRET_KEY = "Ig9y7h7OLvyTTGGS91GPcg8tPZIhTv5M";
    private AipImageClassify aipImageClassify;
    @Override
    public void getPictureInfo(final Bitmap bitmap, final onIdentifyListener onIdentifyListener) {
        if(bitmap==null){
            onIdentifyListener.onError();
        }else{
            new Thread(new Runnable() {
                private static final String TAG = "00";
                @Override public void run() {
                    try {
                        MyPicture picture=new MyPicture();
                        byte[] content = getBitmapByte(bitmap);
                        aipImageClassify = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
                        aipImageClassify.setConnectionTimeoutInMillis(2000);
                        aipImageClassify.setSocketTimeoutInMillis(6000);
                        HashMap<String, String> options = new HashMap<String, String>();
                        options.put("baike_num", "5");//请求http
                        JSONObject res = aipImageClassify.advancedGeneral(content, options);
                        JSONArray jsonArray = new JSONArray(res.optString("result"));
                        String name=jsonArray.optJSONObject(0).optString("root");
                        String score=jsonArray.optJSONObject(0).optString("score");
                        String description=jsonArray.optJSONObject(0).getJSONObject("baike_info").optString("description");
                        String baike_url = jsonArray.optJSONObject(0).getJSONObject("baike_info").optString("baike_url");
                        String image_url=jsonArray.optJSONObject(0).getJSONObject("baike_info").optString("image_url");
                        picture.setName(name);
                        picture.setScore(score);
                        picture.setBaikeurl(baike_url);
                        picture.setImageurl(image_url);
                        picture.setDescription(description);
                        onIdentifyListener.onSuccess(picture);
                    } catch (JSONException e) {
                        onIdentifyListener.onError();
                    }
                }
            }).start();
        }

    }

    private byte[] getBitmapByte(Bitmap bitmap) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        try {
            out.flush();
            out.close();
        }        catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
