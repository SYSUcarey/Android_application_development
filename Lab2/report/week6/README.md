# 中山大学数据科学与计算机学院本科生实验报告
## （2018年秋季学期）
| 课程名称 | 手机平台应用开发 | 任课老师 | 郑贵锋 |
| :------------: | :-------------: | :------------: | :-------------: |
| 年级 | 大三 | 专业（方向） | 计应 |
| 学号 | 16340015 | 姓名 | 陈彬彬 |
| 电话 | 13590883387 | Email | 944131226@qq.com |
| 开始日期 | 2018/10/13 | 完成日期 |2018/10/16|

---

## 一、实验题目

**Intent、Bundle的使用以及RecyclerView、ListView的应用**

---

## 二、实验目的

1. 复习事件处理。  
2. 学习Intent、Bundle在Activity跳转中的应用。
3. 学习RecyclerView、ListView以及各类适配器的用法。
4. 学习FloatingActionBar的用法。

***

## 三、实现内容

- 本次实验模拟实现一个健康食品列表，有两个界面，第一个界面用于呈现食品列表 如下所示  
  ![img1](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img1.jpg)  
  数据在"manual/素材"目录下给出。  
  点击右下方的悬浮按钮可以切换到收藏夹  
  ![img2](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img2.jpg)   
  上面两个列表点击任意一项后，可以看到详细的信息：  
  ![img3](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img3.jpg) 

### UI要求

  - 食品列表  
        每一项为一个圆圈和一个名字，圆圈和名字都是垂直居中。圆圈内的内容是该食品的种类，内容要处于圆圈的中心，颜色为白色。食品名字为黑色，圆圈颜色自定义，只需能看见圆圈内的内容即可。
  - 收藏夹  
        与食品列表相似
  - 食品详情界面  
    1. 界面顶部  
       ![img4](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img4.jpg)  
       顶部占整个界面的1/3。每个食品详情的顶部颜色在数据中已给出。返回图标处于这块区域的左上角，食品名字处于左下角，星标处于右下角，边距可以自己设置。 **返回图标与名字左对齐，名字与星标底边对齐。** 建议用RelativeLayout实现，以熟悉RelativeLayout的使用。  
    2. 界面中部  
       ![img5](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img5.jpg)  
       使用的黑色argb编码值为#D5000000，稍微偏灰色的“富含”“蛋白质”的argb编码值为#8A000000。"更多资料"一栏上方有一条分割线，argb编码值为#1E000000。右边收藏符号的左边也有一条分割线，要求与收藏符号高度一致，垂直居中。字体大小自定。"更多资料"下方分割线高度自定。这部分所有的分割线argb编码值都是#1E000000。  
    3. 界面底部  
       ![img6](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img6.jpg)  
       使用的黑色argb编码值为#D5000000。  
  - 标题栏  
        两个界面的标题栏都需要去掉  

### 功能要求

  - 使用RecyclerView实现食品列表。点击某个食品会跳转到该食品的详情界面，呈现该食品的详细信息。长按列表中某个食品会删除该食品，并弹出Toast，提示 **"删除XX"** 。

  - 点击右下方的FloatingActionButton，从食品列表切换到收藏夹或从收藏夹切换到食品列表，并且该按钮的图片作出相应改变。

  - 使用ListView实现收藏夹。点击收藏夹的某个食品会跳转到食品详情界面，呈现该食品的详细信息。长按收藏夹中的某个食品会弹出对话框询问是否移出该食品，点击确定则移除该食品，点击取消则对话框消失。如长按“鸡蛋”，对话框内容如下图所示。  
    ![img7](https://gitee.com/code_sysu/PersonalProject1/raw/master/manual/images/img7.jpg)

  - 商品详情界面中点击返回图标会返回上一层。点击星标会切换状态，如果原本是空心星星，则会变成实心星星；原本是实心星星，则会变成空心星星。点击收藏图表则将该食品添加到收藏夹并弹出Toast提示 **"已收藏"** 。

### 验收内容

- 食品列表和收藏夹中，圆圈是圆的，圆圈内的字居中，圆圈和食品名字垂直居中。
- 食品详情界面中，顶部占三分之一的**实现方法**。以及界面顶部各控件的位置与对齐关系。
- 食品详情界面中，中部收藏符号旁边的分割线上下与符号等高且垂直居中。
- 食品列表用RecyclerView实现，收藏夹用ListView实现，食品详情底部的四个操作列表用ListView实现。
- 单击后跳转各项资料显示正确，星星点击后行为正常，返回图表功能正常。
- 食品列表中的食品长按后能正确删除食品，且删除后列表工作正常（点击其他食品显示信息正确，长按其他食品删除操作正确）。
- 收藏夹中的食品长按后弹出框显示内容正确，点击确定后能正确删除食品，且删除后列表工作正常（点击其他食品显示信息正确，长按其他食品删除操作正确）。
- 长按事件能正确处理，不会报错
- 悬浮按钮的功能正确。
- 从收藏夹界面点击食品X进入食品X的详情界面，点击收藏图标后，点击返回按钮，回到收藏夹界面且收藏夹内多出食品X这一项。若在食品X的详情界面没有点击收藏图标，返回后收藏夹界面也不会多出食品X的条目。
- 详情界面点击返回按钮，是返回上一界面，而非跳转到新的界面中，即不是跳转到新建的食品列表界面或收藏夹界面。
- 点击收藏夹界面的"收藏夹"一项，应用不会出错。
- 不做检查的几项：  
      1. 若圆圈为button控件，点击该圆圈后可以不跳转到详情界面。  
      2. UI要求中要求自定的距离，颜色等均不检查。  
      3. 详情界面顶部，中部可不用RelativeLayout实现。  
      4. 详情界面中点击星星图标，图标的状态不需要保存，即再次进入这一项的详情界面，星星图标仍可以是空心星星。  
      5. 点击收藏按钮后，如果不是点击返回图标返回上一级界面，收藏夹内容可以不改变。  
      6. 多次点击某个食品的详情页面的收藏按钮，收藏夹内可以只出现一个或多个该食品。  
- 如果有以上验收内容存在疑问的话，以demo为准。

---

## 四、实验结果
### 1. 实验截图

#### (1)食谱主界面

APP的起始页面，短按食品列表项，进入食品详情。长按食品列表项，删除在食谱List中删除该食品。点击右下角悬浮按钮，显示收藏夹界面。

![MainPage_foodList](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017162710.png)



#### (2)收藏夹页面

（点击右下角悬浮按钮在食谱界面和收藏夹界面跳转）

![MainPage_favoriteFoodList](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017162834.png)

#### (3)食物详情界面

![](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017170405.png)

#### (4)APP应用操作

短按食谱界面或收藏夹界面食物列表项进入食品对应的详情界面后：

- 点击收藏按钮添加食物到收藏夹

![DetailPage_clickFavoriteButton](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017163025.png)



- 点击star按钮，实心/空心星星转变。

![DetailPage_clickStarButton](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017163221.png)

- 点击返回按钮，退回到主界面。**activity_main.xml**。可以看到收藏夹界面添加了海鱼食品。

  ![add_Fish_To_FavoriteList](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017163434.png)

  如法炮制，再添加几项进入收藏夹（可重复添加同一项食品）

  ![moreFood_intoFavoriteList](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017163914.png)

- 长按收藏夹食物项（最上面的“收藏夹”项不是），都会弹出窗口，询问是否从收藏夹内删除，确定的话就删除该食品。

  ![ask_If_Delete_FavoriteListItem](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017164000.png)

  ![if_Yes_DeleteIt](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017164043.png)

  

- 食谱界面长按，直接在食谱中删除该食品；短按跳转详情界面。

  如图删剩食谱前两项。删除时有**Tosat**消息提醒。

  ![delete_Food_From_foodList](https://chenbb-1257745007.cos.ap-guangzhou.myqcloud.com/blog/20181017164405.png)

  

***


### 2. 实验步骤以及关键代码

#### (1)项目文件结构

`java->com.example.chenbb.personalproject1_finaltask`中含有五个**Java**文件：

- MainActivity.java

- DetailActivity.java

- Collection.java

- MyRecyclerViewAdapter

- MyViewHolder

`res->layout`中有四个**XML**文件：

- activity_main.xml
- detail.xml
- item.xml
- operation.xml

#### (2)食谱界面的实现

食谱界面是由一个**RecyclerView**来展现食谱中的食物列表。

食物信息封装在类**Collection**中。

**RecyclerView**使用的是自定义的适配器，定义在**MyRecyclerViewAdapter**类中，这个类是继承自**RecyclerView.Adapter**，其中我们要重载**MyRecyclerViewAdapter**的**onCreateViewHolder**，**onBindViewHolder**，**getItemCount**方法，其中为了定义它的点击响应事件，还要定义接口**OnItemClickListener**，定义方法**setOnItemClickListener**。

定义自己的**MyViewHolder**用于上面的**Adapter**的定义。

食谱列表中每一项的布局定义在**item.xml**中。

***

**首先关于食物信息，我们将信息封装在一个Collection类中。**

在**Collection.java**中定义类，设置私有信息，设置相对应的构造函数，get函数和set函数。其中**Collection类**要**implements Serializable**，以便后续页面跳转的时候传递数据。

```java
public class Collection implements Serializable{
    private String type;
    private String name;
    private String longType;
    private String nutrition;
    private String color;
    private boolean isCollected;
    
    //todo
}
```

**Collection**类的构造函数，和get方法、set方法都很简单，这里不列出来了。

***

**XML中布局使用RecyclerView，以及后台java代码**

在**activity_main.xml**中添加**RecyclerView**控件：

`layout->activity_main.xml`中：

```xml
<android.support.v7.widget.RecyclerView
    android:id="@+id/recyclerView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:dividerHeight="10dp"
    android:visibility="visible"/>
```

在**item.xml**中对列表每一项进行布局，其中左边是一个圆形蓝色按钮，右边是一个**TextView**。

**TextView**控件比较容易实现，这里不讲。**Button**控件圆形蓝色的实现方法在lab1中已经给有。

创建`drawable->button_shape_of_foodtype.xml`文件：

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    android:shape="rectangle">
    <!-- rounded corner -->
    <corners android:radius="180dp" />
    <solid android:color="@color/colorPrimary" />
</shape>
```

`layout->item.xml`文件中添加**Button**控件：

```xml
<Button
    android:layout_width="60sp"
    android:layout_height="60sp"
    android:background="@drawable/button_shape_of_foodtype"
    android:layout_weight = "1"
    android:id="@+id/type"
    android:textSize="25sp"
    android:textColor="@color/white"
    android:layout_margin="20dp"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toLeftOf="@+id/name"/>
```

然后我们使用我们自己定义**MyRecyclerViewAdapter**对**RecyclerView**进行适配

`MainActivity.java`文件**onCreate**函数中：（`data：List<Collection>`）

```java
// 初始化食谱数据
data = new ArrayList<>();
String[] foodType = new String[]{"粮", "蔬", "饮", "肉", "蔬", "饮", "蔬", "蔬", "粮", "杂"};
String[] foodName = new String[]{"大豆", "十字花科蔬菜", "牛奶", "海鱼", "菌菇类", "绿茶", "番茄", "胡萝卜", "荞麦", "鸡蛋"};
String[] longType = new String[]{"粮食", "蔬菜", "饮品", "肉食", "蔬菜", "饮品", "蔬菜", "蔬菜", "粮食", "杂"};
String[] foodNutrition = new String[]{"蛋白质", "维生素C", "钙", "蛋白质", "微量元素", "无机矿质元素", "番茄红素", "胡萝卜素", "膳食纤维", "几乎所有物质"};
String[] color = new String[]{"#BB4C3B", "#C48D30", "#4469B0", "#20A17B", "#BB4C3B", "#C48D30", "#4469B0", "#20A17B", "#BB4C3B", "#C48D30"};
for (int i = 0; i < 10; i++) {
    Collection temp = new Collection(foodType[i], foodName[i], longType[i], foodNutrition[i], color[i], false);
    data.add(temp);
}

myAdapter = new MyRecyclerViewAdapter<Collection>(MainActivity.this, R.layout.item, data) {
    //todo
    //重载MyRecyclerViewAdapter类中定义的虚函数convert
}

myAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
    //todo
    //点击事件重载，包括短按onClick和长按onLongClick
}
                                 
// 动画效果 setAdapter                                 
recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(myAdapter);
scaleInAnimationAdapter.setDuration(1000);
recyclerView.setAdapter((scaleInAnimationAdapter));
recyclerView.setItemAnimator(new OvershootInLeftAnimator()); 
```

***

关于**MyRecyclerViewAdapter.java**与**MyViewHolder.java**的实现。

`MyRecyclerViewAdapter.java`中的成员、函数结构：（其中大多数代码在教程中给出了，这里**todo**省略）

```java
public abstract class MyRecyclerViewAdapter<T> extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private int layoutId;
    private List<T> data;
    private OnItemClickListener onItemClickListener;
    
    //构造函数
    public MyRecyclerViewAdapter(Context _context, int _layoutId, List _data){
        //todo
    }
    
    //创建自定的ViewHolder和绑定ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    	//todo
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //todo
        //调用convert虚函数
        //绑定监听器
    }
    
    // 重载必要函数，获得列表中size数量
    @Override
    public int getItemCount() {
        //todo
    }
    
    //定义虚函数
    public abstract void convert(MyViewHolder holder, T t);
    
    //定义点击事件接口
    public interface OnItemClickListener{
        //todo
    }
    public void setOnItemClickListener(OnItemClickListener _onItemClickListener){
        //todo
    }
    
}
```

`MyViewHolder.java`文件，教程中已给出，复制粘贴即可。

***

#### (3)收藏夹界面的实现

相比于食谱界面，还是简单很多，这里没有创建使用教程中给的**MyListViewAdapter.java**，数据存储也不封装在**Collection**中，而是直接用**List<Map<String, Object>> 数据结构**进行存储。列表项的布局与食谱界面的一样，依然使用的是**item.xml**的列表项布局。所以大致代码与食谱界面实现的代码差不多。

这里给出避免点击到“收藏夹”项的点击事件处理，通过判断文字是否是“收藏夹”而实现的。以长按事件处理为例，如果长按的是“收藏夹”项，则无响应，如果是别的项，弹出窗口询问是否删除，确定的话则删除收藏夹中的该项。

```java
//长按事件处理
listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        // 如果点击到收藏夹，无反应
        if(favorite.get(position).get("name").toString().equals("收藏夹")) return true;
        // 处理长按事件
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("删除");
        builder.setMessage("确定删除" + favorite.get(position).get("name").toString() + "?" );
        // 设置正面按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                favorite.remove(position);
                simpleAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        // 设置反面按钮
builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return true;
    }
});
```

***

#### (4)页面跳转的实现

使用**Intent**和**Bundle**从主界面跳到详情界面，详情界面回调回主界面。

`MainActivity.java`中跳转：

```java
Intent intent =new Intent(MainActivity.this, DetailActivity.class);
Bundle bundle = new Bundle();
bundle.putSerializable("data", data.get(position));
intent.putExtras(bundle);
startActivityForResult(intent, 0);
```

`DetailActivity.java`中获得页面跳转的Intent中的数据

```java
Intent intent = this.getIntent();
Bundle bundle = intent.getExtras();
data = (Collection) bundle.getSerializable("data");
data.setCollected(false);
```



`DetailActivity.java`中回调（判断是否收藏了该食品）：

```java
if(data.getIsCollected() == true) {
	Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
    Bundle bundle1 = new Bundle();
    bundle1.putSerializable("data", data);
    intent1.putExtras(bundle1);
    setResult(RESULT_OK, intent1);
}
finish();
```

然后`MainActivity.java`中要重载回调后的执行函数**onActivityResult**。

为了就是实现，如果回调过来的数据中表示收藏了该食品，那么我们要在收藏夹列表中add这一项食品，然后更新Adapter。

***

#### (5)详情界面的实现

最难的就是1/3屏幕高度的实现，解决方法是最外层用**LinearLayout**，通过属性**layout_weight**的设置，实现按比例分配高度。而各分区的实现，用**RelativeLayout**控件裹着里面的子控件，确实布局来说很方便。

还有分割线的实现：（横分割线）

```xml
<View
    android:layout_width="match_parent"
    android:layout_height="3px"
    android:layout_marginLeft="20dp"
    android:layout_marginRight="20dp"
    android:background="#1E000000"/>
```

具体看后续遇到的困难中都有提到。

详情界面底部是一个**ListView**，用最简单的**ArrayAdapter**就行了，但项目中我粘贴方便，还是用了**SimpleAdapter**。这个想复杂了一点点。

***

### 3. 实验遇到的困难以及解决思路

1. **RecyclerView**的使用，**List**中一个**Item**占一整页的问题。

    **原因**：item.xml中单项控件的高度设成了**match_parent**，这样会导致列表中的每一项的高度都是整个屏幕高度。

    **解决方法**：**item.xml**文件中最外层**Layout**的属性**layout_height = wrap_content**

    [参考博客](https://bbs.csdn.net/topics/391997966)

2. 点击事件，**TextView**字后面的空间无法聚焦点击。

    **解决方法**：在**activity_main.xml**中对**ListView**和**RecyclerView**的**width**都要设成**match_parent**，不然只能点到控件所在的地方，控件后面的点击无效。

    [参考博客](https://blog.csdn.net/Zero_uou/article/details/78397932)

3. **Android** 用**Intent**跳转时，新页面未显示就直接闪退程序

    **原因**：新页面未在AndroidMainfest.xml中注册

    [页面跳转参考博客](https://www.cnblogs.com/comefuture/p/6734913.html)

4. 设置Layout的layout_weight实现按比例分配屏幕高度发现没用

    **原因**：是layout_weight属性只用于**LinearLayout**布局。

    **解决方案**：**detail.xml**最外层的布局用**LinearLayout**，**LinearLayout**里面再加**RelativeLayout**，设置**layout_weight**属性实现屏幕高度比例分配。

    [参考博客](https://blog.csdn.net/ljheee/article/details/53425410)

5. 分割线的实现方法

    **解决方案**：横分割线，设置高度很小；竖分割线，设置宽度很小。

    [参考博客](https://blog.csdn.net/nazicsdn/article/details/80193406)

6. 使用**Bundle.putSerializable()** 在Activity中交换数据的实现。

    [参考博客](https://blog.csdn.net/qq_33441205/article/details/50669006) 

    [参考博客2](https://www.cnblogs.com/tianguook/p/3407378.html)

    

---

## 五、实验思考及感想

- 项目实验三的难度相较于实验一二来说，就难很多了，[tutorial.md](https://gitee.com/SYSUcarey/PersonalProject1/blob/master/manual/tutorial.md)给出的教程也有很多页，接触到的新概念也很多，重点在于不同种类的**ListView**，自定义的**Adapter**，这两个知识点是这次实验的核心重点。
- 关于布局方面，学会了**LinearLayout**和**RelativeLayout**的基础使用，了解到它们在布局方面上的优点优越性，主要体现在这次实验关于详情界面的布局上。
- 当然还有页面跳转这个在之前看上去应该是很难得一个点，教程也没有给出相应的代码，但是我简单地上网查了一下，发现Intent, Bundle实现页面跳转的原理很简单，数据也是放在Intent中一起传递过去的，之后就简单了，网上的教程讲得很清晰。
- 这周的项目用的时间也很长，但实现了这一个项目感觉学会了很多很多，收获很大。
