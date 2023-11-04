package com.example.findmyclassmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DepartmentArrayAdapter extends ArrayAdapter<Department> {
    public DepartmentArrayAdapter(Context context, int resource, List<Department> departments) {
        super(context, resource, departments);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Customize how the selected item is displayed in the spinner
        Department department = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        TextView departmentName = convertView.findViewById(android.R.id.text1);
        if (department != null) {
            departmentName.setText(department.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Customize how the dropdown items are displayed
        Department department = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
        TextView departmentName = convertView.findViewById(android.R.id.text1);
        if (department != null) {
            departmentName.setText(department.getName());
        }
        return convertView;
    }
}

