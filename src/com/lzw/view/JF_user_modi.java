package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_UserName;

public class JF_user_modi extends javax.swing.JInternalFrame {
	private static final long serialVersionUID = -196664688529140136L;
	BorderLayout borderLayout1 = new BorderLayout();
	JSplitPane jSplitPane1 = new JSplitPane();
	JScrollPane jScrollPane1 = new JScrollPane();
	JPanel jPanel1 = new JPanel();
	GridLayout gridLayout1 = new GridLayout();
	JLabel jLabel1 = new JLabel();
	JTextField jTid = new JTextField();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JTextField jTname = new JTextField();
	JLabel jLabel4 = new JLabel();
	JTable jTable1 = new JTable();
	JPanel jPanel2 = new JPanel();
	FlowLayout flowLayout1 = new FlowLayout();
	JButton jBsave = new JButton();
	JButton jBexit = new JButton();

	javax.sql.DataSource ds = null;
	java.sql.Connection con = null;
	java.sql.Statement stmt = null;
	java.sql.ResultSet rs = null;

	DefaultTableModel defaultModel = null;
	JPasswordField jPass = new JPasswordField();
	JPasswordField jPassconf = new JPasswordField();
	JButton jBdel = new JButton();

	public JF_user_modi() {
		try {
			jbInit();
			buildeTable();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void buildeTable() {
		Vector<String> vname = new Vector<String>();
		vname.addElement("用户ID");
		vname.addElement("用户姓名");
		vname.addElement("用户口令");
		vname.addElement("重复口令");
		defaultModel = new DefaultTableModel(vname, 0);

		String queryStr = " from Obj_UserName ";
		List list = com.lzw.dao.AdapterDao.QueryObject(queryStr);
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			Obj_UserName objuser = (Obj_UserName) iterator.next();
			Vector<String> vdata = new Vector<String>();
			vdata.addElement(objuser.getUserid());
			vdata.addElement(objuser.getUsername());
			vdata.addElement(objuser.getPassword());
			vdata.addElement(objuser.getPassconf());

			defaultModel.addRow(vdata);
		}

		jTable1.setModel(defaultModel);
		jTable1.setRowHeight(24);

	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(borderLayout1);
		jLabel1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jLabel1.setToolTipText("");
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel2.setLayout(flowLayout1);
		jBsave.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jBsave.setText("存盘");
		jBsave.addActionListener(new JF_user_modi_jBsave_actionAdapter(this));
		jBexit.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jBexit.setText("退出");
		jBexit.addActionListener(new JF_user_modi_jBexit_actionAdapter(this));
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		this.setClosable(true);
		this.setTitle("用户维护");
		jPass.setText("");
		jPassconf.setText("");
		jTable1.addMouseListener(new JF_user_modi_jTable1_mouseAdapter(this));
		jBdel.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
		jBdel.setText("删除");
		jBdel.addActionListener(new JF_user_modi_jBdel_actionAdapter(this));
		this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
		jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jPanel1.setLayout(gridLayout1);
		gridLayout1.setColumns(4);
		gridLayout1.setRows(2);
		jLabel1.setText("用户ID");
		jTid.setText("");
		jLabel2.setText("用户口令");
		jLabel3.setText("用户姓名");
		jTname.setText("");
		jLabel4.setText("重复口令");
		jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
		jSplitPane1.add(jPanel1, JSplitPane.BOTTOM);
		jPanel1.add(jLabel1);
		jPanel1.add(jTid);
		jPanel1.add(jLabel3);
		jPanel1.add(jTname);
		jPanel1.add(jLabel2);
		jPanel1.add(jPass);
		jPanel1.add(jLabel4);
		jPanel1.add(jPassconf);
		jScrollPane1.getViewport().add(jTable1);
		this.getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
		jPanel2.add(jBsave);
		jPanel2.add(jBdel);
		jPanel2.add(jBexit);
		jSplitPane1.setDividerLocation(120);
		jBsave.setEnabled(false);
		this.setBounds(50, 50, 400, 250);
		this.setVisible(true);
	}

	public void jBsave_actionPerformed(ActionEvent actionEvent) {
		int result = JOptionPane.showOptionDialog(null, "是否修改用户信息?", "系统提示",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new String[] { "是", "否" }, "否");
		if (result == JOptionPane.NO_OPTION)
			return;

		String password, password1;
		password = new String(jPass.getPassword());
		password1 = new String(jPassconf.getPassword());

		if (!(password.equals(password1))) {
			JOptionPane.showMessageDialog(null, "输入的两次口令不一致,请重新录入!!!", "系统提示",
					JOptionPane.ERROR_MESSAGE);
			jPassconf.requestFocus();
			return;
		}

		String id, user, pass, passconf;
		id = jTid.getText().trim().trim();
		user = jTname.getText().trim().trim();
		pass = String.valueOf(jPass.getPassword()).trim();
		passconf = String.valueOf(jPassconf.getPassword()).trim();
		Obj_UserName objuser = new Obj_UserName();
		objuser.setUserid(id);
		objuser.setUsername(user);
		objuser.setPassword(pass);
		objuser.setPassconf(passconf);

		AdapterDao.InsertObj_UserName(objuser);
		JOptionPane.showMessageDialog(null, "该用户数据更新成功!!!", "系统提示",
				JOptionPane.INFORMATION_MESSAGE);
		this.buildeTable();

	}

	public void jBexit_actionPerformed(ActionEvent actionEvent) {
		javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
		int result = JOptionPane.showOptionDialog(null, "是否退出用户维护?", "系统提示",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new String[] { "是", "否" }, "否");
		if (result == JOptionPane.YES_OPTION) {
			manger.closeFrame(this);
		}

	}

	public void jTable1_mousePressed(MouseEvent mouseEvent) {
		String id, name, pass, pass1;
		int row;
		row = jTable1.getSelectedRow();
		id = jTable1.getValueAt(row, 0).toString();
		name = jTable1.getValueAt(row, 1).toString();
		pass = jTable1.getValueAt(row, 2).toString();
		pass1 = jTable1.getValueAt(row, 3).toString();
		jTid.setText(id);
		jTname.setText(name);
		jPass.setText(pass);
		jPassconf.setText(pass1);
		jBsave.setEnabled(true);

	}

	public void jBdel_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showOptionDialog(null,
				"是否删除用户" + jTid.getText() + "?", "系统提示",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new String[] { "是", "否" }, "否");
		if (result == JOptionPane.NO_OPTION)
			return;
		com.lzw.model.Obj_UserName objuser = new com.lzw.model.Obj_UserName();
		objuser.setUserid(jTid.getText().trim());
		objuser.setUsername(jTname.getText().trim());
		com.lzw.dao.AdapterDao.DeleteUser(objuser);
		JOptionPane.showMessageDialog(null, "该用户数据删除成功!!!", "系统提示",
				JOptionPane.INFORMATION_MESSAGE);
		this.buildeTable();
		jTid.setText("");
		jTname.setText("");
		jPass.setText("");
		jPassconf.setText("");

	}
}

class JF_user_modi_jBdel_actionAdapter implements ActionListener {
	private JF_user_modi adaptee;

	JF_user_modi_jBdel_actionAdapter(JF_user_modi adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jBdel_actionPerformed(e);
	}
}

class JF_user_modi_jTable1_mouseAdapter extends MouseAdapter {
	private JF_user_modi adaptee;

	JF_user_modi_jTable1_mouseAdapter(JF_user_modi adaptee) {
		this.adaptee = adaptee;
	}

	public void mousePressed(MouseEvent mouseEvent) {
		adaptee.jTable1_mousePressed(mouseEvent);
	}
}

class JF_user_modi_jBexit_actionAdapter implements ActionListener {
	private JF_user_modi adaptee;

	JF_user_modi_jBexit_actionAdapter(JF_user_modi adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		adaptee.jBexit_actionPerformed(actionEvent);
	}
}

class JF_user_modi_jBsave_actionAdapter implements ActionListener {
	private JF_user_modi adaptee;

	JF_user_modi_jBsave_actionAdapter(JF_user_modi adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		adaptee.jBsave_actionPerformed(actionEvent);
	}
}
