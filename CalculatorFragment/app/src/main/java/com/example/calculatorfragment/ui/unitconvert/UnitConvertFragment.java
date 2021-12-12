package com.example.calculatorfragment.ui.unitconvert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatorfragment.R;
import com.example.calculatorfragment.databinding.FragmentUnitconvertBinding;

public class UnitConvertFragment extends Fragment implements View.OnClickListener{

    private FragmentUnitconvertBinding binding;

    String[] weightItems = { "Kilogram", "Pound", "Ounce"};
    Double[] weightBase = {1.0,2.20462,35.27396195};
    Spinner spinner1;
    Spinner spinner2;
    EditText editTextNumber;
    TextView txtResult;

    String[] lengthItems = { "Metre", "Mile", "Inch"};
    Double[] lengthBase = {1.0,0.000621,39.37};
    Spinner spinner3;
    Spinner spinner4;
    EditText editTextNumber2;
    TextView txtResult2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_unitconvert, container, false);
        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);
        editTextNumber = view.findViewById(R.id.editTextNumber);
        txtResult = view.findViewById(R.id.txtResult);
        view.findViewById(R.id.button).setOnClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, weightItems);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner3 = view.findViewById(R.id.spinner3);
        spinner4 = view.findViewById(R.id.spinner4);
        editTextNumber2 = view.findViewById(R.id.editTextNumber2);
        txtResult2 = view.findViewById(R.id.txtResult2);
        view.findViewById(R.id.button_2).setOnClickListener(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, lengthItems);
        spinner3.setAdapter(adapter2);
        spinner4.setAdapter(adapter2);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            String txtNumber = editTextNumber.getText().toString();

            int index1 = spinner1.getSelectedItemPosition();
            int index2 = spinner2.getSelectedItemPosition();
            try {
                double inputNumber = Double.parseDouble(txtNumber);
                double outputNumber = inputNumber * weightBase[index2] / weightBase[index1];
                String txtOutputNumber = Double.toString(Math.round(outputNumber*100.0)/100.0);
                txtResult.setText("Result: " + txtOutputNumber);
            } catch(Exception e){
                Toast.makeText(getContext(), "Đầu vào không hợp lệ",
                        Toast.LENGTH_SHORT).show();
            }
        }

        else if(v.getId() == R.id.button_2){
            String txtNumber = editTextNumber2.getText().toString();

            int index1 = spinner3.getSelectedItemPosition();
            int index2 = spinner4.getSelectedItemPosition();
            try {
                double inputNumber = Double.parseDouble(txtNumber);
                double outputNumber = inputNumber*lengthBase[index2]/lengthBase[index1];
                String txtOutputNumber = Double.toString(Math.round(outputNumber*100.0)/100.0);
                txtResult2.setText("Result: " + txtOutputNumber);
            } catch(Exception e){
                Toast.makeText(getContext(), "Đầu vào không hợp lệ",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}