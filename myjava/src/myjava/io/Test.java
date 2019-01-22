package myjava.io;

import java.io.File;
import java.io.FilenameFilter;

public class Test {

	public static void listAllFilesAndDirs(String path) {

		// 1.创建File对象，表示这个目录

		File dir = new File(path);

		// 2.通过list方法得到所包含的所有子目录与子文件名称

		String[] names = dir.list(new DirFilter(".docx"));// 过滤得到docx文件名

		// 3显示这些名称

		for (int i = 0; i < names.length; i++) {

			System.out.println(names[i] + ":"
					+ new File(path + names[i]).isFile());// 获取文件夹、文件名，并判断是佛是文件，使用绝对路径

		}
	}
	
	// 文件名过滤器
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
		listAllFilesAndDirs("D:/三阳历史/");
	}
}
