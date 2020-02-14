/**
 * Zsuzsanna Dianovics
 * MainActivity.java
 * for Shipping Calculator
 */

package cs134.miracosta.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Class that represents the Controller of the Shipping Calculator
 */
public class MainActivity extends AppCompatActivity {


    /**
     * Instance Variables
     */
    private ShipItem currentItem;               //ShipItem object to ship
    private EditText amountEditText;            //Edit box for input of weight
    private TextView baseCostOut;               //Output of  base cost
    private TextView addedCostOut;              //Output of additional cost
    private TextView totalOut;                  //Output of total cost
    //number format for currency
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    /**
     * Sets up layour and content at start
     * @param savedInstanceState the instance of the bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //inflating

        //Connecting
        currentItem = new ShipItem();                               //creating new ShipItem object
        amountEditText = findViewById(R.id.amountEditText);         //finding edit test view
        baseCostOut = findViewById(R.id.baseCostOut);               //finding base cost out view
        addedCostOut = findViewById(R.id.addedCostOut);             //finding cost add view
        totalOut = findViewById(R.id.totalOut);                     //finding total view

        /**
         * Creating inner class to watch for text change in edit text
         */
        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            /**
             * onTextChanged -- watch for changes to the edit text window
             * @param s the characters entered
             * @param start  the start of the characters
             * @param before  length of string before
             * @param count  of characters
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //check if not empty string
                try
                {
                    //change the input string to integer
                    int weight = Integer.parseInt(amountEditText.getText().toString());
                    //call setWeight() on the currentItem
                    currentItem.setWeight(weight);
                    //wire up the views to the model
                    calcTotal();

                } catch (NumberFormatException e) { //catch empty string

                    //if no input, set to zero
                    currentItem.setWeight(0);
                    calcTotal();
                }
            } // end onTextChanged()

            @Override
            public void afterTextChanged(Editable s) { }
        }); // end TextWatcher

    } //end onCreate()

    /**
     * sends the changed currentItem attributes to the View
     */
    public void calcTotal()
    {
        //sets up Base cost view
        baseCostOut.setText(currency.format(currentItem.getBaseCost()));
        //sets up Added cost view
        addedCostOut.setText(currency.format(currentItem.getAddedCost()));
        //sets up Total out view
        totalOut.setText(currency.format(currentItem.getTotal()));
    } // end calcTotal()

} // end main
