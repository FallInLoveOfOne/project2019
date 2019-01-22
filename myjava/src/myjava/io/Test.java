package myjava.io;

import java.io.File;
import java.io.FilenameFilter;

public class Test {

	public static void listAllFilesAndDirs(String path) {

		// 1.����File���󣬱�ʾ���Ŀ¼

		File dir = new File(path);

		// 2.ͨ��list�����õ���������������Ŀ¼�����ļ�����

		String[] names = dir.list(new DirFilter(".docx"));// ���˵õ�docx�ļ���

		// 3��ʾ��Щ����

		for (int i = 0; i < names.length; i++) {

			System.out.println(names[i] + ":"
					+ new File(path + names[i]).isFile());// ��ȡ�ļ��С��ļ��������ж��Ƿ����ļ���ʹ�þ���·��

		}
	}
	
	// �ļ���������
	static class DirFilter implements FilenameFilter {
		
		private String type;
		public DirFilter(String type){
			this.type = type;
		}
		@Override
		public boolean accept(File dir,String name){
			return name.endsWith(type);
		}
		
		/*private Pattern pattern;

		public DirFilter(String regex) {
			pattern = Pattern.compile(regex);
		}

		@Override
		public boolean accept(File dir, String name) {
			return pattern.matcher(name).matches();
		}*/

	}

	public static void main(String[] args) {
		File test = new File("a.txt");
		System.out.println(test.getAbsolutePath());
		System.out.println(test.isAbsolute());
		listAllFilesAndDirs("D:/������ʷ/");
	}
}
