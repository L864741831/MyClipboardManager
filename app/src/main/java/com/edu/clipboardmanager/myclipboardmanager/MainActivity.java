package com.edu.clipboardmanager.myclipboardmanager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        操作 Android 系统剪贴板的类在 android.content 包下（SDK API 11+），主要包含下面三个类:

ClipboardManager： 表示一个剪贴板
ClipData： 剪贴板中保存的所有剪贴数据集（剪贴板可同时复制/保存多条多种数据条目）
ClipData.Item： 剪贴数据集中的一个数据条目
         */




        /*
        复制
         */
        // 获取系统剪贴板
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

// 创建一个剪贴数据集，包含一个普通文本数据条目（需要复制的数据）
        ClipData clipData = ClipData.newPlainText(null, "需要复制的文本数据");

// 把数据集设置（复制）到剪贴板
        clipboard.setPrimaryClip(clipData);




        /*
        粘贴
         */
        // 获取系统剪贴板
        ClipboardManager clipboard1 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

// 获取剪贴板的剪贴数据集
        ClipData clipData1 = clipboard1.getPrimaryClip();

        if (clipData1 != null && clipData1.getItemCount() > 0) {
            // 从数据集中获取（粘贴）第一条文本数据
            CharSequence text = clipData1.getItemAt(0).getText();
            System.out.println("text: " + text);
        }







        /*
剪贴板的数据改变监听
         */


        // 获取系统剪贴板
        ClipboardManager clipboard3 = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

// 添加剪贴板数据改变监听器
        clipboard3.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                // 剪贴板中的数据被改变，此方法将被回调
                System.out.println("onPrimaryClipChanged()");
            }
        });

// 移除指定的剪贴板数据改变监听器
// clipboard.removePrimaryClipChangedListener(listener);


    }
}
