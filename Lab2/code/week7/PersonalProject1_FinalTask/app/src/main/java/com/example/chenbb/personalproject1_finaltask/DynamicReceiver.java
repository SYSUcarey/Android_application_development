package com.example.chenbb.personalproject1_finaltask;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DynamicReceiver extends BroadcastReceiver {
    public static final String DYNAMICACTION = "com.example.chenbb.personalproject1_finaltask.MyDynamicFilter";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DYNAMICACTION)) {
            // 通过Intent获取传过来的data
            Bundle bundle = intent.getExtras();
            Collection temp = (Collection) bundle.getSerializable("data");

            //TODO:添加Notification部分

            // NotificationChannel部分
            String channelID = "2";
            String channelName = "channel_2";
            NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
            // PendingIntent部分
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.putExtra("data", temp);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,2, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
            Notification.Builder builder =new Notification.Builder(context);
            builder.setContentTitle("已收藏")
                    .setContentText(temp.getName())
                    .setTicker("您有一条新消息")
                    .setSmallIcon(R.mipmap.empty_star)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .build();
            //创建通知时指定channelID
            builder.setChannelId(channelID);
            Notification notification = builder.build();
            manager.notify(2, notification);
        }
    }
}
