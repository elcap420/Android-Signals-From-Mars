package stephenford.signalsfrommars.ui;
//Java code for the activity_story xml


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import stephenford.signalsfrommars.R;
import stephenford.signalsfrommars.model.Page;
import stephenford.signalsfrommars.model.Story;



/****************************************************************************************************************************/
/**                                                                                                                         */
/**                                       StoryActivity UI Class (Controller class)                                         */
/**                                                                                                                         */
/**                                          Created by Stephen Ford on 4/30/15.                                            */
/**                                                                                                                         */
/****************************************************************************************************************************/

//Main method StoryActivity for the first page
public class StoryActivity extends ActionBarActivity
{


        public static final String TAG = StoryActivity.class.getSimpleName();   //used for Logging info about this class

        //Member variables
        private ImageView mImageView;                                           //Image
        private TextView mTextView;                                             //Story text
        private Button mChoice1;                                                //Upper Button
        private Button mChoice2;                                                //Lower Button
        private String mName;                                                   //Users Name
        private String mFinalButton;                                            //Final page button text

        private Story mStory = new Story();                                     //Declaring local member variable for the Story.
        private Page mCurrentPage;                                              //Local member variable for retrieving current page.

    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                                         onCreate Method of StoryActivity                                       */
    /**                                                                                                                */
    /*******************************************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();                                            //Getting intent from the MainActivity class
        mName = intent.getStringExtra(getString(R.string.key_name));            //key_name is a String in the string file

        if(mName.matches(""))                                                   //if there is no name given Jackson will be used by default
        {
            mName = "Michael Jackson";                                          //perhaps add random generator to give a few more names
        }

        //Toast.makeText(StoryActivity.this, mName, Toast.LENGTH_LONG).show();//TEST
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView2);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);                                                            //takes the user to the opening page
    }//Closing onCreate



    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                                         loadPage Method of StoryActivity                                       */
    /**                                                                                                                */
    /*******************************************************************************************************************/
    //Method to load next page
    private void loadPage(int choice)
    {
        //Sets to page 0
        mCurrentPage = mStory.getPage(choice);

        //Calls the image that belongs with the page requested above
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), mCurrentPage.getImageId(), null);
        mImageView.setImageDrawable(drawable);

        //Adding of mName variable ie : Users entry in the textView
        String pageText = mCurrentPage.getText();                                //Local variable pageText being declared
        pageText = String.format(pageText, mName);                               //This calls the name parameter into the text via the coding in the text. See string.xml
        //Toast.makeText(StoryActivity.this, mName, Toast.LENGTH_LONG).show();//TEST
        mTextView.setText(pageText);                                             //setting text to the page with the name added




        //Setting choices

        if(mCurrentPage.isFinal())                                               //if final page use second constructor
        {
            mChoice1.setVisibility(View.INVISIBLE);
            mFinalButton = getText(R.string.restart).toString();
            mChoice2.setText(mFinalButton);
            mChoice2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    finish();                                                   //ends the activity and therefore returns to the MainActivity
                }
            });
        }

        else
        {
            mChoice1.setText(mCurrentPage.getChoice1().getText());              //loading of the text for the choice via the current page.
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });

        }//Closing of else block

    }//Closing of loadPage

}//Closing storyActivity
