/**
 * 0. Project  : ���� �� â�� ������Ʈ
 *
 * 1. FileName : QuartzConfiguration.java
 * 2. Package : study.kotasalong.pet.gangwon.configuration
 * 3. Comment : 
 * 4. �ۼ���  : yrseo
 * 5. �ۼ���  : 2017. 8. 27. ���� 5:15:17
 * 6. �����̷� : 
 *                    �̸�     : ����          : �ٰ��ڷ�   : ���泻��
 *                   ------------------------------------------------------
 *                    yrseo : 2017. 8. 27. :            : �ű� ����.
 */
package study.kotasalong.pet.gangwon.configuration;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import study.kotasalong.pet.gangwon.batch.common.AutowiringSpringBeanJobFactory;

/** 
* @FileName      : QuartzConfiguration.java 
* @Project     : batch 
* @Date        : 2017. 8. 27. 
* @�ۼ���          : yrseo 
* @�����̷�     : 
* @���α׷� ����     : 
*/

@Configuration
@ComponentScan({ "study.kotasalong.pet.gangwon" })
public class QuartzConfiguration {
    @SuppressWarnings("unused")
	@Autowired
    private Environment environment;
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public MethodInvokingJobDetailFactoryBean AnimalPharmacyBatchJobMethodJobDetail() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("AnimalPharmacyBatchJob");
		obj.setTargetMethod("animalPharmacyBatchStart");
		return obj;
	}
	//Job  is scheduled for 3+1 times with the interval of 30 seconds
	@Bean
	public SimpleTriggerFactoryBean AnimalPharmacyBatchJobTrigger(){
		SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
		stFactory.setJobDetail((JobDetail) AnimalPharmacyBatchJobMethodJobDetail().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setRepeatInterval(43200000);
		stFactory.setRepeatCount(1);
		return stFactory;
	}

	@Bean
	public MethodInvokingJobDetailFactoryBean AnimalClinicBatchJobMethodJobDetail() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("AnimalClinicBatchJob");
		obj.setTargetMethod("animalClinicBatchStart");
		return obj;
	}
	//Job  is scheduled for 3+1 times with the interval of 30 seconds
	@Bean
	public SimpleTriggerFactoryBean AnimalClinicBatchJobTrigger(){
		SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
		stFactory.setJobDetail((JobDetail) AnimalClinicBatchJobMethodJobDetail().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setRepeatInterval(43200000);
		stFactory.setRepeatCount(1);
		return stFactory;
	}
	/*
	@Bean
	public JobDetailFactoryBean AnimalPharmacyBatchJobJobDetail(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(AnimalPharmacyBatchJob.class);
		factory.setDurability(true);
		factory.setGroup("BatchJob");
		factory.setName("AnimalPharmacyBatchJob");
		return factory;
	}
	//Job is scheduled after every 1 minute 
	@Bean
	public CronTriggerFactoryBean AnimalPharmacyBatchJobCron(){
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(AnimalPharmacyBatchJobJobDetail().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("Trigger");
		stFactory.setGroup("BatchJob");
		stFactory.setCronExpression("0 0 1 * * ?");
		return stFactory;
	}

	@Bean
	public JobDetailFactoryBean AnimalClinicBatchJobJobDetail(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(AnimalClinicBatchJob.class);
		factory.setDurability(true);
		factory.setGroup("BatchJob");
		factory.setName("AnimalClinicBatchJob");
		return factory;
	}
	//Job is scheduled after every 1 minute 
	@Bean
	public CronTriggerFactoryBean AnimalClinicBatchJobCron(){
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(AnimalClinicBatchJobJobDetail().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("Trigger");
		stFactory.setGroup("BatchJob");
		stFactory.setCronExpression("0 0 1 * * ?");
		return stFactory;
	}
	*/
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		//scheduler.setTriggers(new Trigger[]{AnimalPharmacyBatchJobCron().getObject(), AnimalPharmacyBatchJobTrigger().getObject()});
		scheduler.setTriggers(new Trigger[]{AnimalPharmacyBatchJobTrigger().getObject(), AnimalClinicBatchJobTrigger().getObject()});
		//scheduler.setTriggers(new Trigger[]{AnimalClinicBatchJobCron().getObject(), AnimalPharmacyBatchJobCron().getObject()});
		// custom job factory of spring with DI support for @Autowired!
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		scheduler.setJobFactory(jobFactory);
		return scheduler;
	}
}
