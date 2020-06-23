package com.freakcoders.utils;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.commons.lang.WordUtils;

public class AlphaCodegenerator extends JFrame {

	public AlphaCodegenerator() {
		super("File Chooser Test Frame");
		setSize(350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton submitButton = new JButton("Submit");

		final JTextField textField = new JTextField(35);

		System.out.println("data is:" + textField.getText().toString());

		getContentPane().add(textField);

		setSize(500, 300);
		setVisible(true);

		// Create a file chooser that opens up as an Open dialog

		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				// int option = chooser.showOpenDialog(SimpleFileChooser.this);

				/* System.out.println("i clicked on submit button"); */
				System.out.println("Text entered:" + textField.getText());
				try {
					writeToFile(textField.getText().toString());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * try { writeToFile("my java class1."); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */

			}
		});

		c.add(submitButton);

	}

	private void writeToFile(String filename) throws IOException {

		//final String basepath = "C:\\Users\\Gandharv.Kumar\\Documents\\GENCODE\\";
		 final String basepath = "/Users/deepakpoojari/Workspace/Gencode/";

		final String packageName = "sports99";

		String Service = "package com." + packageName + ".service;" + "import java.util.List;" + "import com."
				+ packageName + ".model." + filename + ";" + "public interface " + filename + "Service {" + "\n"
				+ "// save or update " + filename + "\n" + "public boolean saveOrUpdate(" + filename + " "
				+ WordUtils.uncapitalize(filename) + ");" + "\n" + "// get list of " + filename + "\n" + "public List<"
				+ filename + "> list();" + "\n" + "// delete " + filename + "\n" + "public boolean delete(" + filename
				+ " " + WordUtils.uncapitalize(filename) + ");" + "\n" + "// get list of " + filename
				+ " by colName and colValue" + "\n" + "public  List<" + filename
				+ "> getByColNameValue(String colName, String colValue);" + "\n" + "// get list of " + filename
				+ " by colName and colValue" + "\n" + "public  List<" + filename
				+ "> getByColNameValue(String colName, long colValue);" + "\n" + "// get " + filename
				+ " by primary key" + "\n" + "public " + filename + " getObject(long id);" + "}";

		File f1 = new File(basepath + filename + "Service.java");
		System.out.println(f1);
		FileWriter fw2 = new FileWriter(f1, true);
		System.out.println(fw2);
		try {
			BufferedWriter bw = new BufferedWriter(fw2);
			System.out.println(bw);
			bw.newLine();
			bw.write(Service);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		String ServiceImpl = "package com." + packageName + ".serviceImpl;" + "import java.util.List;"
				+ "import org.springframework.beans.factory.annotation.Autowired;"
				+ "import org.springframework.stereotype.Service;" + "import com." + packageName + ".dao." + filename
				+ "Dao;" + "import com." + packageName + ".model." + filename + ";" + "import com." + packageName
				+ ".service." + filename + "Service;" + "@Service " + "public class " + filename
				+ "ServiceImpl implements " + filename + "Service{" + "@Autowired " + "" + filename + "Dao "
				+ WordUtils.uncapitalize(filename) + "Dao; " + "\n" + "/* (non-Javadoc)" + "\n" + "* @see com."
				+ packageName + ".service." + filename + "Service" + "#saveOrUpdate(" + "com." + packageName + ".model."
				+ filename + ")" + "\n" + "*/" + "\n" + "@Override" + "\n" + "public boolean saveOrUpdate(" + filename
				+ " " + WordUtils.uncapitalize(filename) + ") {" + "return " + WordUtils.uncapitalize(filename)
				+ "Dao.saveOrUpdate(" + WordUtils.uncapitalize(filename) + ");" + "}" + "\n" + "/* (non-Javadoc)" + "\n"
				+ "* @see com." + packageName + ".service." + filename + "Service" + "#list()" + "\n" + "*/" + "\n"
				+ "@Override" + "\n" + "public List<" + filename + "> list() {" + "return "
				+ WordUtils.uncapitalize(filename) + "Dao.list();" + "}" + "\n" + "/* (non-Javadoc)" + "\n"
				+ "* @see com." + packageName + ".service." + filename + "Service" + "#delete(" + "com." + packageName
				+ ".model." + filename + ")" + "\n" + "*/" + "\n" + "@Override" + "\n" + "public boolean delete("
				+ filename + " " + WordUtils.uncapitalize(filename) + ") {" + "return "
				+ WordUtils.uncapitalize(filename) + "Dao.delete(" + WordUtils.uncapitalize(filename) + ");" + "}"
				+ "\n" + "/* (non-Javadoc)" + "\n" + "* @see com." + packageName + ".service." + filename + "Service"
				+ "#getByColNameValue(java.lang.String, java.lang.String)" + "\n" + "*/" + "\n" + "@Override" + "\n"
				+ "public List<" + filename + "> getByColNameValue(String colName, String colValue) {" + "return "
				+ WordUtils.uncapitalize(filename) + "Dao.getByColNameValue(colName, colValue);" + "}" + "\n"
				+ "/* (non-Javadoc)" + "\n" + "* @see com." + packageName + ".service." + filename + "Service"
				+ "#getByColNameValue(java.lang.String, long)" + "\n" + "*/" + "\n" + "public List<" + filename
				+ "> getByColNameValue(String colName, long colValue) {" + "return " + WordUtils.uncapitalize(filename)
				+ "Dao.getByColNameValue(colName, colValue);" + "}" + "\n" + "/* (non-Javadoc)" + "\n" + "* @see com."
				+ packageName + ".service." + filename + "Service" + "#getObject(long)" + "\n" + "*/" + "\n"
				+ "@Override" + "\n" + "public " + filename + " getObject(long id) {" + "return "
				+ WordUtils.uncapitalize(filename) + "Dao.getObject(id);" + "}" + "}";

		File f2 = new File(basepath + filename + "ServiceImpl.java");
		System.out.println(f2);
		FileWriter fw3 = new FileWriter(f2, true);
		System.out.println(fw3);
		try {
			BufferedWriter bw1 = new BufferedWriter(fw3);
			System.out.println(bw1);
			bw1.newLine();
			bw1.write(ServiceImpl);
			bw1.flush();
			bw1.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		String Dao = "package com." + packageName + ".dao;" + "import java.util.List;" + "import com." + packageName
				+ ".model." + filename + ";" + "public interface " + filename + "Dao {" + "\n" + "// save or update "
				+ filename + "\n" + "public boolean saveOrUpdate(" + filename + " " + WordUtils.uncapitalize(filename)
				+ ");" + "\n" + "// get list of " + filename + "\n" + "public List<" + filename + "> list();" + "\n"
				+ "// delete " + filename + "\n" + "public boolean delete(" + filename + " "
				+ WordUtils.uncapitalize(filename) + ");" + "\n" + "// get list of " + filename
				+ " by colName and colValue" + "\n" + "public  List<" + filename
				+ "> getByColNameValue(String colName, String colValue);" + "\n" + "// get list of " + filename
				+ " by colName and colValue" + "\n" + "public  List<" + filename
				+ "> getByColNameValue(String colName, long colValue);" + "\n" + "// get " + filename
				+ " by primary key" + "\n" + "public " + filename + " getObject(long id);" + "}";
		File f3 = new File(basepath + filename + "Dao.java");
		System.out.println(f3);
		FileWriter fw4 = new FileWriter(f3, true);
		System.out.println(fw4);
		try {
			BufferedWriter bw2 = new BufferedWriter(fw4);
			System.out.println(bw2);
			bw2.newLine();
			bw2.write(Dao);
			bw2.flush();
			bw2.close();
		} catch (Exception e3) {
			System.out.println(e3);
		}

		String DaoImpl = "package com." + packageName + ".daoImpl;" + "import java.util.List;"
				+ "import org.hibernate.SessionFactory;"
				+ "import org.springframework.beans.factory.annotation.Autowired;"
				+ "import org.springframework.stereotype.Repository;"
				+ "import org.springframework.transaction.annotation.Transactional;" + "import com." + packageName
				+ ".dao." + filename + "Dao;" + "import com." + packageName + ".model." + filename + ";" + "@Repository"
				+ "@Transactional " + "public class " + filename + "DaoImpl implements " + filename + "Dao{"
				+ "@Autowired " + "SessionFactory session;" + "\n" + "/* (non-Javadoc)" + "\n"
				+ "* @see com."+ WordUtils.uncapitalize(filename) +
				".core.dao." + filename + "Dao#saveOrUpdate(com." + packageName + ".model."
				+ filename + ")" + "\n" + "*/" + "\n" + "@Override" + "\n" + "public boolean saveOrUpdate(" + filename
				+ " " + WordUtils.uncapitalize(filename) + ") {" + "session.getCurrentSession().saveOrUpdate("
				+ WordUtils.uncapitalize(filename) + ");" + "return true;" + "}" + "/* (non-Javadoc)" + "\n"
				+ "* @see com." + packageName + ".dao." + filename + "Dao" + "#list()" + "\n" + "*/" + "\n"
				+ "@SuppressWarnings(\"unchecked\")" + "\n" + "@Override" + "\n" + "public List<" + filename
				+ "> list() {" + "return session.getCurrentSession().createQuery(\"from " + filename + "\").list();"
				+ "}" + "/* (non-Javadoc)" + "\n" + "* @see com." + packageName + ".dao." + filename + "Dao"
				+ "#delete(com." + packageName + ".model." + filename + ")" + "\n" + "*/" + "\n" + "@Override" + "\n"
				+ "public boolean delete(" + filename + " " + WordUtils.uncapitalize(filename) + ") {" + "try {"
				+ "session.getCurrentSession().delete(" + WordUtils.uncapitalize(filename) + ");"
				+ "} catch (Exception ex) {" + "return false;" + "}" + "return true;" + "}" + "/* (non-Javadoc)" + "\n"
				+ "* @see com." + packageName + ".dao." + filename + "Dao"
				+ "#getByColNameValue(java.lang.String,java.lang.String)" + "\n" + "*/" + "\n"
				+ "@SuppressWarnings(\"unchecked\")" + "\n" + "@Override" + "\n" + "public List<" + filename
				+ "> getByColNameValue(String colName, String colValue) {"
				+ "return session.getCurrentSession().createQuery(\"from " + filename
				+ " where \"+colName+\"='\"+colValue+\"'\").list();" + "}" + "/* (non-Javadoc)" + "\n" + "* @see com."
				+ packageName + ".dao." + filename + "Dao" + "#getByColNameValue(java.lang.String,long)" + "\n" + "*/"
				+ "\n" + "@SuppressWarnings(\"unchecked\")" + "\n" + "@Override" + "\n" + "public List<" + filename
				+ "> getByColNameValue(String colName, long colValue) {"
				+ "return session.getCurrentSession().createQuery(\"from " + filename
				+ " where \"+colName+\"='\"+colValue+\"'\").list();" + "}" + "/* (non-Javadoc)" + "\n" + "* @see com."
				+ packageName + ".dao." + filename + "Dao" + "#getObject(long)" + "\n" + "*/" + "\n" + "public "
				+ filename + " getObject(long id) {" + "    " + filename + " " + WordUtils.uncapitalize(filename)
				+ " = (" + filename + ") session.getCurrentSession().get(" + filename + ".class, id);" + "return "
				+ WordUtils.uncapitalize(filename) + ";" + "}" + "}";

		File f4 = new File(basepath + filename + "DaoImpl.java");
		System.out.println(f4);
		FileWriter fw5 = new FileWriter(f4, true);
		System.out.println(fw5);
		try {
			BufferedWriter bw = new BufferedWriter(fw5);
			// System.out.println(bw);
			bw.newLine();
			bw.write(DaoImpl);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) throws IOException, InterruptedException {

		AlphaCodegenerator sfc = new AlphaCodegenerator();
		// Runtime.getRuntime().exec("C:\\Anaconda2\\python.exe
		// C:\\Users\\Gandharv.Kumar\\Documents\\GENCODE\\test.py");
		sfc.setVisible(true);
	}

}