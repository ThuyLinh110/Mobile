package com.example.posterapp.view;

import android.os.Bundle;

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
import android.widget.Button;
import android.widget.EditText;

import com.example.posterapp.R;

import com.example.posterapp.databinding.FragmentListBinding;
import com.example.posterapp.model.Poster;
import com.example.posterapp.model.PosterDao;
import com.example.posterapp.viewmodel.AppDatabase;
import com.example.posterapp.viewmodel.PosterAPIService;
import com.example.posterapp.viewmodel.PosterAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ListFragment extends Fragment {

    private FragmentListBinding binding;

    private PosterAPIService apiService;
    private PosterAdapter PosterAdapter;
    private List<Poster> posters;
    private RecyclerView rvPoster;

    private EditText edSearch ;



    private AppDatabase appDatabase;
    private PosterDao posterDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }

    }

    @Override
    public void onViewCreated(@androidx.annotation.NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPoster = view.findViewById(R.id.rv_poster);
        posters = new ArrayList<Poster>();
        PosterAdapter = new PosterAdapter(posters);

        rvPoster.setAdapter(PosterAdapter);
        appDatabase = AppDatabase.getInstance(getContext());
        posterDAO = appDatabase.posterDao();

//        apiService = new PosterAPIService();
//        apiService.getPosters()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSingleObserver<List<Poster>>() {
//                    @Override
//                    public void onSuccess(@NonNull List<Poster> dogBreedsList) {
//
//
//                        List<Poster> posterAll = posterDAO.getAll();
//                        if (posterAll.size() >0)
//                        {
//                            for (Poster dog : posterAll)
//                            {
//                                posterDAO.delete(dog);
//                            }
//                        }
//
//                        for (Poster dog:dogBreedsList)
//                        {
//                            posterDAO.insertAll(dog);
//                            posters.add(dog);
//                            PosterAdapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//                });



        List<Poster> posterAll = posterDAO.getAll();
        posters.addAll(posterAll);
        PosterAdapter.notifyDataSetChanged();

        edSearch = view.findViewById(R.id.ed_search);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                String name = binding.edSearch.getText().toString();
                if(name !="")
                {
                    posters.clear();
                    List<Poster> poster1 = posterDAO.findByName('%'+name+'%');
                    posters.addAll(poster1);
                    PosterAdapter.notifyDataSetChanged();
                }
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
        binding = FragmentListBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}