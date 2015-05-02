package stephenford.signalsfrommars.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import stephenford.signalsfrommars.R;                                                   //Importing of the Resource folder

/****************************************************************************************************************************/
/**                                                                                                                         */
/**                                       MainActivity  UI Class (Controller class)                                         */
/**                                                                                                                         */
/**                                          Created by Stephen Ford on 4/30/15.                                            */
/**                                                                                                                         */
/****************************************************************************************************************************/

public class MainActivity extends ActionBarActivity
{
 //local variable declaration
    private String instructions;                                                        //Variable for the string "instructions"
    private EditText mNameField;                                                        //TextField for the users name
    private ImageButton mImageButton;                                                   //Big Blue Button


    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                                          onCreate Method of MainActivity                                       */
    /**                                                                                                                */
    /*******************************************************************************************************************/
    //Local onCreate overrides Activity class onCreate but inherits all from parent
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Setting local variables to the objects created in the xml file activity_main
            mNameField = (EditText) findViewById(R.id.nameEditText);
            mImageButton = (ImageButton) findViewById(R.id.startImageButton);


            //Instructions
            instructions = getString(R.string.instructions);                            //Importing the instruction string from the strings resource folder
            Toast.makeText(MainActivity.this, instructions, Toast.LENGTH_LONG).show();  //remember to add .show() to make it visible!




            //setting font
            Typeface font = Typeface.createFromAsset(getAssets(),"SEASRN__.ttf");       //custom text insert
            TextView txt = (TextView) findViewById(R.id.nameEditText);                  //calling in the TextView
            txt.setTypeface(font);                                                      //setting font to the EditText field




            /*******************************************************************************************************************/
            /**                                                                                                                */
            /**                                   Anonymous Inner Class in Button listener                                     */
            /**                                                                                                                */
            /*******************************************************************************************************************/
            //onClickListener being added to the button
            mImageButton.setOnClickListener(new View.OnClickListener()                  //creating an anonymous inner class in the (new ...)
            {
                @Override
                public void onClick(View v)
                {
                    String name = mNameField.getText().toString();
                    startStory(name);                                                   //passing on the name variable to the startStory method below
                }
            });//Closing of anonymous inner class.

        }//Closing of onCreate



    /*******************************************************************************************************************/
    /**                                                                                                                */
    /**                         Second Activity link: startStory - Intent exporting name value                         */
    /**                                                                                                                */
    /*******************************************************************************************************************/
    //Second Page link activated by mImageButton click above.
    private void startStory(String name)                                                //name being passed into the method
    {
    //Intent for passing into another activity
        Intent nextPageIntent1 = new Intent(this,StoryActivity.class);
    //renaming value and putting the value name into method //key_name is a String in the string file
        nextPageIntent1.putExtra(getString(R.string.key_name), name);
        startActivity(nextPageIntent1);

    }//Closing of startStory


    //Refreshing the MainActivity.
    protected void onResume()
    {
        super.onResume();
        //mNameField.setText("");                                                         //removes previous name in TextField
    }

}//Closing of MainActivity
