# txt文件内容的加密与解密
## 1、概述
目前只上传了V1.0版本，需要V2.0可留邮箱（免费提供源码）。<br>
bin\com\ITRS\EncryptDecrypt -- 编辑过的.class文件<br>
src\com\ITRS\EncryptDecrypt -- 源文件<br>
## 2、exe使用说明
### 2.1 安装java
此工具由java开发，需要安装jre才能使用。
#### 2.1.1 下载安装
百度搜索：jre 下载安装包,双击安装即可。
#### 2.1.2 配置环境
右击“计算机”或“这台电脑”或“我的电脑”<br>
属性-->高级系统设置-->高级-->环境变量-->下侧“系统变量”做如下修改<br>
&nbsp;&nbsp;新建:JAVA_HOME  C:\Program Files (x86)\Java\jre1.8.0_111    //java的安装位置<br>
&nbsp;&nbsp;新建:CLASSPATH  ;.%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar	<br>
&nbsp;&nbsp;编辑:Path       ;C:\Program Files (x86)\Java\jre1.8.0_111\bin   //java安装包中bin的位置<br>
### 2.2 加密-解密软件使用方法
“文件|打开”上传txt文件<br>
&nbsp;&nbsp;左侧文档框为上传的内容，右侧文本框为 加密/解密 。<br>
“文件|保存”下载txt文件<br>
&nbsp;&nbsp;保存的是右侧文本框中的内容。<br>
