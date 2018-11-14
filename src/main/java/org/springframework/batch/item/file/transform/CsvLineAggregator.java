package org.springframework.batch.item.file.transform;

import java.util.Date;


public class CsvLineAggregator<T> extends ExtractorLineAggregator<T> {

	private String delimiter = ",";
	
	/**
	 * Public setter for the locale.
	 * @param locale the locale to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	@Override
	protected String doAggregate(Object[] fields) {
		
		String value = "";
		
		for (Object field : fields) {
			
			if (field instanceof Date) {
				
				value = value + String.format("%1$Td/%<Tm/%<TY %<TT", field);
				
			} else if (field instanceof String) {
				
				String text = (String) field;
				
				if (!text.isEmpty()
						&& (text.indexOf("\n") != -1 || text.indexOf("\r") != -1 || text.indexOf(delimiter) != -1)) {
					text = "\"" + text.replace("\"", "\"\"") + "\""; 
				}
				
				value = value + text;
				
			} else {
				
				value = value + field;
				
			}
			
			value = value + delimiter;
		}
		
		return value.substring(0, value.length() - 1);
	}

}
