package utils.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeService<T extends BaseTreeEntity<T, ID>, ID extends Serializable>
		implements TreeInterface<T, ID> {
	
	
	public List<T> getChildTreeObjects(List<T> list, ID parentId) {
		List<T> returnList = new ArrayList<T>();
		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			T res = (T) iterator.next();
			/**
			 * �жϵ�һ�������Ƿ�Ϊ��һ���ڵ�
			 * 
			 */
			if (res.getParentId() == parentId) {
				/**
				 * ���--˵����һ���ڵ�Ϊ���ڵ�--�ݹ�������ӽڵ�
				 */
				recursionFn(list, res);
				returnList.add(res);
			}
		}
		return returnList;
	}

	/**
	 * �ݹ��б�
	 * 
	 * @param list
	 * @param t
	 */
	public void recursionFn(List<T> list, T t) {
		List<T> childsList = getChildList(list, t);
		/**
		 * ���������Ӽ�����
		 */
		t.setChildsList(childsList);
		/**
		 * ����--��Щ�Ӽ��Ķ���--ʱ������һ�����Ӽ�����
		 */
		for (T nextChild : childsList) {
			/**
			 * ��һ�����������е���Դ�������ж�
			 */
			if (hasChild(list, nextChild)) {
				/**
				 * ����һ���ӽڵ�,�ݹ�
				 */
				Iterator<T> it = childsList.iterator();
				while (it.hasNext()) {
					T node = it.next();
					/**
					 * ���еĶ���--����ǰ���childsList �Ķ����ӽڵ�
					 */
					recursionFn(list, node);
				}
			}
		}
	}

	/**
	 * ���ָ���ڵ��µ������ӽڵ�
	 * 
	 * @param list
	 * @param t
	 * @return
	 */
	public List<T> getChildList(List<T> list, T t) {
		List<T> childsList = new ArrayList<T>();
		Iterator<T> it = list.iterator();
		while (it.hasNext()) {
			T child = it.next();
			/**
			 * �жϼ��ϵĸ�ID�Ƿ������һ����id
			 */
			if (((BaseTreeEntity<T, ID>) child).getParentId() == ((BaseTreeEntity<T, ID>) t).getId()) {
				childsList.add(child);
			}
		}
		return childsList;
	}

	/**
	 * �ж��Ƿ�����һ���ӽڵ�
	 * 
	 * @param list
	 * @param t
	 * @return
	 */
	public boolean hasChild(List<T> list, T t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
	
	public static void main(String[] args) {
		List<TreeBean> list = new ArrayList<TreeBean>();
		TreeBean bean = null;
		for(int i=10;i>=0;i--){
			bean = new TreeBean();
			bean.setId(i+"");
			bean.setPid(i-1+"");
			bean.setText(i+"bean");
			list.add(bean);
		}
	}
}
