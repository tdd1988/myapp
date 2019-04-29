package com.example;

import java.util.Arrays;
import java.util.List;


/**
 * Created by tdd on 2019/4/2.
 */

public class Dss  {
    public void setOnClickListener(OnClickListener onClickListener){
        onClickListener.onClick();
    }


    public interface OnClickListener {void onClick();}
}
