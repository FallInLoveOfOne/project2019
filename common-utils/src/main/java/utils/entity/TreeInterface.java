package utils.entity;

import java.io.Serializable;
import java.util.List;

public interface TreeInterface<T extends BaseTreeEntity<T, ID>, ID extends Serializable> {
	/**
	 * ���ָ���ڵ������й鵵
	 * 
	 * @param list
	 * @param parentId
	 * @return
	 */
	public List<T> getChildTreeObjects(List<T> list, ID parentId);

	/**
	 * �ݹ��б�
	 * 
	 * @param list
	 * @param t
	 */
	public void recursionFn(List<T> list, T t);

	/**
	 * ���ָ���ڵ��µ������ӽڵ�
	 * 
	 * @param list
	 * @param t
	 * @return
	 */
	public List<T> getChildList(List<T> list, T t);

	/**
	 * �ж��Ƿ�����һ���ӽڵ�
	 * 
	 * @param list
	 * @param t
	 * @return
	 */
	public boolean hasChild(List<T> list, T t);
}
