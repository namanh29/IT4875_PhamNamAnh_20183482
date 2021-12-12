package com.example.calculatorfragment.ui.convert;

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
import com.example.calculatorfragment.databinding.FragmentConvertBinding;

public class ConvertFragment extends Fragment implements View.OnClickListener{

    //private ConvertViewModel convertViewModel;
    private FragmentConvertBinding binding;

    String[] items = { "Binary", "Octal", "Decimal", "Hex"};
    Integer[] numberBase = {2,8,10,16};
    Spinner spinner1;
    Spinner spinner2;
    EditText editTextNumber;
    Long inputNumber;
    TextView txtResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_convert, container, false);

        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);
        editTextNumber = view.findViewById(R.id.editTextNumber);
        txtResult = view.findViewById(R.id.txtResult);
        view.findViewById(R.id.button).setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
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
                inputNumber = Long.parseLong(txtNumber, numberBase[index1]);
                String txtOutputNumber = Long.toString(inputNumber, numberBase[index2]);
                txtResult.setText("Result: " + txtOutputNumber);
            } catch(Exception e){
                Toast.makeText(getContext(), "Đầu vào không hợp lệ",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}