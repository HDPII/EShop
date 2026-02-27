package lk.example.eshop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lk.example.eshop.R;
import lk.example.eshop.databinding.FragmentProductDeatailsBinding;


public class ProductDeatailsFragment extends Fragment {

    private FragmentProductDeatailsBinding binding;
    private String productId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            productId = getArguments().getString("productId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProductDeatailsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}