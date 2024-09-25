
/**
 * 12 HOUR INTERNAL BRANCH
 * 
 * The ClockDisplay class implements a digital clock display for a
 * American-style 12 hour clock. The clock shows hours and minutes.
 * The internal range of the clock is 00:00 (midnight) to 11:59
 * In order to track AM or Pm, we will need additional Fields and logic
 * to handle the switch in meridian.(for my case I did not use fields, I used
 * if-else statements in the Update display method as well as local variables
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Sebastian Portillo
 * @Monday September 23rd
 *
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display. So over here I also added if else statements with a string variable
     * that determines whether to use am or pm. I've also made an if statement where if it reaches 12, then the next number/hour
     * that should be 13 be 1, this by "reversing" the clock or decrementing the value of 12 back to 1. The last if statement
     * states that if the clock hits midnight 00(in military time), it should turn into a 12. 
     */
    private void updateDisplay()
    {
        int hour = hours.getValue();
        String meridian;
        if (hour >= 12 ){
            meridian = "pm";
        }
        else {
            meridian = "am";
        }
        if(hour >= 12){
            hour -= 12;
        }
        if(hour == 0 ){
            hour = 12;
        }
        
        displayString = hour + ":" + 
                        minutes.getDisplayValue()+ meridian;
    }
}
