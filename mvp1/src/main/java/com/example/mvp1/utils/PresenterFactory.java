package com.example.mvp1.utils;


import com.example.mvp1.base.Presenter;

public interface PresenterFactory<P extends Presenter>{
      P crate();//创建presenter
}
