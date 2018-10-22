package com.example.chenbb.personalproject1_finaltask;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class StaticReceiver extends BroadcastReceiver {
    public static final String STATICACTION = "com.example.chenbb.personalproject1_finaltask.MyStaticFilter";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(STATICACTION)){
            //TODO:添加Notification部分
            //Toast.makeText(context, "接受到静态广播", Toast.LENGTH_SHORT).show();

            // 通过Intent获取传过来的data
            Bundle bundle = intent.getExtras();
            Collection temp = (Collection) bundle.getSerializable("data");
            // PendingIntent部分
            Intent intent1 = new Intent(context, DetailActivity.class);
            intent1.putExtra("data", temp);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

            /*
             * Andoride 8.0 通知适配
             * 使用NotificationChannel
             * 设置Title, Text, Ticker, Icon, ContentIntent等属性
             */
            String channelID = "1";
            String channelName = "channel_1";
            NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
            Notification.Builder builder =new Notification.Builder(context);
            builder.setContentTitle("今日推荐")
                    .setContentText(temp.getName())
                    .setTicker("您有一条新消息")
                    .setSmallIcon(R.mipmap.empty_star)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .build();
            //创建通知时指定channelID
            builder.setChannelId(channelID);
            Notification notification = builder.build();
            manager.notify(1, notification);
        }
    }
}
