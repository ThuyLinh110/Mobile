package com.example.middledemo.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middledemo.R;
import com.example.middledemo.model.DogBreed;
import com.example.middledemo.model.DogDao;
import com.example.middledemo.viewmodel.AppDatabase;
import com.example.middledemo.viewmodel.DogAdapter;
import com.example.middledemo.viewmodel.DogApiService;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ListFragment extends Fragment {



    private DogApiService apiService;
    private DogAdapter dogsAdapter;
    private ArrayList<DogBreed> dogBreeds;
    private RecyclerView rvDogs;
    private EditText edSearch ;

    private AppDatabase appDatabase;
    private DogDao dogDAO;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }



    }

    @Override
    public void onViewCreated(@androidx.annotation.NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvDogs = view.findViewById(R.id.rv_dogs);
        dogBreeds = new ArrayList<DogBreed>();
        dogsAdapter = new DogAdapter(dogBreeds);

        rvDogs.setAdapter(dogsAdapter);

        appDatabase = AppDatabase.getInstance(getContext());
        dogDAO = appDatabase.dogDao();

        apiService = new DogApiService();
        apiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                    @Override
                    public void onSuccess(@NonNull List<DogBreed> dogBreedsList) {
                        Log.d("DEBUG1","Success" );

                        List<DogBreed> dogAll = dogDAO.getAll();
                        if (dogAll.size() >0)
                        {
                            for (DogBreed dog : dogAll)
                            {
                                dogDAO.delete(dog);
                            }
                        }

                        for (DogBreed dog:dogBreedsList)
                        {
                            Log.d("DEBUG1",dog.getName());
                            dogBreeds.add(dog);
                            dogDAO.insertAll(dog);

                            dogsAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

        edSearch = view.findViewById(R.id.ed_search);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                apiService.getDogs()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                            @Override
                            public void onSuccess(@NonNull List<DogBreed> dogBreedsList) {
                                dogBreeds.clear();
                                for (DogBreed dog:dogBreedsList)
                                {
                                    if (dog.getName().toLowerCase().contains(edSearch.getText().toString().toLowerCase()))
                                    {
                                        dogBreeds.add(dog);
                                    }
                                    dogsAdapter.notifyDataSetChanged();



                                }
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

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

                Navigation.findNavController(view).navigate(R.id.detailsFragment);
            }
        });


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }


}