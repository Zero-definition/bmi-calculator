package org.example.bmi_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.util.Objects;

public class BMIController {

    @FXML
    private TextField WeightInput;
    @FXML
    private TextField HeightInput;

    @FXML
    private ChoiceBox<String> WeightUnits;

    @FXML
    private ChoiceBox<String> HeightUnits;

    @FXML
    private TextField Output;


    @FXML
    protected void onCalculateButtonClick() {

        try {
            BMIController bmiController = new BMIController();

            float h = Float.parseFloat(this.getValue(HeightInput));
            float w = Float.parseFloat(this.getValue(WeightInput));

            String wu = WeightUnits.getValue();
            String hu = HeightUnits.getValue();

            w = bmiController.adjustWeight(w, wu);
            h = bmiController.adjustHeight(h, hu);

            Output.setText(CalculateingBMI(h, w));
        }
        catch (Exception e1)
        {
            Output.setText("Invalid Input");
        }
    }


    @FXML
    private final String getValue(TextField a)
    {
        String value= a.getText();

        return(value);
    }


    public final float adjustWeight(float w,String wu)
    {
        if(Objects.equals(wu, "g"))
        {
            return (w/1000);
        }
        return(w);

    }

    public final float adjustHeight(float h,String hu)
    {
        if(Objects.equals(hu, "in"))
        {
            return (h*2.54f);
        }
        return(h);
    }


    public final String CalculateingBMI(float h,float w)
    {
        return(Float.toString((10000*w)/(h*h)));
    }

}