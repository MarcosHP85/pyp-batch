package ar.nasa;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;


public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			Long msegundos = jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime();
			
			System.out.println("\t!!! Duración de la conexión:\t" + (msegundos/1000) + " seg.");
		}
	}
}
