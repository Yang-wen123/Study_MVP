package com.example.study_mvp.Model;

import com.example.study_mvp.Bean.Girl;

import java.util.ArrayList;
import java.util.List;

public class GirlModelImpl implements IGirlModel {
    @Override
    public void loadGirl(GrilOnLoadListener listener) {
        //加载数据
        List<Girl> data = new ArrayList<>();
        data.add(new Girl("刘亦菲","https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=a38cb7e5af1ea8d39e2f7c56f6635b2b/c2fdfc039245d6884449b2faadc27d1ed21b2420.jpg"));
        data.add(new Girl("杨幂","https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=4cd858ed9f0a304e462fa8a8b0a1cce3/d53f8794a4c27d1e63dc172d13d5ad6edcc43864.jpg"));
        data.add(new Girl("唐嫣","https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=ac5b0fe02d381f308a1485fbc868276d/08f790529822720e3e87df227ecb0a46f31fab98.jpg"));
        data.add(new Girl("景甜","https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=c9b60227d52a6059461de948495d5ffe/30adcbef76094b363416f503a1cc7cd98c109d5c.jpg"));
        data.add(new Girl("赵丽颖","https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=826890e23a01213fdb3e468e358e5db4/48540923dd54564e9d204002b0de9c82d1584f47.jpg"));
        data.add(new Girl("Angelababy","https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=005e5fcd9aef76c6c4dff379fc7f969f/9358d109b3de9c8234db74636681800a18d843a4.jpg"));
        data.add(new Girl("孙俪","https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=e82ca234a18b87d6444fa34d6661435d/203fb80e7bec54e76de10a1bb9389b504fc26aa1.jpg"));
        //返回数据
        listener.onComplete(data);
    }
}
