package design.elrond.novigrad.ui;
//package design.elrond.novigrad.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import design.elrond.novigrad.R;
import design.elrond.novigrad.database.BranchListAdapter;
import design.elrond.novigrad.services.Service;

public class ServiceList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);


    }
}