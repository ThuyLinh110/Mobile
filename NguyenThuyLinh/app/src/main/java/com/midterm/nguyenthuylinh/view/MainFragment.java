package com.midterm.nguyenthuylinh.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.midterm.nguyenthuylinh.R;
import com.midterm.nguyenthuylinh.databinding.FragmentMainBinding;
import com.midterm.nguyenthuylinh.model.item;
import com.midterm.nguyenthuylinh.viewmodel.itemAPIService;
import com.midterm.nguyenthuylinh.viewmodel.itemAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private itemAPIService apiService;
    private itemAdapter itemAdapter;
    private List<item> items;
    private RecyclerView rvItem;

    private EditText edSearch ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvItem = view.findViewById(R.id.rv_item);
        items = new ArrayList<item>();
        itemAdapter = new itemAdapter(items);

        rvItem.setAdapter(itemAdapter);

        apiService = new itemAPIService();
        apiService.getItems()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<item>>() {
                    @Override
                    public void onSuccess(@NonNull List<item> itemList) {


                        for (item ite:itemList)
                        {
//                            posterDAO.insertAll(dog);
                            items.add(ite);
                            Log.d("OOOOOOOOOOOOOO",ite.getTitle());
                            itemAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Log.d("EEEEEEEEEEEEEEEEEEEEEEE",e.getMessage());
                    }
                });

        edSearch = view.findViewById(R.id.ed_search);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                apiService.getItems()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<item>>() {
                            @Override
                            public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<item> dogBreedsList) {
                                items.clear();
                                for (item dog:dogBreedsList)
                                {
                                    if (dog.getTitle().toLowerCase().contains(edSearch.getText().toString().toLowerCase()))
                                    {
                                        items.add(dog);
                                    }
                                    itemAdapter.notifyDataSetChanged();



                                }
                            }

                            @Override
                            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                            }
                        });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.detailFragment);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}