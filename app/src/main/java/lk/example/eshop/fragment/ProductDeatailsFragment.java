package lk.example.eshop.fragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

import lk.example.eshop.R;
import lk.example.eshop.adapter.ProductSliderAdapter;
import lk.example.eshop.databinding.FragmentProductDeatailsBinding;
import lk.example.eshop.model.Product;
import lombok.NonNull;


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        getActivity().findViewById(R.id.bottom_navigation_view).setVisibility(View.GONE);

        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Load Product Details

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("products")
                .whereEqualTo("productId", productId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot qds) {
                        if (!qds.isEmpty()) {
                            Product product = qds.getDocuments().get(0).toObject(Product.class);

                            ProductSliderAdapter adapter = new ProductSliderAdapter(product.getImages());
                            binding.productImageSlider.setAdapter(adapter);

                            binding.dotsIndicator.attachTo(binding.productImageSlider);

                            binding.productDetailsTitle.setText(product.getTittle());

                            binding.productDetailsRating.setRating(product.getRating());

                            binding.productDetailsPrice.setText("LKR " + product.getPrice());
                            binding.productDetailsAvbQty.setText(String.valueOf(product.getStockCount()));

                        }
                    }
                });

    }

    @Override
    public void onStop(){
        super.onStop();

        getActivity().findViewById(R.id.bottom_navigation_view).setVisibility(View.VISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.bottom_navigation_view).setVisibility(View.GONE);
    }

}