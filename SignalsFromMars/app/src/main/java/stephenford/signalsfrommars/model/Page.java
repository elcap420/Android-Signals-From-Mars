package stephenford.signalsfrommars.model;

/****************************************************************************************************************************/
/**                                                                                                                         */
/**                                                   Page Model Class                                                      */
/**                                                                                                                         */
/**                                          Created by Stephen Ford on 4/30/15.                                            */
/**                                                                                                                         */
/****************************************************************************************************************************/
public class Page
{




    //Declarations of (m)ember variables
    private int mImageId;
    private String mText;
    private Choice mChoice1;                                            //Choice is an import from Model folder class Choice
    private Choice mChoice2;
    private boolean mIsFinal;


    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                                      Constructors for Choice Class                                      */
    /**                                                                                                                */
    /*******************************************************************************************************************/

    //Constructor for all the pages with options for continuation
    public Page(int imageId, String text, Choice choice1, Choice choice2)
    {
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
        mIsFinal = false;
    }

    public boolean isFinal()
    {
        return mIsFinal;
    }

    //Constructor for final pages without further choices
    public Page(int imageId, String text)
    {
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }






    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                                      Getters and Setters for Choice Class                                      */
    /**                                                                                                                */
    /*******************************************************************************************************************/

        //Getters......................................
        public int getImageId() {
            return mImageId;
        }

        public String getText() {
            return mText;
        }

        public Choice getChoice1() {
            return mChoice1;
        }

        public Choice getChoice2() {
            return mChoice2;
        }

        public boolean getIsFinal() {
            return mIsFinal;
        }

        //Setters......................................
        public void setImageId(int mImageId) {
            this.mImageId = mImageId;
        }

        public void setText(String mText) {
            this.mText = mText;
        }

        public void setChoice1(Choice mChoice1) {
            this.mChoice1 = mChoice1;
        }

        public void setChoice2(Choice mChoice2) {
            this.mChoice2 = mChoice2;
        }

        public void setFinal(boolean isFinal) {
            mIsFinal = isFinal;
        }

}//Closing of Page class
