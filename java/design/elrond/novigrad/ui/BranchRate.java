package design.elrond.novigrad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import design.elrond.novigrad.R;
import design.elrond.novigrad.core.BranchAccount;
import design.elrond.novigrad.core.CustomerAccount;
import design.elrond.novigrad.database.BranchListAdapter;
import design.elrond.novigrad.database.BranchListRateAdapter;
import design.elrond.novigrad.database.CustomerListAdapter;
import design.elrond.novigrad.database.DatabaseReader;
import design.elrond.novigrad.database.DatabaseWriter;
import design.elrond.novigrad.database.ServiceListAdapter;
import design.elrond.novigrad.services.Service;

public class BranchRate extends AppCompatActivity {


    DatabaseReader dbAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_rate);
        dbAccess = new DatabaseReader();
        final ListView branchList = findViewById(R.id.branchList);

        dbAccess.setLister(new DatabaseReader.Lister() {
            @Override
            public void listCustomers(ArrayList<CustomerAccount> customerEntries) {
                ListAdapter adapter = new CustomerListAdapter(BranchRate.this,customerEntries);
                branchList.setAdapter(adapter);
            }

            @Override
            public void listBranches(ArrayList<BranchAccount> branchEntries) {
                ListAdapter adapter = new BranchListRateAdapter(BranchRate.this,branchEntries);
                branchList.setAdapter(adapter);

            }
        });
        dbAccess.generateBranchList();

    }
}