# Q
## 代码
### CheckBox
> 运行的时候总是会不显示，偶尔又能显示  可能与**FrameUniversal有关**
```java
public class CheckBoxTest {
	public static void main(String[] args) {
		JPanel jPanel = FrameUniversal.init("checkbox", "zidongsh");
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setText("haaa");
		jCheckBox.setEnabled(false);
		jCheckBox.addActionListener(e -> {
			if (jCheckBox.isSelected()) {
				System.out.println("haaaa");
				System.out.println("haaaa");
				System.out.println("haaaa");
			}
		});

		JCheckBox jCheckBox1 = new JCheckBox();
		jCheckBox1.setText("aa");
		jCheckBox1.setEnabled(true);
		jPanel.add(jCheckBox1);
		jPanel.add(jCheckBox);
		jPanel.setVisible(true);


	}
}

```
