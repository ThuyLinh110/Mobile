package com.example.posterapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.posterapp.R;
import com.example.posterapp.databinding.FragmentDetailBinding;
import com.example.posterapp.model.Poster;
import com.example.posterapp.model.PosterDao;
import com.example.posterapp.viewmodel.AppDatabase;

public class DetailFragment extends Fragment {


    private Poster poster;
    private FragmentDetailBinding binding;
    private AppDatabase appDatabase;
    private PosterDao posterDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            poster= (Poster) getArguments().getSerializable("poster");
            Log.d("EEEEEEEEEEEEEEEEE", ""+poster.getId());

        }




    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_detail,null,false);
        View viewRoot = binding.getRoot();
        binding.setPoster(poster);

        return viewRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appDatabase = AppDatabase.getInstance(getContext());
                posterDAO = appDatabase.posterDao();
                posterDAO.delete(poster);
                Bundle bundle = new Bundle();
                Navigation.findNavController(view).navigate(R.id.listFragment, bundle);
            }
        });
    }
}