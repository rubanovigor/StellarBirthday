package com.example.stellarbirthday;

import java.util.Arrays;

/** class to initialize StarName's/Distances and calculate birthday Star*/
public class Stellar {
//	public static float[][] DistanceInDays= new float[3][3];
	public static int NumberOfStars = 19;
	public static float[] DistanceInDays= new float[NumberOfStars];
	public static String[] StarNames= new String[NumberOfStars];
	public static String[] StarInfo= new String[NumberOfStars];
	public static int index = 0;
	public static float DaysToStellarBirthday = 0;
	
    /** create 2D array with StarName's and Distance in light years, days */
    static void iniStarsArray() {  
//    	DistanceInDays[0][0] = 1f; DistanceInDays[0][1] = 4.0f;	 StarNames[0] = "Toliman";
//    	DistanceInDays[1][0] = 2f; DistanceInDays[1][1] = 6.0f;	 StarNames[1] = "Vega";
//    	DistanceInDays[2][0] = 2f; DistanceInDays[2][1] = 10.0f; StarNames[2] = "Sirius";
    	DistanceInDays[0] = 0f;	 	 StarNames[0] = "Earth";     	StarInfo[0] = "home planet";
    	DistanceInDays[1] = 1604f;	 StarNames[1] = "Alpha Centauri";		StarInfo[1] = "Alpha Centauri is the sun's closest neighbor";
    	DistanceInDays[2] = 3139f;	 StarNames[2] = "Sirius";		StarInfo[2] = "Sirius is the brightest star in the Earth's night sky";
    	DistanceInDays[3] = 4183f;   StarNames[3] = "Procyon";		StarInfo[3] = "Procyon is a hound belonging to Erigone, daughter of Icarius";
    	DistanceInDays[4] = 6105f;	 StarNames[4] = "Altair";		StarInfo[4] = "Altair is an abbreviation of the Arabic phrase an-nasr - the 'flying eagle'";
    	DistanceInDays[5] = 9140f;	 StarNames[5] = "Vega";			StarInfo[5] = "When you look at Vega, you look in the motion direction of the solar system";
    	DistanceInDays[6] = 9169f;   StarNames[6] = "Fomalhaut";	StarInfo[6] = "Ptolemy put Fomalhaut in Aquarius";
    	DistanceInDays[7] = 12329f;	 StarNames[7] = "Pollux";		StarInfo[7] = "Pollux is twin brother of Castor";
    	DistanceInDays[8] = 13093f;	 StarNames[8] = "Denebola";		StarInfo[8] = "Denebola is shortened from ðanab al-asad 'tail of the lion'";
    	DistanceInDays[9] = 13399f;  StarNames[9] = "Arcturus";		StarInfo[9] = "Arcturus is the brightest star in the northern celestial hemisphere";
    	DistanceInDays[10] = 15620f; StarNames[10] = "Capella";		StarInfo[10] = "In Hindu mythology, Capella was seen as the heart of Brahma";
    	DistanceInDays[11] = 17731f; StarNames[11] = "Rasalhague";	StarInfo[11] = "The spectrum of Alpha Ophiuchi has an anomalously high level of  singly-ionized calcium";
    	DistanceInDays[12] = 17899f; StarNames[12] = "Alderamin";	StarInfo[12] = "Alderamin, an Arabic name meaning 'the right arm'";
    	DistanceInDays[13] = 18563f; StarNames[13] = "Castor";		StarInfo[13] = "Castor is twin brother of Pollux";
    	DistanceInDays[14] = 19978f; StarNames[14] = "Caph";		StarInfo[14] = "Caph is β Cassiopeiae";
    	DistanceInDays[15] = 24017f; StarNames[15] = "Hamal";		StarInfo[15] = "Hamal declination is almost exactly equal to the latitude of the Tropic of Cancer";
    	DistanceInDays[16] = 24321f; StarNames[16] = "Aldebaran";	StarInfo[16] = "The name Aldebaran is Arabic and translates literally as 'the follower'";
    	DistanceInDays[17] = 26990f; StarNames[17] = "Unukalhai";	StarInfo[17] = "This star is radiating about 38 times the luminosity of the Sun";
    	DistanceInDays[18] = 27388f; StarNames[18] = "Alphekka";	StarInfo[18] = "The name Alphecca is Arabic, short for 'the bright of the broken'";
     	
    	
    }
    
    /** get birthday StarName based on "days old" */
    static String getStellarBirthdayStarName(long DaysOld) {
    	int LocalIndex;

//    	Arrays.sort(DistanceInDays);
//    	LocalIndex = Arrays.binarySearch(DistanceInDays, DaysOld);
    	int i=0;
	    do{
	    	if(i == NumberOfStars-1){
	    		if(DaysOld == DistanceInDays[i]){
		        	index = i;
		        	i=NumberOfStars;
		        	DaysToStellarBirthday = 0;
		        	return StarNames[index];
		        }else {
		        	DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
		        	i=NumberOfStars;
		        	return "";
		        }
		        	
	    	}else{
		        if(DaysOld == DistanceInDays[i]){
		        	index = i;
		        	i=NumberOfStars;
		        	DaysToStellarBirthday = 0;
		        }else
		        	if(DaysOld > DistanceInDays[i] && DaysOld < DistanceInDays[i+1]){
		        		index = i+1;
		        		i=NumberOfStars;
		        		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
		        	} else i++;

	    	}
	        
	        
	    } while(i<NumberOfStars); 
	    return StarNames[index];
	    
//	    return StarNames[index];

    	// -- exact match
//	  	if (LocalIndex>=0){
//		  		index = LocalIndex; DaysToStellarBirthday = DistanceInDays[index] - DaysOld;	
//		  		if(index<NumberOfStars-1){
//		  			index = index + 1;
//		  			endOfStarsList = false;
//			  		return StarNames[index-1];
//		  		}else{  
//			  		if(DistanceInDays[NumberOfStars-1]<DaysOld){endOfStarsList = true;}
//			  		else{	endOfStarsList = false;}
//			  		
//			  		return StarNames[index];
//		  		}
//		  				  			
//
//	  	}else{	  
//	  		if(DistanceInDays[NumberOfStars-1]<DaysOld){endOfStarsList = true;
//	  		}else{	endOfStarsList = false;}
//	  		
//		  	if (index>0 && (DistanceInDays[index-1] - DaysOld)>0){
//		  		index = index-1;
//		  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
//		  		return StarNames[index];
//		  	}else{
//		  		DaysToStellarBirthday = DistanceInDays[index] - DaysOld;
//		  		return StarNames[index];
//		  	}	
//
//	  	} 
	  	
	  	
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
	  
    	
//        return "Toliman";
//    	if (LocalIndex>=0){
//    		return StarNames[index];
//    	} else
//    		return "";
    }
}
