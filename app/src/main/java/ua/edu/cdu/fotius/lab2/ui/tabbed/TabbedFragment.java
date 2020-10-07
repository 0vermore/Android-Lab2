package ua.edu.cdu.fotius.lab2.ui.tabbed;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import ua.edu.cdu.fotius.lab2.MainActivity;
import ua.edu.cdu.fotius.lab2.R;
import ua.edu.cdu.fotius.lab2.ui.home.HomeFragment;

public class TabbedFragment extends Fragment {

    private TabbedViewModel mViewModel;

    public static TabbedFragment newInstance() {
        return new TabbedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_tabbed, container, false);
        TabLayout tabs = (TabLayout) root.findViewById(R.id.tab_layout);
        final Button button = root.findViewById(R.id.to_home);
        button.setVisibility(View.INVISIBLE);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("Addition")) {
                    button.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                button.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getText().equals("Addition")) {
                    button.setVisibility(View.VISIBLE);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TabbedViewModel.class);
        // TODO: Use the ViewModel
    }

}