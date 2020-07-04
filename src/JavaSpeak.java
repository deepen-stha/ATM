import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class JavaSpeak {
	
	VoiceManager freeVM;
	static Voice voice;
	
	    public void Speak(String speak) 
	    { 
	  
	    	System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	        voice = VoiceManager.getInstance().getVoice("kevin16");
	        if (voice != null) {
	            voice.allocate();// Allocating Voice
	            try {
	            	voice.setRate(160);// Setting the rate or speed of the voice
	                voice.setPitch(90);// Setting the Pitch of the voice
	                voice.setVolume(5);// Setting the volume of the voice
	                voice.speak(speak);//making it speak

	            } catch (Exception e1) {
	                e1.printStackTrace();
	            }

	        } else {
	            throw new IllegalStateException("Cannot find voice: kevin16");
	        }
 
	    }	    
}

