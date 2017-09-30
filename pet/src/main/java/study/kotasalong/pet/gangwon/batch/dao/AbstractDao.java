/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : AbstractDao.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.dao
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 4:01:11
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/** 
* @FileName      : AbstractDao.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

public abstract class AbstractDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public void saveOrUpdate(Object entity){
    	getSession().saveOrUpdate(entity);
    }
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
    
    public void merge(Object entity) {
		getSession().merge(entity);

	}
}
