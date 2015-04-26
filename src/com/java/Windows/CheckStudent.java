package com.java.Windows;

import com.java.Data.Data;
import com.java.model.MyTableModel;
import com.java.model.MyWindow;
import com.java.model.Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class CheckStudent extends MyWindow
{
	/**
	 * Create the frame.
	 */
	Data studentData = Data.getData();

	public CheckStudent()
	{
		initialWindow("学生信息", "学生信息", new int[]{238, 10, 173, 45});
		JTable table = new JTable(new MyTableModel());
		table.setAutoCreateRowSorter(true);// 排序
		initTable(table);
	}

	public CheckStudent(Student student)
	{
		initialWindow("学生信息", "学生信息", new int[]{238, 10, 173, 45});
		JTable table = new JTable(new MyTableModel(student));
		table.setAutoCreateRowSorter(true);// 排序
		initTable(table);
	}

	public void initTable(JTable table)
	{
		// 自定义第一列更宽
		TableColumn column = null;
		for (int i = 0; i < 5; i++)
		{
			column = table.getColumnModel().getColumn(i);
			if (i == 0)
			{
				column.setPreferredWidth(100); // third column is bigger
			} else
			{
				column.setPreferredWidth(50);
			}
		}

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);// 当数据超过容器高度时，仍然把数据加载到容器里
		scrollPane.setBounds(10, 86, 614, 240);
		contentPane.add(scrollPane);

		JButton buttonImport = new JButton("导入数据");
		buttonImport.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		buttonImport.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				studentData.initData();
				table.updateUI();
			}
		});
		buttonImport.setBounds(510, 55, 100, 21);
		contentPane.add(buttonImport);

		JButton btnAddButton = new JButton("添加学生");
		btnAddButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnAddButton.addActionListener(e -> {
			new AddStudent();
			setVisible(false);

		});
		btnAddButton.setBounds(130, 364, 95, 23);
		contentPane.add(btnAddButton);

		JButton button_1 = new JButton("取消选中");
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.addActionListener(e -> {
			table.clearSelection();
		});
		button_1.setBounds(230, 364, 95, 23);
		contentPane.add(button_1);

		JButton btnNewButton = new JButton("删除选中");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(e -> {
			if (table.getSelectedRow() == -1)
			{
				JOptionPane.showMessageDialog(null, "没有选中项！！");
			} else
			{

				int r = JOptionPane.showConfirmDialog(null, "删除后不可恢复，你确定要删除吗？", "确认删除", JOptionPane.YES_NO_OPTION);
				if (r == 0)
				{// 返回选定行数
					studentData.remove(table.getSelectedRow());
					// 刷新表格
					table.updateUI();
				}
			}
		});
		btnNewButton.setBounds(330, 364, 95, 23);
		contentPane.add(btnNewButton);

		JButton button_2 = new JButton("注销账户");
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.addActionListener(e -> {
			new Login();
			setVisible(false);
		});
		button_2.setBounds(430, 364, 95, 23);
		contentPane.add(button_2);

		setVisible(true);

	}

}
