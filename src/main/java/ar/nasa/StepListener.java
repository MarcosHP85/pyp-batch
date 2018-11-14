package ar.nasa;

import java.io.File;
import java.io.IOException;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Value;

public class StepListener implements StepExecutionListener {
	
	@Value("${out}")
	private String out;
	
	@Override
	public ExitStatus afterStep(StepExecution step) {
		System.out.println();
		System.out.println("\t!!! OT's exportadas:\t\t"  + step.getWriteCount());
		
		return step.getExitStatus();
	}

	@Override
	public void beforeStep(StepExecution step) {
		File file = new File(out);
		
		if (file.exists())
			while (!file.renameTo(file)) {
				System.out.println();
				System.out.println("================================================================================");
				System.out.println("\t!!! Cierre el archivo: \"" + out + "\"");
				System.out.println();
				System.out.println("\ty presione Enter para continuar...");
				
				try {
					while (System.in.read() != 13) {
					}
				} catch (IOException e) {}
				System.out.println("================================================================================");
				System.out.println();
			}
		
		System.out.println();
		System.out.println("================================================================================");
		System.out.println("\tBajando datos desde IFS, espere...");
	}

}
