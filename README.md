![image](https://github.com/tingshuo202/RecyleView/tree/master/app/gif/bb.gif )  

# RecyleView通过recyleview展示不同的效果：listview，gridview，瀑布流。
1、使用LayoutManager来确定每一个item的排列方式,即显示的方式。
2、增加和删除项目时，有默认的动画效果，通过ItemAnimator。
3、adapter：需要继承RecyleView.Adapter。
4、通过ItemDecoration控制item之间的间隔

三种自带的LayoutManager:
LinearLayoutManager：listview
GridLayoutManager：设置gridview
StaggeredGridLayoutManager：瀑布流，也可以设置横向滚动的gridview

