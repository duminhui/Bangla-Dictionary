# Musical Terminology Dictionary - 音乐表情术语词典

一款表情术语查询的Android软件，基于Bangla-Dictionary的查询引擎

------------

## 安装

已经打包好的软件请在百度网盘下载：[http://pan.baidu.com/s/13OAye](http://pan.baidu.com/s/13OAye)

本人已尝试将该软件放进国内 android 市场，但因为版权问题，审核不过

##调试

1. 在 eclipse 中，导入 android 项目
2. 选择sdk，本软件在sdk 15上编译通过，选择sdk 13-18应该都不成问题
3. 编译

注：编译环境是 Windows ，若出现中文乱码的情况，请尝试将乱码文件用notepad++或gedit重新保存为 utf-8 编码和相应系统的文件结束符

## 存在的问题

1. 词典数据来源于网络，很多词条在下载时就包含着一些“?”。恢复的工作，个人还没有经历完成修改。

2. 很多词汇都是意大利文、法文、德文，一些字母无法用键盘打出，因此在查询上会造成一定的困扰。

如果你希望能够添加、修改一些词条，请修改`others/database.xls`，并将更改后的文件以下述任何方式发给我，谢谢！

+ duminghui@126.com
+ @杜杜要吃面

## 导入自己的数据库

本软件使用了 Android 自带的数据库软件 sqlite ，您可以使用任意一款 sqlite 工具操作`assets/dictionary`中的数据。当然，对于一般用户，您可以选择如下方式导入自己的数据库：

1. 在 excel 中完成词典的编写，保存一份如`others/database.xls`的文件。第一列为词条，第二列为释义。在你的释义中不要包含英文`,`，除非你在第二步中使用了其它分隔符。

2. 用LibreOffice或Wps等，将`database.xls`另存为`database.csv`，utf-8编码。默认的分隔符为`,`

3. 将`database.csv`和`assets/dictionary`放入同一目录下  
````
$ cat database.csv
    1,2
    3,4
    5,6
$ sqlite dictionary
    SQLite version 3.8.0.2 2013-09-03 17:11:13
    Enter ".help" for instructions
    Enter SQL statements terminated with a ";"
sqlite> create temp table tmp(x,y);
sqlite> .separator ,
sqlite> .import database.csv tmp
sqlite> select * from tmp;
    1,2
    3,4
    5,6
sqlite> delete from words;
sqlite> insert into words(en_word,zh_word) select * from tmp; 
sqlite> select * from words;
    1,2
    3,4
    5,6
sqlite> drop table tmp; 
sqlite> .exit
````
最后，用新的`dictionary`替换`assets/dictionary`
