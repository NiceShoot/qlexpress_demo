package com.jiabing.qlexpress.demo2.service;

import org.springframework.stereotype.Service;

@Service("vipLessonService")
public class VipLessonService {


    public boolean isYuWen(Long id){
        return id == 1;
    }

    public boolean isShuXue(Long id){
        return id == 1;
    }

    public boolean isYingYu(Long id){
        return id == 1;
    }

    public boolean isWuLi(Long id){
        return id == 1;
    }

    public boolean isXiaoMing(String str){
        return "小明".equals(str);
    }
}
