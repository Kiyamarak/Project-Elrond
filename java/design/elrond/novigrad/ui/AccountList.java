package design.elrond.novigrad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import design.elrond.novigrad.R;
import design.elrond.novigrad.core.BranchAccount;
import design.elrond.novigrad.core.CustomerAccount;
import design.elrond.novigrad.database.BranchListAdapter;
import design.elrond.novigrad.database.CustomerListAdapter;
import design.elrond.novigrad.database.DatabaseReader;
import design.elrond.novigrad.database.ServiceListAdapter;
import design.elrond.novigrad.services.Service;

public class AccountList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);
        DatabaseReader dbAccess = new DatabaseReader();
        final ListView accountList = findViewById(R.id.accountList);

        Intent entryIntent = getIntent();
        String listType = entryIntent.getStringExtra("Type");


        dbAccess.setLister(new DatabaseReader.Lister() {
            @Override
            public void listCustomers(ArrayList<CustomerAccount> customerEntries) {
                ListAdapter adapter = new CustomerListAdapter(AccountList.this,customerEntries);
                accountList.setAdapter(adapter);
            }

            @Override
            public void listBranches(ArrayList<BranchAccount> branchEntries) {
                ListAdapter adapter = new BranchListAdapter(AccountList.this,branchEntries);
                accountList.setAdapter(adapter);

            }
        });

        if (listType.equals("Branch")){
            dbAccess.generateBranchList();
        }else if (listType.equals("Customer")){
            dbAccess.generateCustomerList();
        }

    }
}