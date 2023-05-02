package test_app.qsep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssessmentQuestionaaireHelper {
//	public static final String SHIV = "Shiv";
//	public static final String SHE = "SHE";
	
	public static final String SA = "SA";
	public static final String SHE = "SHE";
	public static final String EHLR = "EHLR";

	public static void main(String[] args) {
		
		
			
		System.out.println(assessmentQuestStringOperation(new StringBuilder(getAssessmentQuestionaaireData())));
//		while (hasNext) {
//			
//			int index = text.indexOf(":");
//			if (index >= 2) {
//				StringBuilder sb = new StringBuilder();
//				for(int i =index-1; i >= startIndex; i--) {
//					sb.append(text.charAt(i));
//					if(text.charAt(i) == 32) {
//						break;
//					}
//				}
//				if(delimiters.contains(sb.reverse().toString())) {
//					startIndex = index;
//					System.out.println(sb + " :: " + index);
//				}
//				
//				if(startIndex < endIndex) {
//					
//				}
//				//sb.reverse();
//			}
//			hasNext = false;
//		}
		//System.out.println(text.indexOf("Shiv:"));
		
		
		
	}
	
	
	public static Map<String, StringBuilder> assessmentQuestStringOperation(StringBuilder text) {
		
		int startIndex = 0;
		//StringBuilder text = new StringBuilder("Shiv: My name : shiv. SHE: My name is XYZ, Shiv: How are you?");
//		StringBuilder text = new StringBuilder(getAssessmentQuestionaaireData());
		String _key = null;
		
//		List<String> delimiters = Arrays.asList(SHIV,SHE);
		List<String> delimiters = Arrays.asList(SA,SHE, EHLR);
		Map<String, StringBuilder> delimiterMap = new HashMap<>(delimiters.size());
		delimiterMap.put(SA, new StringBuilder());
		delimiterMap.put(SHE, new StringBuilder());
		delimiterMap.put(EHLR, new StringBuilder());
		
		
		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == ':' && i >= 1) {
				StringBuilder sb = new StringBuilder();
				int indexForDelete = 0;
				for (int j = i - 1; j >= startIndex; j--) {
					
					if (text.charAt(j) == 32 || delimiterMap.containsKey(new StringBuilder(sb).reverse().toString())) {
						break;
					}
					indexForDelete = j;
					sb.append(text.charAt(j));
				}
				String key = sb.reverse().toString();

				//System.out.println("key ############### : " + key + "----");
				if(delimiters.contains(key)) {
					startIndex = i;
				//	System.out.println(sb + " :: " + i);
					if(delimiterMap != null && delimiterMap.containsKey(_key) ) {
						delimiterMap.get(_key).delete(delimiterMap.get(_key).length() - (i-indexForDelete), delimiterMap.get(_key).length());
					}
					_key = key;
					continue;
				}
			}
			
			if(_key != null) {
				delimiterMap.get(_key).append(text.charAt(i));
			}
		}
		return delimiterMap;
	}
	
	public static String getAssessmentQuestionaaireData() {
		return "EN Device Evaluation Assessment - SA:When was the device received? If serviced in the field, when did you arrive at the site? Use explanation to open the field to enter the date.\r\n"
				+ "Depot Receipt Date:\r\n"
				+ "\r\n"
				+ "Field Service Start Date:\r\n"
				+ "\r\n"
				+ "List the asset’s Depot receipt date or date of Field Service arrival at the customer site. \r\n"
				+ ": Explanation\r\n"
				+ "Asset number 3553199 was received by Baxter Tampa Bay on 04/12/2023.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "SA:What is the software version of the device? Use explanation field to document software version.\r\n"
				+ ": Explanation\r\n"
				+ "Software version prior to service:  Version 9.02.00.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "EHLR:Did review of the customer device log reveal evidence of the customer reported problem(s)? Document the findings from the log review and attach the log to the Service Report if possible. For vague reported issues record details of problems that happened on the occurrence date.\r\n"
				+ ": Yes-Explanation\r\n"
				+ "The reported issue of “Erroneous air in line” was verified in the device logs.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "SHE: Was the device serviced within the past 12 months for the same customer reported problem(s)? Review prior Depot or Field Service Requests for the asset within the past 12 months. Document if the asset was previously serviced for the same customer problem and how the prior service data was used to help resolve the current customer issue.\r\n"
				+ ": No service in 12 months\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "SA:What evaluation methods were used to assess the asset for the customer issues?  What was found? List the device evaluation tests, inspections and troubleshooting performed with dates. List whether customer reported issue(s) were duplicated, were verified by physical, electrical, or mechanical checks, or if issue(s) were not confirmed.\r\n"
				+ ": Duplicated-Explanation\r\n"
				+ "On 04/27/2023, the reported issue of “Erroneous air in line” was confirmed when trying to start an infusion. Evaluation per SWI 105 found that the upstream lower calibration value was low. Calibration of the ultrasonic sensor failed. The Ultrasonic Sensor will be replaced.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "Upstream Cal Values:\r\n"
				+ "Upper: 3323\r\n"
				+ "Lower: 131\r\n"
				+ "Calibration failed. Replace Ultrasonic Sensor\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "Downstream Cal Values:\r\n"
				+ "Digital Pot: 180\r\n"
				+ "Current Reading: 844\r\n"
				+ "Calibrate Force Sensor.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "Color Sensor calibration values:\r\n"
				+ "With Clamp\r\n"
				+ "Red: 11369\r\n"
				+ "Green: 7391\r\n"
				+ "Blue: 12047\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "Without Clamp\r\n"
				+ "Red: 22173\r\n"
				+ "Green: 7855\r\n"
				+ "Blue: 10428\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "Optical Sensor Values:\r\n"
				+ "Min: +0%\r\n"
				+ "Max: +0%\r\n"
				+ "Current: +0%\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "On 04/27/2023, IDEA Testing found no problems. No accessories were included.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "On 04/27/2023, Visual inspection Per ITP 35022-CFG3-SVC found:\r\n"
				+ "-    Loose Downstream Tubing Guide\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "SA:Was the cause of the customer reported issues found?  If so, what are the actions to resolve? List the potential assignable cause of the reported problem(s) and the steps to resolve the issue(s) found. List actions to correct new DVAD-Yes/Analyze problems found in evaluation. \r\n"
				+ ": Yes-Explanation\r\n"
				+ "The cause of the reported issue of “Erroneous air in line” was determined to be a defective Ultrasonic Sensor. The Ultrasonic Sensor will be replaced. Process per INF 01143-CFG3-SVC.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "*****Created from Source System on 14-Feb-2023 11:26 PM GMT+00:00 *****\r\n"
				+ "EN General Complaint – Fluid Systems - During what step of the process did the event occur? If Other select Other-Explanation and list information\r\n"
				+ ": Unknown\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Was the patient involved? If Yes was the Patient Connected? If the patient was connected select Yes-Explanation and state whether therapy was stopped or delayed, and capture how long. \r\n"
				+ ": No\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Was there patient/user injury, medical intervention, symptom or adverse event reported? If Yes select Yes-Explanation and list: symptom/outcome, intervention, patient/user identifiers, drugs or biologics name/product code/lot.\r\n"
				+ ": No\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Was this event already communicated to any other Baxter department or authority?” If Yes - select Yes - Explanation and identify who was notified.\r\n"
				+ ": No\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Were additional products (i.e. sets, medications etc.) being used at the time of the event? If Yes select Yes-Explanation and list: product name, product code, lot/serial number.\r\n"
				+ ": No\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "For accuracy issues: provide the expected and actual infusion time, volume and flow rate Select Explanation and provide details; otherwise select N/A if not applicable.\r\n"
				+ ": N/A\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Department where reported event occurred? If Other select Other-Explanation list information provided \r\n"
				+ ": Unknown\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Was product requested to be sent to Baxter? Use Other-Explanation to indicate third party service provider or any other location/device status\r\n"
				+ ": Yes Return to Baxter";
	}

}
