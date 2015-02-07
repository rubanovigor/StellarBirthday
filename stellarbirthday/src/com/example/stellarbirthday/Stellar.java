package com.example.stellarbirthday;

import java.util.Arrays;

/** class to initialize StarName's/Distances and calculate birthday Star*/
public class Stellar {
//	public static float[][] DistanceInDays= new float[3][3];
	public static int NumberOfStars = 3;
	public static float[] DistanceInDays= new float[NumberOfStars];
	public static String[] StarNames= new String[NumberOfStars];
	public static int index = 0;
//	public static int indexOld = -1;
	public static float DaysToStellarBirthday = 0;
	public static boolean endOfStarsList=false;
	
    /** create 2D array with StarName's and Distance in light years, days */
    static void iniStarsArray() {
//    	DistanceInDays[0][0] = 1f; DistanceInDays[0][1] = 4.0f;	 StarNames[0] = "Toliman";
//    	DistanceInDays[1][0] = 2f; DistanceInDays[1][1] = 6.0f;	 StarNames[1] = "Vega";
//    	DistanceInDays[2][0] = 2f; DistanceInDays[2][1] = 10.0f; StarNames[2] = "Sirius";
    	DistanceInDays[0] = 4.0f;	 StarNames[0] = "Toliman";
    	DistanceInDays[1] = 6.0f;	 StarNames[1] = "Vega";
    	DistanceInDays[2] = 10.0f;   StarNames[2] = "Sirius";
    }
    
    /** get birthday StarName based on "days old" */
    static String getStellarBirthdayStarName(long DaysOld) {
    	int LocalIndex;

    	Arrays.sort(DistanceInDays);
    	LocalIndex = Arrays.binarySearch(DistanceInDays, DaysOld);

    	// -- exact match
	  	if (LocalIndex>=0){
		  		index = LocalIndex; DaysToStellarBirthday = DistanceInDays[index] - DaysOld;	
		  		if(index<NumberOfStars-1){
		  			index = index + 1;
		  			endOfStarsList = false;
			  		return StarNames[index-1];
		  		}else{  
			  		if(DistanceInDays[NumberOfStars-1]<DaysOld){endOfStarsList = true;}
			  		else{	endOfStarsList = false;}
			  		
			  		return StarNames[index];
		  		}
		  				  			

	  	}else{	  
	  		if(DistanceInDays[NumberOfStars-1]<DaysOld){endOfStarsList = true;
	  		}else{	endOfStarsList = false;}
	  		
		  	if (index>0 && (DistanceInDays[index-1] - DaysOld)>0){
		  		index = index-1;
		  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
		  		return StarNames[index];
		  	}else{
		  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
		  		return StarNames[index];
		  	}	

	  	} 
	  	
	  	
//	  	// -- no exact match, taking closest star
//	  	if (LocalIndex<0 && index<NumberOfStars-1){
//	  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
//	  		return StarNames[index];
//	  	}	  	
//	  	// -- if end of the Stars list reached
//	  		// -- going to the history
//	  	if (LocalIndex<0 && index==NumberOfStars-1 && (DaysOld - DistanceInDays[index])>0){
//	  		DaysToStellarBirthday = -2;
//	  		return StarNames[index];
//	  	}
//	  		// -- going to the present
//	  	if (LocalIndex<0 && index==NumberOfStars-1 && (DaysOld - DistanceInDays[index])<0 ){
//	  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
//	  		return StarNames[index];
//	  	}
	  		// -- not born yet
//	  	if (LocalIndex<0 && DaysOld<0){
//	  		index = 0;
//	  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
//	  		return StarNames[index];
//	  	}
	  	
//    	public int find(double[] array, double value) {
//    	    for(int i=0; i<array.length; i++) 
//    	         if(array[i] == value)
//    	             return i;
//    	}
    	
//        return "Toliman";
//    	if (LocalIndex>=0){
//    		return StarNames[index];
//    	} else
//    		return "";
    }
}
