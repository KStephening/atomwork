# SWING
### 关闭
```java
//设置当前的默认关闭方法
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//设置点X的时候不做任何事，但是可以添加一个监控ActionListener
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE)
```

### 设置本窗口输入的时候，其他创酷哦阻塞
```java
dialog.setModal(true);
```
### 更新操作
```java
//JToolBar
toolBar.updateUI();

//DefaultTreeModel
defaultModel.reload();

//JMenuBar
menuBar.updateUI();
```

### 循环焦点遍历
```java
//比如按下tab键，以什么样的顺序进行跳转
setFocusTraversalPolicy(new FocusTraversalOnArray(
        new Component[]{fromLocalStart, fromDatabaseButton})
    )
```
### 获取当前的工作目录
```java
System.getProperty("user.dir")
```
###
```java
JFileChooser fDialog = new JFileChooser();
// 设置文件选择框的标题
fDialog.setDialogTitle("请选择文件夹");
File dir = new File(systemConfig.getDataDir());
// 打开的窗口路径为当前路径
fDialog.setCurrentDirectory(dir);
// 弹出选择框
fDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
int returnVal = fDialog.showOpenDialog(null);
// 如果是选择了文件
if (JFileChooser.APPROVE_OPTION == returnVal) {
    dirTextField.setText(fDialog.getSelectedFile().getPath() + File.separator);
}
```
### 日期选择器
```java
JDatePicker startDatePicker = new JDatePicker(
			JDatePicker.STYLE_CN_DATE1);
```
Error:java: Compilation failed: internal java compiler error 解决办法