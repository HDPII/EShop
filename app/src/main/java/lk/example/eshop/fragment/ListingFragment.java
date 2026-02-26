package lk.example.eshop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import javax.annotation.Nullable;

import lk.example.eshop.R;
import lk.example.eshop.adapter.ListingAdapter;
import lk.example.eshop.databinding.FragmentListingBinding;
import lk.example.eshop.model.Product;
import lombok.NonNull;

public class ListingFragment extends Fragment {

    private FragmentListingBinding binding;

    private ListingAdapter adapter;

    private String categoryId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryId = getArguments().getString("categyId");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListingBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view , @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerViewListing.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("product")
                .whereEqualTo("categoryId", categoryId)
                .orderBy("tittle" , Query.Direction.ASCENDING)
                .get()
                .addOnSuccessListener( ds ->{
                    if (!ds.isEmpty()){
                        List<Product> products = ds.toObjects(Product.class);
                        adapter = new ListingAdapter(products, product -> {

                        });

                        binding.recyclerViewListing.setAdapter(adapter);

                    }
                });
    }

}