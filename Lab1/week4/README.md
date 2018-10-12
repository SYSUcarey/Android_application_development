# 中山大学数据科学与计算机学院本科生实验报告
## （2018年秋季学期）
| 课程名称 | 手机平台应用开发 | 任课老师 | 郑贵锋 |
| :------------: | :-------------: | :------------: | :-------------: |
| 年级 | 大三 | 专业（方向） | 计应 |
| 学号 | 16340015 | 姓名 | 陈彬彬 |
| 电话 | 13590883387 | Email | 944131226@qq.com |
| 开始日期 | 2018/10/01 | 完成日期 |2018/10/01|

---

## 一、实验题目

**基本的UI界面设计**

---

## 二、实验目的

1. 熟悉Android Studio开发工具操作。

2. 熟悉Android Studio基本UI开发，并进行UI基本设计。



***

## 三、实现内容

实现一个Android应用，界面呈现如图中的效果。 

![](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181010134337.png)

#### 要求

- 该界面为应用启动后看到的第一个界面。  
- 各控件的要求
  1. 标题字体大小**20sp**，与顶部距离**20dp**，居中；
  2. 图片与上下控件的间距均为**20dp**，居中；  
  3. 输入框整体距左右屏幕各间距**20dp**，内容（包括提示内容）如图所示，内容字体大小**18sp**；  
  4. 按钮与输入框间距**10dp**，文字大小**18sp**。按钮背景框左右边框与文字间距**10dp**，上下边框与文字间距**5dp**，圆角半径**180dp**，背景色为**#3F51B5**；  
  5. 四个单选按钮整体居中，与输入框间距10dp，字体大小**18sp**，各个单选按钮之间间距**10dp**，默认选中的按钮为第一个。

#### 使用的组件

  TextView、EditText、ConstraintLayout、Button、ImageView、RadioGroup、RadioButton。 



---

## 四、实验结果
### (1)实验截图

实验效果图：

![](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181010145250.png)




### (2)实验步骤以及关键代码

1. 完成基本控件的基本属性设置。

   根据[tutorial.md](https://gitee.com/SYSUcarey/PersonalProject1/blob/master/manual/tutorial.md)给的教程，在activity_main.xml文件中添加 TextView、ImageView、EditText、Button、RadioGroup、RadioButton控件并配置响应的属性，其中重点在于用ConstraintLayout来进行各控件的位置布局。

   关键代码给出以输入框的代码为例子，输入框包括EditText和Button两个控件，他们左右分布。

   **关键代码**：

```xml
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:id="@+id/button1"
    android:text="搜索"
    android:textColor="@color/white"
    android:textSize="18sp"
    android:paddingLeft="10dp"
    android:paddingRight="10dp"
    android:paddingTop="5dp"
    android:paddingBottom="5dp"
    android:background="@drawable/button_shape_normal"
    android:layout_marginTop="20dp"
    android:layout_marginRight="20dp"
    android:layout_marginLeft="10dp"
    app:layout_constraintTop_toBottomOf="@id/logo"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintLeft_toRightOf="@id/search_box"/>
   
<EditText
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:id="@+id/search_box"
    android:hint="请输入搜索内容"
    android:textSize="18sp"
    android:layout_marginTop="20dp"
    android:layout_marginLeft="20dp"
    app:layout_constraintTop_toBottomOf="@id/logo"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toLeftOf="@id/button1" />
```

2. 完成按钮的背景颜色设置和圆角样式设置

   这是[tutorial.md](https://gitee.com/SYSUcarey/PersonalProject1/blob/master/manual/tutorial.md)教程中没有给出来应该如何去设置相关属性。最后通过在drawable中添加button_shape_normal.xml文件，然后在activity_main.xml中设置Button的background属性。

   **关键代码：**

   activity_main.xml中，对于Button属性设置：

  ```xml
  android:background="@drawable/button_shape_normal"
  ```

​		button_shape_normal.xml中：

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    android:shape="rectangle">
    <!-- rounded corner -->
    <corners android:radius="180dp" />
    <solid android:color="@color/colorPrimary" />
</shape>
```

### (3)实验遇到的困难以及解决思路

1. 输入框，EditText与Button无法左右对齐，即使配置了ConstraintLayout的属性。

   解决方法：修改EditText中的android:layout_width属性

   ```xml
   android:layout_width="0dp"
   ```

2. 完成按钮的背景颜色设置和圆角设置

   解决方法：drawable 添加 button_shape_normal.xml

   ```xml
   <shape xmlns:android="http://schemas.android.com/apk/res/android">
       android:shape="rectangle">
       <!-- rounded corner -->
       <corners android:radius="180dp" />
       <solid android:color="@color/colorPrimary" />
   </shape>
   ```

   [参考博客链接](https://blog.csdn.net/never_cxb/article/details/47662129)

   
---

## 五、实验思考及感想

- 项目实验一难度不大，只用查阅控件对应文档的属性使用方式即可，[tutorial.md](https://gitee.com/SYSUcarey/PersonalProject1/blob/master/manual/tutorial.md)教程已经给出了绝大多数的使用属性，仔细阅读教程之后基本可以完成这次实验，难度不大。
- 做HelloAndroid项目时，没有仔细地去思考各个文件结构的作用，导致这次实验对项目结构认知还不够熟悉。
- 实验遇到问题1的时候，百思不得其解，因为明明自己已经配置好ConstraintLayout属性，依然不懂为什么布局结果并不如自己意。后来在求助舍友后，了解了android:layout_width属性中wrap_content和0dp的区别，事实上在[tutorial.md](https://gitee.com/SYSUcarey/PersonalProject1/blob/master/manual/tutorial.md)也有提到过，只不过自己漏过去了，下次一定再仔细研读tutorial.md。

