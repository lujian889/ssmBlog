package com.we.weblog;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bjliuyong on 2017/12/13.
 */
public class UIModel extends HashMap implements Map {

    public static final String MENU_TAG = "menu_items" ;
    public static final String APP_INFO = "app_info" ;
    public static final String IS_LOGIN = "is_login" ;

    public UIModel menu(List<Menu> menus) {
        put(MENU_TAG , menus) ;
        return this ;
    }

    public UIModel appInfo(AppInfo appInfo) {
        put(APP_INFO , appInfo) ;
        return this ;
    }

    public UIModel isLogin(boolean isLogin) {
        put(IS_LOGIN , isLogin) ;
        return this ;
    }


    public UIModel put(String key , Object value) {
        super.put(key , value) ;
        return  this ;
    }

}
