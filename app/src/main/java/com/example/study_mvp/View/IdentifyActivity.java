package com.example.study_mvp.View;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.example.study_mvp.Bean.MyPicture;
import com.example.study_mvp.Presenter.IdentifyPresenter;
import com.example.study_mvp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdentifyActivity extends AppCompatActivity implements MyIdentifyView {
    private Button read,take,identify;
    private ImageView img;
    private View line;
    private TranslateAnimation mAnimation;
    private static final int RESULT_IMAGE=100;
    private static final String IMAGE_TYPE="image/*";
    public static final int TAKE_PHOTO=1;
    String str;
    private Uri ImageUri;
    Bitmap bitmap;
    private String imagePath=null;
    private IdentifyPresenter identifyPresenter=new IdentifyPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_layout);
        read=findViewById(R.id.read);
        take=findViewById(R.id.take);
        identify=findViewById(R.id.identify);
        img=findViewById(R.id.image);
        line=findViewById(R.id.line);
        onClick();
    }

    private void onClick() {
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadPhoto();
            }
        });
        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TakePhoto();
            }
        });
        identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                identifyPresenter.Identify();
            }
        });
    }

    private void TakePhoto() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        str = format.format(curDate);
        //创建一个新的文件夹
        File outputImage = new File(getExternalCacheDir(), str+".jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            ImageUri = FileProvider.getUriForFile(this,
                    "com.example.study_mvp.fileprovider", outputImage);
        } else {
            ImageUri = Uri.fromFile(outputImage);
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, ImageUri);
        startActivityForResult(intent, TAKE_PHOTO);
    }

    private void ReadPhoto() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        Intent intent=new Intent(Intent.ACTION_PICK,null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,IMAGE_TYPE);
        startActivityForResult(intent,RESULT_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==RESULT_IMAGE&&data!=null){
                if (data == null) {
                    Toast.makeText(this, "没有选中内容！", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    //相册
                    //通过获取当前应用的contentResolver对象来查询返回的data数据
                    Cursor cursor=this.getContentResolver().query(data.getData(),null,null,null,null);
                    //将cursor指针移动到数据首行
                    cursor.moveToFirst();
                    //获取字段名为_data的数据
                    imagePath=cursor.getString(cursor.getColumnIndex("_data"));
                    //销毁cursor对象，释放资源
                    cursor.close();
                    Toast.makeText(this,"图片获取成功",Toast.LENGTH_SHORT).show();
                    //将图片路径所得图片类型转换成bitmap
                    bitmap= BitmapFactory.decodeFile(imagePath);
                }
            }else  if (resultCode==RESULT_OK){
                //拍照
                try {
                    Toast.makeText(this,"图片获取成功",Toast.LENGTH_SHORT).show();
                    // 获取相机返回的数据，并转换为Bitmap图片格式
                    bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(ImageUri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            //显示图片
            img.setImageBitmap(bitmap);
        }
    }
    @Override
    public Bitmap getImage() {

        return bitmap;
    }

    @Override
    public void setMsg(MyPicture myPicture) {
        if (myPicture != null) {
            String[] mitems1 = {"名称1：" + myPicture.getName(), "可能性：" + myPicture.getScore(),"百科链接：" +myPicture.getBaikeurl(),"图片链接：" +myPicture.getImageurl(),"介绍：" + myPicture.getDescription()};
            android.app.AlertDialog.Builder alertDialog = new AlertDialog.Builder(IdentifyActivity.this);
            alertDialog.setTitle("识别结果").setItems(mitems1, null).create().show();
        } else {
            android.app.AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(IdentifyActivity.this);
            alertDialog1.setTitle("识别结果").setMessage("无法识别").create().show();
        }
    }

    @Override
    public void hideLoad() {
        line.clearAnimation();
        line.setVisibility(View.GONE);
    }

    @Override
    public void showLoad() {
        line.setVisibility(View.VISIBLE);
        mAnimation = new TranslateAnimation(0, 0, 0, img.getHeight()+300);
        mAnimation.start();
        mAnimation.setDuration(500);
        mAnimation.setRepeatCount(-1);
        /*mAnimation.setRepeatMode(Animation.RESTART);
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setFillAfter(true);
        mAnimation.setFillBefore(true);*/
        line.setAnimation(mAnimation);
    }
}
