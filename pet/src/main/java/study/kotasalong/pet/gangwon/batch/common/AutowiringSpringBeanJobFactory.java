/**
 * 0. Project  : ������ �� â�� ������Ʈ
 *
 * 1. FileName : AutowiringSpringBeanJobFactory.java
 * 2. Package : study.kotasalong.pet.gangwon.batch.common
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 8:24:23
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.batch.common;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * @FileName : AutowiringSpringBeanJobFactory.java
 * @Project : batch
 * @Date : 2017. 8. 27.
 * @�ۼ��� : yrseo
 * @�����̷� :
 * @���α׷� ���� : �� JobFactory�� spring @Autowired �������� ���� ���� �� quartz bean�� �ڵ����� autowire�Ѵ�.
 */

public final class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

	private transient AutowireCapableBeanFactory beanFactory;

	public void setApplicationContext(final ApplicationContext context) {
		beanFactory = context.getAutowireCapableBeanFactory();
	}

	@Override
	protected Object createJobInstance(final TriggerFiredBundle bundle) {
		final Object job = super.createJobInstance(bundle);
		beanFactory.autowireBean(job);
		return job;
	}
}
