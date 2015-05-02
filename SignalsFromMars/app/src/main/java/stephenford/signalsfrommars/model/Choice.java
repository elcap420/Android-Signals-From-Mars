package stephenford.signalsfrommars.model;


/****************************************************************************************************************************/
/**                                                                                                                         */
/**                                                 Choice Model Class                                                      */
/**                                                                                                                         */
/**                                         Created by Stephen Ford on 4/30/15.                                             */
/**                                                                                                                         */
/****************************************************************************************************************************/

public class Choice
{
    private String mText;                               //Button Text
    private int mNextPage;

    public Choice(String text, int nextPage)
    {
       mText = text;
       mNextPage = nextPage;
    }



    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                                      Getters and Setters for Choice Class                                      */
    /**                                                                                                                */
    /*******************************************************************************************************************/
    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        this.mNextPage = nextPage;
    }
}
